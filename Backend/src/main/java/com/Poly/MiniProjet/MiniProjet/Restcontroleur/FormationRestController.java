package com.Poly.MiniProjet.MiniProjet.Restcontroleur;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.Poly.MiniProjet.MiniProjet.entities.Student;
import com.Poly.MiniProjet.MiniProjet.service.IServiceFormateur;
import com.Poly.MiniProjet.MiniProjet.service.IServiceFormation;
import com.Poly.MiniProjet.MiniProjet.service.IServiceStudent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
@AllArgsConstructor

public class FormationRestController {
	
	IServiceFormation sf ;
	IServiceFormateur sformateur ;
	IServiceStudent ss ;
	
	@GetMapping("/allstudent")
	public List<Student> getAllStudents(){
	return ss.getAllStudent();
	}

	@GetMapping("/chercherByMcStudent/{mc}")
	public List<Student> getStudents(@PathVariable ("mc") String mot){
		
		return ss.getStudentByMC(mot);
	}

	@GetMapping(path = "/getImageStudent/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable("id") int id) throws IOException {
		return ss.getImage(id);
	}

	@PostMapping("/addstudent")
	public void saveStudent (@RequestParam("student") String p, @RequestParam("file") MultipartFile mf) throws IOException{
		Student pp = new ObjectMapper().readValue(p, Student.class);
		ss.saveEtudiant(pp,mf);
		
	}

	@DeleteMapping("/deletestudent/{id}")
	public void deleteStudent(@PathVariable int id) throws IOException{
		ss.supprimerStudent(id);
	}

	@PutMapping("/updatestudent")
	public void update(@RequestParam("student") String p, @RequestParam("file") MultipartFile mf) throws IOException {
		saveStudent(p,mf);
	}

}
