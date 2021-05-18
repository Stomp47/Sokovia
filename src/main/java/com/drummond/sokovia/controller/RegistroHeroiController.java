package com.drummond.sokovia.controller;

import com.drummond.sokovia.controller.dto.InputHeroi;
import com.drummond.sokovia.controller.dto.RegistroHeroiMapper;
import com.drummond.sokovia.service.RegistroHeroi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registro")
public class RegistroHeroiController {

    private final RegistroHeroi registroHeroi;

    private final RegistroHeroiMapper mapper;

@PostMapping
    public ResponseEntity registro(@Valid @RequestBody InputHeroi inputHeroi){

        var heroi = mapper.inputHeroiToHeroi(inputHeroi);

        registroHeroi.criaHeroi(heroi);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
