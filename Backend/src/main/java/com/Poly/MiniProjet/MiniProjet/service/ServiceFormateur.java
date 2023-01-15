package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Poly.MiniProjet.MiniProjet.dao.FormateurRepository;
import com.Poly.MiniProjet.MiniProjet.dao.FormationRepository;
import com.Poly.MiniProjet.MiniProjet.entities.Formateur;
import com.Poly.MiniProjet.MiniProjet.entities.Formation;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceFormateur implements IServiceFormateur {
	FormateurRepository fr;
	FormationRepository form;

	@Override
	public void supprimerImage(int id) throws IOException {
		// TODO Auto-generated method stub
		Formateur formateur = fr.getById(id);
		
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/image2022";
		Path p = Paths.get(chemin, formateur.getPhoto());
		Files.delete(p);
		
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String nomImage=fr.findById(id).get().getPhoto();
		Path p=Paths.get(System.getProperty("user.dir") + "/src/main/webapp/image2022",nomImage);
		
		return Files.readAllBytes(p);
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		String nameFile =mf.getOriginalFilename();
		String tab[] = nameFile.split("\\.");
		String fileModif = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/image2022";
		Path p = Paths.get(chemin, fileModif);
		Files.write(p, mf.getBytes());
		return fileModif;
	}

	@Override
	public void supprimerFormateur(int id) throws IOException {
		// TODO Auto-generated method stub

		if(fr.getById(id).getPhoto()!=null) {
			supprimerImage(id);
		}
			fr.deleteById(id);
		
	}

	@Override
	public void saveFormateur(Formateur f, MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		 String photo;
			if (!mf.getOriginalFilename().equals("")) {
				photo = saveImage(mf);
				f.setPhoto(photo);
				}
			fr.save(f);
		
	}

	@Override
	public List<Formateur> getAllFormateur() {
		// TODO Auto-generated method stub
		return fr.findAll();
	}

	@Override
	public Formateur getFormateur(int id) {
		// TODO Auto-generated method stub
		return fr.findById(id).get(); 
	}

	@Override
	public List<Formateur> getProfByMC(String mc) {
		// TODO Auto-generated method stub
		return fr.findByPrenomContains(mc);
	}

	@Override
	public void ajouterFormateurFormation(Formation idc, Formateur idp) {
		// TODO Auto-generated method stub
		idc.getFormateurs().add(idp);
		fr.save(idp);
		
	}

	@Override
	public List<Formateur> getByFormation(Formation formation) {
		// TODO Auto-generated method stub
		return fr.findByFormations(formation);
	}


	@Override
	public void saveFormatuersup(Formateur f) {
		// TODO Auto-generated method stub
		fr.save(f);
		
	}

	@Override
	public void annuleFormateurFormation(int idp, int idf) {
		// TODO Auto-generated method stub
		
		Formation formation=form.findById(idf).get();
		int nombreFormateur = formation.getFormateurs().size();
		for(int i = 0; i < nombreFormateur; i++){
			if(formation.getFormateurs().get(i).getId() == idp){
				formation.getFormateurs().remove(i);
				form.save(formation);
				
			}
		}
		
	}


}
