package com.drummond.sokovia.controller;

import com.drummond.sokovia.controller.dto.CadastroHeroiDto;
import com.drummond.sokovia.controller.dto.HeroiDTO;
import com.drummond.sokovia.model.Heroi;
import com.drummond.sokovia.service.RegistroHeroi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tratadoSokovia")
public class RegistroHeroiController {

    private final RegistroHeroi registroHeroi;

    @PostMapping("/registro")
    public ResponseEntity registro(@Valid @RequestBody CadastroHeroiDto heroi) {

        registroHeroi.criaHeroi(heroi);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/cadastro")
    public ResponseEntity heroisCadastrados() {

        List<CadastroHeroiDto> heroisCadastrados = registroHeroi.heroisCadastrados();

        if(heroisCadastrados.isEmpty() || heroisCadastrados() == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(heroisCadastrados);
    }

    @GetMapping("/cadastro/nome")
    public ResponseEntity acharNome(@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(registroHeroi.achaHeroiPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity apagarRegistro(@RequestParam String nome) {
        registroHeroi.apagarRegistroHeroi(nome);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity teste (@RequestParam String nome, @RequestBody HeroiDTO heroiDTO){
        Heroi heroi = registroHeroi.atualizarHeroi(nome,heroiDTO);

        return ResponseEntity.status(HttpStatus.OK).body(heroi);
    }
}