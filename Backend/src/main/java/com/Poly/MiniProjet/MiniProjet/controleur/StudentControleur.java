package com.Poly.MiniProjet.MiniProjet.controleur;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Poly.MiniProjet.MiniProjet.entities.Classe;
import com.Poly.MiniProjet.MiniProjet.entities.Formateur;
import com.Poly.MiniProjet.MiniProjet.entities.Formation;
import com.Poly.MiniProjet.MiniProjet.entities.Student;
import com.Poly.MiniProjet.MiniProjet.service.IServiceClasse;
import com.Poly.MiniProjet.MiniProjet.service.IServiceFormateur;
import com.Poly.MiniProjet.MiniProjet.service.IServiceFormation;
import com.Poly.MiniProjet.MiniProjet.service.IServiceStudent;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/formation")
@AllArgsConstructor
public class StudentControleur {
	
	IServiceStudent ss;
	IServiceClasse sc;
	IServiceFormation sf;
	IServiceFormateur sformateur ;
//	IServiceExamen se;
	
	@GetMapping("/home")
	public String home()
{
	
	return "home";
}
@GetMapping("/allstudent")
	public String listeStudent (Model m)
{ 
	List<Classe>liste=sc.getAllClasse();
     m.addAttribute("classe",liste);
	List<Student>listestudent=ss.getAllStudent();
	
	m.addAttribute("students",listestudent);
	return "listeStudent";
}

@GetMapping("/supprimerstudent/{id}")
public String suprrimerStudent(@PathVariable int id ) throws IOException {
	ss.supprimerStudent(id);
	return "redirect:/formation/allstudent";
}


@GetMapping("/ajouterstudent")
public String ajouterStudent(Model m) {
	m.addAttribute("classe",sc.getAllClasse());
	m.addAttribute("formation",sf.getAllFormation());
	return "ajouterStudent";
}

@PostMapping("/savestudent")
public String saveStudent(@ModelAttribute Student s,@RequestParam("file") MultipartFile mf,Model m )throws IOException  {
	Integer id =s.getId();
	ss.saveEtudiant(s, mf);
	if(id!=null) {
		return "redirect:/formation/allstudent";
	}
	else
	{
		m.addAttribute("message","Ajout Avec succes");
		m.addAttribute("classe",sc.getAllClasse());
		m.addAttribute("formation",sf.getAllFormation());
		return "ajouterStudent";
	}
}

@GetMapping("/modifierstudent/{ids}")
public String modifierEtudiant(Model m,@PathVariable("ids") int id) {
	m.addAttribute("classe",sc.getAllClasse());
	m.addAttribute("formation",sf.getAllFormation());
	m.addAttribute("student",ss.getStudent(id));
	return "ajouterStudent";
	
}

@GetMapping("/studentmc")
public String studentmc(@RequestParam String mc , Model m) {
	List<Student>liste=ss.getStudentByMC(mc);
	m.addAttribute("students",liste);
	return "listeStudent";
}
@GetMapping("/supprimerclasse/{id}")
public String suprrimerClasse(@PathVariable int id ) throws IOException {
	Classe classe=sc.getClasse(id);
	List<Student> student=ss.getByClasse(classe);
	
	for(Student i:student) {
		
		i.setClasse(null);
		ss.saveEtudiantsup(i);
	}
	sc.supprimerClasse(id);
	return "redirect:/formation/allclasse";
}

@GetMapping("/ajouterclasse")
public String ajouterClasse()
{

	return "ajouterClasse";
}


@PostMapping("/saveclasse")
public String saveclasse (@ModelAttribute Classe p,Model m )throws IOException  {
	Integer id =p.getId();
	sc.saveClasse(p);
	if(id!=null) {
		return "redirect:/formation/allclasse";
	}
	else
	{
		m.addAttribute("message","Ajout Avec succes");
		return "ajouterClasse";
	}
}


@GetMapping("/modifierclasse/{idc}")
public String modifierClasse(Model m,@PathVariable("idc") int id) {
	
	
	m.addAttribute("classe",sc.getClasse(id));
	return "ajouterClasse";
}


@GetMapping("/filtreclasse")
public String examenclasse(@RequestParam Classe classe , Model m) {
	
	List<Classe>liste=sc.getAllClasse();
	m.addAttribute("classe",liste);
	if(classe!=null) {
		List<Student>listes=ss.getByClasse(classe);
		
		m.addAttribute("students",listes);
		return "listeStudent";
		
	}
	else {
List<Student>listes=ss.getAllStudent();
		
		m.addAttribute("student",listes);
	return"redirect:/formation/allstudent";	
}
	}




@GetMapping("/allclasse")
public String listeclasse(Model m)
{
List<Classe>listeclasse=sc.getAllClasse();
m.addAttribute("classes",listeclasse);
return "listeClasse";
}

@GetMapping("/allformateur")
public String listeProf(Model m)
{
List<Formateur>liste=sformateur.getAllFormateur();
m.addAttribute("formateurs",liste);
return "listeFormateur";
}
@GetMapping("/supprimerformateur/{id}")
public String suprrimerProf(@PathVariable int id ) throws IOException {
	sformateur.supprimerFormateur(id);
	return "redirect:/formation/allformateur";
}
	@PostMapping("/saveformateur")
	public String saveFormateur (@ModelAttribute Formateur f,@RequestParam("file") MultipartFile mf,Model m )throws IOException  {
		Integer id =f.getId();
		sformateur.saveFormateur(f, mf);
		if(id!=null) {
			return "redirect:/formation/allformateur";
		}
		else
		{
			m.addAttribute("message","Ajout Avec succes");
			
			m.addAttribute("formation",sf.getAllFormation());
			return "ajouterFormateur";
		}
}
	@GetMapping("/modifierformateur/{idp}")
	public String modifierFormateur(Model m,@PathVariable("idp") int id) {
		
		m.addAttribute("formation",sf.getAllFormation());
		m.addAttribute("formateur",sformateur.getFormateur(id));
		return "ajouterFormateur";
	}
	
