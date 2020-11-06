package br.com.bdws.gbooks.viewObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntityExceptionVO {
    private String url;
    private String message;
}
