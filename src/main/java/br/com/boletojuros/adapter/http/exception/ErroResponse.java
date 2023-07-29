package br.com.boletojuros.adapter.http.exception;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {

    private List<String> mensagens = new ArrayList<>();
    private String error;
    private int codigo;
    private Date timestamp;
    private String path;

}
