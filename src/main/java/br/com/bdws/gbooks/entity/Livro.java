package br.com.bdws.gbooks.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
@Entity
public class Livro extends AbstractEntity {

    private String etag;
    private String classe;
    private String linkProprio;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private InformacaoVolume informacaoVolume;
}
