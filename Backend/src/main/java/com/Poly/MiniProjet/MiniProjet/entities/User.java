package com.Poly.MiniProjet.MiniProjet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String prenom;
	private String nom;
	@Column(unique=true)
	private String cin;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String telephone;
	private String photo;
	private String role;

}
