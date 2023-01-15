package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.util.List;

import com.Poly.MiniProjet.MiniProjet.entities.Formateur;
import com.Poly.MiniProjet.MiniProjet.entities.Formation;


public interface IServiceFormation {
	public void saveFormation(Formation f)throws IOException;

	List<Formation> getAllFormation();

	Formation getFormation(int id);

	void supprimerFormation(int id);

	List<Formation> getByFormateur(Formateur formateur);
	

}
