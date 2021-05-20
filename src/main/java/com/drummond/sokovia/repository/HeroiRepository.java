package com.drummond.sokovia.repository;

import com.drummond.sokovia.model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {

    @Query("SELECT hr FROM Heroi hr WHERE hr.nome=?1 ")
    Optional<Heroi> achaPorNome(String nome);

}
