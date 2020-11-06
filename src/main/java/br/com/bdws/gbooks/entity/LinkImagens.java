package br.com.bdws.gbooks.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class LinkImagens extends AbstractEntity{

    private String smallThumbnail;
    private String thumbnail;
}
