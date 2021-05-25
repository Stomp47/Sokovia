package com.drummond.sokovia.controller.dto;

import com.drummond.sokovia.model.Heroi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegistroHeroiMapper {

    public Heroi inputHeroiToHeroi (InputHeroi inputHeroi) {
        return Heroi.builder()
                .nome(inputHeroi.getNome())
                .email(inputHeroi.getEmail())
                .habilidade(inputHeroi.getHabilidade())
                .genero(inputHeroi.getGenero())
                .localizacaoAtual(inputHeroi.getLocalizacaoAtual())
                .origem(inputHeroi.getOrigem())
                .build();
    }

    public InputHeroi heroiToInputHeroi (Heroi heroi) {
        return InputHeroi.builder()
                .nome(heroi.getNome())
                .email(heroi.getEmail())
                .habilidade(heroi.getHabilidade())
                .genero(heroi.getGenero())
                .localizacaoAtual(heroi.getLocalizacaoAtual())
                .origem((heroi.getOrigem()))
                .build();
    }

    public List<InputHeroi> heroiListToInputHeroiList(List<Heroi>herois){
        return herois.stream().map(this::heroiToInputHeroi).collect(Collectors.toList());
    }

}
