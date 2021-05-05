package com.drummond.sokovia.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    private String nome;
    private String email;
    private String poder;
    private String localizacao;
    // esse eh mode para criar os herois

}

