package com.drummond.sokovia.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputHeroi {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String poder;

    @NotBlank
    private String localizacao;
}
