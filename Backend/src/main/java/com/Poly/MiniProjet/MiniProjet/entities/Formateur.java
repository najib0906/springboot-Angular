package com.Poly.MiniProjet.MiniProjet.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Entity
public class Formateur extends User {
	
	@JsonIgnore
	@ManyToMany(mappedBy="formateurs",fetch=FetchType.EAGER )
	private List<Formation> formations;

}
