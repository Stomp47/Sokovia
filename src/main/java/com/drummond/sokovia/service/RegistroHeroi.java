package com.drummond.sokovia.service;

import com.drummond.sokovia.controller.dto.CadastroHeroiDto;
import com.drummond.sokovia.controller.dto.HeroiDTO;
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

    public Heroi criaHeroi(CadastroHeroiDto inputHeroi) {

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

    public List<CadastroHeroiDto> heroisCadastrados() {

        var herois = heroiRepository.findAll();

        return mapper.heroiListToInputHeroiList(herois);
    }

    public CadastroHeroiDto achaHeroiPorNome(String nome) {

        var heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(() -> new HeroiCadastradoException("Heroi não encontrado"));

        return mapper.heroiToInputHeroi(heroiSalvo);
    }

    public void apagarRegistroHeroi(String nome) {
        var heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(() -> new HeroiCadastradoException("Heroi não encontrado"));
        heroiRepository.delete(heroiSalvo);
    }

    public Heroi atualizarHeroi(String nome, HeroiDTO heroi) {

        var heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(() -> new HeroiCadastradoException("Heroi não encontrado"));

        heroiSalvo.setGenero(heroi.getGenero());
        heroiSalvo.setHabilidade(heroi.getHabilidade());
        heroiSalvo.setLocalizacaoAtual(heroi.getLocalizacaoAtual());
        heroiSalvo.setOrigem(heroi.getOrigem());

        heroiRepository.save(heroiSalvo);

        return heroiSalvo;
    }

}
