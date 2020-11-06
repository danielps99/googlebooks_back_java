package br.com.bdws.gbooks.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class InformacaoVolume extends AbstractEntity {

    private String titulo;
    private String editora;
    private String dataPublicacao;
    private String quantidadePaginas;
    private String tipoImpressao;
    private String avaliacaoMedia;
    private String quantidadeAvaliacoes;
    private String maturidade;
    private String permitirAcessoAnonimo;
    private String versaoConteudo;

    @Column(columnDefinition = "text")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IdentificacaoIndustrial> identificadoresIndustriais;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private LinkImagens linkImagens;

}
