package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Poly.MiniProjet.MiniProjet.dao.FormateurRepository;
import com.Poly.MiniProjet.MiniProjet.dao.FormationRepository;
import com.Poly.MiniProjet.MiniProjet.entities.Formateur;
import com.Poly.MiniProjet.MiniProjet.entities.Formation;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class ServiceFormation implements IServiceFormation {
	FormationRepository fr;
	

	@Override
	public void saveFormation(Formation f) throws IOException {
		// TODO Auto-generated method stub
		fr.save(f);
	}

	@Override
	public List<Formation> getAllFormation() {
		// TODO Auto-generated method stub
		return fr.findAll();
	}

	@Override
	public Formation getFormation(int id) {
		// TODO Auto-generated method stub
		return fr.findById(id).get();
	}
	public Formation mettreAjourCour(Formation f ) {
		
		return fr.save(f);		
	}

	@Override
	public void supprimerFormation(int id) {
		// TODO Auto-generated method stub
		fr.deleteById(id);
		
	}

	@Override
	public List<Formation> getByFormateur(Formateur formateur) {
		// TODO Auto-generated method stub
		return fr.findByFormateurs(formateur);
	}

}
