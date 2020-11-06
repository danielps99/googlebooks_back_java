package br.com.bdws.gbooks.service;

import br.com.bdws.gbooks.entity.Livro;
import br.com.bdws.gbooks.entity.LivroFavorito;
import br.com.bdws.gbooks.exception.GenericException;
import br.com.bdws.gbooks.repository.ILivroFavoritoRepository;
import br.com.bdws.gbooks.viewObject.LivroFavoritoVO;
import br.com.bdws.gbooks.viewObject.ResultPageVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroFavoritoService {

    @Autowired
    private ILivroFavoritoRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public void criarFavorito(LivroFavoritoVO vo) {
        LivroFavorito livroFavorito = modelMapper.map(vo, LivroFavorito.class);
        if (!hasLivroEmLivroFavorito(livroFavorito.getLivro())) {
            livroFavorito.gerarId();
            repository.save(livroFavorito);
        }
    }

    public boolean hasLivroEmLivroFavorito(Livro livro){
        return repository.findByLivroId(livro.getId()).isPresent();
    }

    public ResultPageVO<LivroFavoritoVO> listarFavoritos(String pesquisa, int pagina, int maxResultado){
        Pageable pageable = PageRequest.of(pagina, maxResultado);
        Page<LivroFavorito> pageLivrosFavoritos = repository.findByLivroInformacaoVolumeTituloContainingIgnoreCase(pesquisa,pageable);

        List<LivroFavoritoVO> livrosFavoritos = pageLivrosFavoritos.getContent().stream()
                .map(livro -> modelMapper.map(livro, LivroFavoritoVO.class)).collect(Collectors.toList());

        return new ResultPageVO(pageLivrosFavoritos.getTotalElements(), livrosFavoritos);
    }

    public void removerFavorito(String favoritoId) {
        try {
            repository.deleteById(favoritoId);
        } catch (EmptyResultDataAccessException e){
            throw new GenericException("Favorito não encontrado");
        }
    }

    public List<LivroFavorito> findByLivroIdIn(List<String> livrosIds){
        return repository.findByLivroIdIn(livrosIds);
    }
}
