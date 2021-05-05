package com.drummond.sokovia.controller;

import com.drummond.sokovia.model.Heroi;
import com.drummond.sokovia.service.RegistroHeroi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registro")

public class RegistroHeroiController {
    private final RegistroHeroi registroHeroi;
@PostMapping
    public ResponseEntity registro(@RequestBody Heroi heroi){
        registroHeroi.criaHeroi(heroi);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
