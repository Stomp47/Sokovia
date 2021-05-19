package com.drummond.sokovia.controller.dto;

import com.drummond.sokovia.model.Heroi;
import org.springframework.stereotype.Component;

@Component
public class RegistroHeroiMapper {

    public Heroi inputHeroiToHeroi(InputHeroi inputHeroi){
        return Heroi.builder()
                .nome(inputHeroi.getNome())
                .email(inputHeroi.getEmail())
                .poder(inputHeroi.getPoder())
                .localizacao(inputHeroi.getLocalizacao())
                .build();
    }

}
