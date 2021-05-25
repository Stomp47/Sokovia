package com.drummond.sokovia.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputHeroi {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String habilidade;

    @NotBlank
    private String genero;

    @NotBlank
    private String localizacaoAtual;

    @NotBlank
    private String origem;
}
