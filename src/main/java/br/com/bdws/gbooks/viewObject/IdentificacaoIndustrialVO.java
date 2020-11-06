package br.com.bdws.gbooks.viewObject;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class IdentificacaoIndustrialVO implements IViewObject {
    @JsonAlias("type")
    private String tipo;
    @JsonAlias("identifier")
    private String identificador;
}
