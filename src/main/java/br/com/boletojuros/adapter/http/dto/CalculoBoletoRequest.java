package br.com.boletojuros.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CalculoBoletoRequest {

    @NotNull
    private String codigo;

    @NotNull
    @JsonProperty("data_pagamento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

}