	@GetMapping("/formateurmc")
	public String profmc(@RequestParam String mc , Model m) {
		List<Formateur>liste=sformateur.getProfByMC(mc);
		m.addAttribute("formateurs",liste);
		return "listeFormateur";
	}
	
	@GetMapping("/filtreformateur")
	public String affecterformation(@RequestParam Formateur formateur , Model m) {
		List<Formateur>listeformation=sformateur.getAllFormateur();
		m.addAttribute("formateur",listeformation);
		
		if(formateur!=null) {
			List<Formation>liste=sf.getByFormateur(formateur);
			Formateur formateurr=sformateur.getFormateur(formateur.getId());
			m.addAttribute("formateurr",formateurr);
			m.addAttribute("formation",liste);
			return "listeAffecter";
			
		}
		else {
			
		return"redirect:/formation/allaffecter";	
	}
		}
	
	
	@GetMapping("/ajouterformateur")
	public String ajoutFormateur(Model m) {
		
		m.addAttribute("formation",sf.getAllFormation());
		return "ajouterFormateur";
	}
	
	
	@GetMapping("/allformation")
	public String listeFormation(Model m)
	{
	List<Formation>liste=sf.getAllFormation();
	m.addAttribute("formations",liste);
	return "listeFormation";
	}
	@GetMapping("/supprimerformation/{id}")
	public String suprrimerFormation(@PathVariable int id ) throws IOException {
		sf.supprimerFormation(id);
		return "redirect:/formation/allformation";
	}
	
	@GetMapping("/ajouterformation")
	public String ajouterformation()
	{

	return "ajouterFormation";
	}

	@PostMapping("/saveformation")
	public String saveFormation (@ModelAttribute Formation f,Model m )throws IOException  {
		Integer id =f.getId();
		sf.saveFormation(f);
		if(id!=null) {
			return "redirect:/formation/allformation";
		}
		else
		{
			m.addAttribute("message","Ajout Avec succes");
			return "ajouterFormation";
		}
	}
	@GetMapping("/modifierformation/{idc}")
	public String modifierFormation(Model m,@PathVariable("idc") int id) {
		m.addAttribute("formation",sf.getFormation(id));
		return "ajouterFormation";
	}
	
	@GetMapping("/affecterformation")
	public String affecterFormation(Model m) {
		List<Formateur>listefr=sformateur.getAllFormateur();
		m.addAttribute("formateur",listefr);
		List<Formation>liste=sf.getAllFormation();
		m.addAttribute("formation",liste);
		
		return "affecterFormation";
}
	
	@PostMapping("/saveaffecter")
	public String affecterFormation (@RequestParam Formation formation,@RequestParam Formateur formateur,Model m )throws IOException  {
	sformateur.ajouterFormateurFormation(formation, formateur);
	List<Formateur>listeformateur=sformateur.getAllFormateur();
	m.addAttribute("formateur",listeformateur);
	List<Formation>liste=sf.getAllFormation();
	m.addAttribute("formation",liste);
	return "affecterFormation";
	}
	
	@GetMapping("/allaffecter")
	public String listeAffecter(Model m)
	{
	List<Formation>liste=sf.getAllFormation();
	m.addAttribute("formations",liste);
	List<Formateur>listeformateur=sformateur.getAllFormateur();
	m.addAttribute("formateur",listeformateur);
	return "listeAffecter";
	}
	@GetMapping("/desaffecterformation/{idp}/{idc}")
	public String desaffecterFormation(@PathVariable int idp,@PathVariable int idc ) throws IOException {
	sformateur.annuleFormateurFormation(idp,idc);
		return "redirect:/formation/allaffecter";
	}
}
