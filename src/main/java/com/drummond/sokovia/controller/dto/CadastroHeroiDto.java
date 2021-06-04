package com.drummond.sokovia.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Builder(toBuilder = true)
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastroHeroiDto {

    @NotBlank(message = "O campo é nome obrigatório")
    private String nome;

    @NotBlank(message = "O campo é email obrigatório")
    private String email;

    @NotBlank(message = "O campo é habilidade obrigatório")
    private String habilidade;

    @NotBlank(message = "O campo é genero obrigatório")
    private String genero;

    @NotBlank(message = "O campo é localizacaoAtual obrigatório")
    private String localidade;

    @NotBlank(message = "O campo é origem obrigatório")
    private String origem;
}
