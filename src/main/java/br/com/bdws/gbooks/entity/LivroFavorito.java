package br.com.bdws.gbooks.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "livro_id"))
public class LivroFavorito extends AbstractEntity{

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Livro livro;
}
