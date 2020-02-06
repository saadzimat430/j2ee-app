package com.app.beans;

import com.app.hash.SimpleMD5;

public class Utilisateur {
	private int id;
	private String email;
	private String nom;
	private String prenom;
	private String password;
	private String role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = SimpleMD5.SimpleMD5Example(password);
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
