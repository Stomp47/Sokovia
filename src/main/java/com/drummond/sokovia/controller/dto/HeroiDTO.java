package com.drummond.sokovia.controller.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroiDTO {

    private String habilidade;

    private String genero;

    private String localizacaoAtual;

    private String origem;
}
