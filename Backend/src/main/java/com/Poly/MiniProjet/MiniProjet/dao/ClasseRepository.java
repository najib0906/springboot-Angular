package com.Poly.MiniProjet.MiniProjet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Poly.MiniProjet.MiniProjet.entities.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer>{
	

}
