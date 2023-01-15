package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.util.List;

import com.Poly.MiniProjet.MiniProjet.entities.Classe;


public interface IServiceClasse {

	List<Classe> getAllClasse();

	void saveClasse(Classe p)throws IOException;

	void supprimerClasse(int id);

	Classe getClasse(int id);

}
