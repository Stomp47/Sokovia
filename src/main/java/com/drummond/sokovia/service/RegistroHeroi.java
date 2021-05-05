package com.drummond.sokovia.service;

import com.drummond.sokovia.model.Heroi;
import com.drummond.sokovia.repository.HeroiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RegistroHeroi {

    private final HeroiRepository heroiRepository;

    public Heroi criaHeroi(Heroi heroi){
        return heroiRepository.save(heroi);

    }

}
