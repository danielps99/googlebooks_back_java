package br.com.bdws.gbooks.viewObject;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class InformacaoVolumeVO implements IViewObject {
    @JsonAlias("title")
    private String titulo;
    @JsonAlias("publisher")
    private String editora;
    @JsonAlias("publishedDate")
    private String dataPublicacao;
    @JsonAlias("description")
    private String descricao;
    @JsonAlias("industryIdentifiers")
    private List<IdentificacaoIndustrialVO> identificadoresIndustriais;
    @JsonAlias("pageCount")
    private String quantidadePaginas;
    @JsonAlias("printType")
    private String tipoImpressao;
    @JsonAlias("averageRating")
    private String avaliacaoMedia;
    @JsonAlias("ratingsCount")
    private String quantidadeAvaliacoes;
    @JsonAlias("maturityRating")
    private String maturidade;
    @JsonAlias("allowAnonLogging")
    private String permitirAcessoAnonimo;
    @JsonAlias("contentVersion")
    private String versaoConteudo;
    @JsonAlias("imageLinks")
    private LinkImagensVO linkImagens;
}
