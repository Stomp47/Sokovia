package com.drummond.sokovia.service;

import com.drummond.sokovia.controller.dto.InputHeroi;
import com.drummond.sokovia.controller.dto.RegistroHeroiMapper;
import com.drummond.sokovia.model.Heroi;
import com.drummond.sokovia.repository.HeroiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroHeroi {

    private final HeroiRepository heroiRepository;

    private final RegistroHeroiMapper mapper;

    public Heroi criaHeroi(InputHeroi inputHeroi) {

        heroiExistente(inputHeroi.getNome());

        var heroi = mapper.inputHeroiToHeroi(inputHeroi);

        return heroiRepository.save(heroi);
    }

    public void heroiExistente(String nome) {
        var heroiSalvo = heroiRepository.achaPorNome(nome);

        if (heroiSalvo.isPresent()) {
            throw new HeroiCadastradoException("Heroi já cadastrado no sistema");
        }

    }

    public List<InputHeroi> heroisCadastrados() {

        var herois = heroiRepository.findAll();

        return mapper.heroiListToInputHeroiList(herois);
    }

    public InputHeroi achaHeroiPorNome(String nome) {

        var heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(()-> new HeroiCadastradoException("Heroi não encontrado"));

        var heroi = mapper.heroiToInputHeroi(heroiSalvo);

        return heroi;
    }

}
