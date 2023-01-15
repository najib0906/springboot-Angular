package com.Poly.MiniProjet.MiniProjet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Poly.MiniProjet.MiniProjet.entities.Classe;
import com.Poly.MiniProjet.MiniProjet.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByClasse(Classe classe );
	List<Student> findByPrenomContains(String mc);

}
