package br.com.bdws.gbooks.viewObject;

import lombok.Data;

@Data
public class LinkImagensVO implements IViewObject {
    private String smallThumbnail;
    private String thumbnail;
}
