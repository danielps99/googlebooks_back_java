package br.com.bdws.gbooks.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
@Embeddable
public abstract class AbstractEntity implements Serializable {

    @Id
    protected String id;

    public AbstractEntity() {
        gerarId();
    }

    public void gerarId(){
        if (id == null){
            id = UUID.randomUUID().toString();
        }
    }
}
