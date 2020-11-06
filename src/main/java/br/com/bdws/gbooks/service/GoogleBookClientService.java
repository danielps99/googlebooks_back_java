package br.com.bdws.gbooks.service;

import br.com.bdws.gbooks.entity.LivroFavorito;
import br.com.bdws.gbooks.exception.SupportGenericException;
import br.com.bdws.gbooks.viewObject.LivroVO;
import br.com.bdws.gbooks.viewObject.ResultPageVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleBookClientService {

    @Autowired
    LivroFavoritoService livroFavoritoService;

    private final String urlApi = "https://www.googleapis.com/books/v1/volumes";
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public ResultPageVO<LivroVO> buscarLivros(String pesquisa, int pagina, int maxResult){
        try {
            String urlRequisicao = String.format("%s?q=%s&startIndex=%d&maxResults=%d", urlApi, pesquisa, pagina, maxResult);
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(urlRequisicao))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            ResultPageVO<LivroVO> livroVOResultPageVO = objectMapper.readValue(response.body(), new TypeReference<ResultPageVO<LivroVO>>() {});
            atribuirFavoritAosLivrosFavoritos(livroVOResultPageVO.getItens());
            return livroVOResultPageVO;
        } catch (IOException | InterruptedException e) {
            throw new SupportGenericException(e.getMessage());
        }
    }

    private void atribuirFavoritAosLivrosFavoritos(List<LivroVO> livros){
        List<String> livrosIds = livros.stream().map(LivroVO::getId).collect(Collectors.toList());
        List<LivroFavorito> favoritos = livroFavoritoService.findByLivroIdIn(livrosIds);
        for (LivroVO livro : livros) {
            if (favoritos.stream().anyMatch(favorito -> favorito.getLivro().getId().equals(livro.getId()))) {
                livro.setFavorit(true);
            }
        }
    }
}
