package com.drummond.sokovia.service;

import com.drummond.sokovia.controller.dto.CadastroHeroiDto;
import com.drummond.sokovia.controller.dto.HeroiDTO;
import com.drummond.sokovia.controller.dto.RegistroHeroiMapper;
import com.drummond.sokovia.controller.exception.HeroiCadastradoException;
import com.drummond.sokovia.model.Heroi;
import com.drummond.sokovia.repository.HeroiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistroHeroi {

    private final HeroiRepository heroiRepository;

    private final RegistroHeroiMapper mapper;

    public void criaHeroi(CadastroHeroiDto inputHeroi) {

        heroiExistente(inputHeroi.getNome());

        Heroi heroi = mapper.inputHeroiToHeroi(inputHeroi);

        heroiRepository.save(heroi);
    }

    public void heroiExistente(String nome) {

        Optional<Heroi> heroiSalvo = heroiRepository.achaPorNome(nome);

        if (heroiSalvo.isPresent()) {
            throw new HeroiCadastradoException("Heroi já cadastrado no sistema");
        }

    }

    public List<CadastroHeroiDto> heroisCadastrados() {

        List<Heroi> herois = heroiRepository.findAll();

        return mapper.heroiListToInputHeroiList(herois);
    }

    public CadastroHeroiDto achaHeroiPorNome(String nome) {

        Heroi heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(() -> new HeroiCadastradoException("Heroi não encontrado"));

        return mapper.heroiToInputHeroi(heroiSalvo);
    }

    public void apagarRegistroHeroi(String nome) {
        Heroi heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(() -> new HeroiCadastradoException("Heroi não encontrado"));
        heroiRepository.delete(heroiSalvo);
    }

    public Heroi atualizarHeroi(String nome, HeroiDTO heroi) {

        Heroi heroiSalvo = heroiRepository.achaPorNome(nome)
                .orElseThrow(() -> new HeroiCadastradoException("Heroi não encontrado"));

        if(!heroi.getEmail().equals("")){
            heroiSalvo.setEmail(heroi.getEmail());
        }

        if(!heroi.getHabilidade().equals("") ){
           heroiSalvo.setHabilidade(heroi.getHabilidade());
        }

        if(!heroi.getGenero().equals("") ){
            heroiSalvo.setGenero(heroi.getGenero());
        }

        if(!heroi.getLocalidade().equals("")){
            heroiSalvo.setLocalidade(heroi.getLocalidade());
        }
        if(!heroi.getOrigem().equals("")){
            heroiSalvo.setOrigem(heroi.getOrigem());
        }

        heroiRepository.save(heroiSalvo);

        return heroiSalvo;
    }

}
