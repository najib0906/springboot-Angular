package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Poly.MiniProjet.MiniProjet.entities.Formateur;
import com.Poly.MiniProjet.MiniProjet.entities.Formation;


public interface IServiceFormateur {
	
	void supprimerImage(int id) throws IOException;

	byte[] getImage(int id) throws IOException;

	String saveImage(MultipartFile mf) throws IOException;

	void supprimerFormateur(int id) throws IOException;
	void saveFormateur(Formateur f,MultipartFile mf)throws IOException;
	List<Formateur> getAllFormateur();

	Formateur getFormateur(int id);

	List<Formateur> getProfByMC(String mc);

	void ajouterFormateurFormation(Formation idc, Formateur idp);

	List<Formateur> getByFormation(Formation formation);
	void saveFormatuersup(Formateur f);




	void annuleFormateurFormation(int idp, int idc);

}
