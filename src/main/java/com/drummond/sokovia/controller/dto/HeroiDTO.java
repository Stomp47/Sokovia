package com.drummond.sokovia.controller.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroiDTO {

    private String email;

    private String habilidade;

    private String genero;

    private String localidade;

    private String origem;
}
