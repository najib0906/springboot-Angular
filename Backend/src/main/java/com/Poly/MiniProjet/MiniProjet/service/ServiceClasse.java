package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Poly.MiniProjet.MiniProjet.dao.ClasseRepository;
import com.Poly.MiniProjet.MiniProjet.entities.Classe;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceClasse implements IServiceClasse{
	ClasseRepository cr;

	@Override
	public List<Classe> getAllClasse() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public void saveClasse(Classe c) throws IOException {
		// TODO Auto-generated method stub
		cr.save(c);
		
	}

	@Override
	public void supprimerClasse(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public Classe getClasse(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

}
