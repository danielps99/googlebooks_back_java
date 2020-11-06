package br.com.bdws.gbooks.viewObject;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class LivroVO implements IViewObject {
    private String id;
    private String etag;
    @JsonAlias("kind")
    private String classe;
    @JsonAlias("selfLink")
    private String linkProprio;
    @JsonAlias("volumeInfo")
    private InformacaoVolumeVO informacaoVolume;
    private boolean favorit;
}
