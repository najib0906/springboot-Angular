package com.Poly.MiniProjet.MiniProjet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Poly.MiniProjet.MiniProjet.entities.Formateur;
import com.Poly.MiniProjet.MiniProjet.entities.Formation;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Integer> {
	List<Formateur> findByPrenomContains(String mc);
    List<Formateur> findByFormations(Formation idc);
}
