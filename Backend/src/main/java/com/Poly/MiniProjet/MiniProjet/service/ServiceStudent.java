package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.Poly.MiniProjet.MiniProjet.dao.StudentRepository;
import com.Poly.MiniProjet.MiniProjet.entities.Classe;
import com.Poly.MiniProjet.MiniProjet.entities.Student;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ServiceStudent implements IServiceStudent {
	StudentRepository sr ;

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return sr.findById(id).get();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public List<Student> getByClasse(Classe classe) {
		// TODO Auto-generated method stub
		return sr.findByClasse(classe);
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String nomImage=sr.findById(id).get().getPhoto();
		Path p=Paths.get(System.getProperty("user.dir") + "/src/main/webapp/image2022",nomImage);
		
		return Files.readAllBytes(p);
	}

	@Override
	public void supprimerImage(int id) throws IOException {
		// TODO Auto-generated method stub
		Student student = sr.getById(id);
		
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/image2022";
		Path p = Paths.get(chemin, student.getPhoto());
		Files.delete(p);
		
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
	public void supprimerStudent(int id) throws IOException {
		// TODO Auto-generated method stub
		if(sr.getById(id).getPhoto()!=null) {
			supprimerImage(id);
		}
			sr.deleteById(id);
		
	}

	@Override
	public void saveEtudiant(Student s, MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		 String photo;
			if (!mf.getOriginalFilename().equals("")) {
				photo = saveImage(mf);
				s.setPhoto(photo);
				}
			sr.save(s);
			}
	public void saveStudentsup(Student s) {
		 
			sr.save(s);
		
	}

	@Override
	public List<Student> getStudentByMC(String mc) {
		// TODO Auto-generated method stub
		return sr.findByPrenomContains(mc);
	}

	@Override
	public void saveEtudiantsup(Student s) {
		// TODO Auto-generated method stub
		sr.save(s);
		
	}

}
