package br.com.bdws.gbooks.repository;

import br.com.bdws.gbooks.entity.LivroFavorito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILivroFavoritoRepository extends JpaRepository<LivroFavorito, String> {

    Optional<LivroFavorito> findByLivroId(String id);

    Page<LivroFavorito> findByLivroInformacaoVolumeTituloContainingIgnoreCase(String pesquisa, Pageable pageable);

    List<LivroFavorito> findByLivroIdIn(List<String> livrosIds);
}
