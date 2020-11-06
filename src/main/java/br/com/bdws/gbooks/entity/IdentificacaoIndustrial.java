package br.com.bdws.gbooks.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class IdentificacaoIndustrial extends AbstractEntity {

    private String tipo;
    private String identificador;
}
