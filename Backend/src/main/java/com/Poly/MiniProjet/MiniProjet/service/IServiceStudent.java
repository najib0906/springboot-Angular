package com.Poly.MiniProjet.MiniProjet.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Poly.MiniProjet.MiniProjet.entities.Classe;
import com.Poly.MiniProjet.MiniProjet.entities.Student;

public interface IServiceStudent {
	
	Student getStudent(int id);
	List<Student> getAllStudent();
	List<Student> getByClasse(Classe classe);
	
	byte[] getImage(int id) throws IOException;
	void supprimerImage(int id) throws IOException;
	String saveImage(MultipartFile mf) throws IOException;
	void supprimerStudent(int id) throws IOException;
	 void saveEtudiant(Student s,MultipartFile mf)throws IOException;
	List<Student> getStudentByMC(String mc);
	void saveEtudiantsup(Student s);

}
