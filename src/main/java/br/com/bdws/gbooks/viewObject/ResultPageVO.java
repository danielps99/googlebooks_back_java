package br.com.bdws.gbooks.viewObject;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResultPageVO<T> implements IViewObject {
    @JsonAlias("kind")
    private String classe;
    @JsonAlias("totalItems")
    private Long total;
    @JsonAlias({"items", "content"})
    private List<T> itens;

    public ResultPageVO(Long total, List<T> itens) {
        this.total = total;
        this.itens = itens;
    }
}
