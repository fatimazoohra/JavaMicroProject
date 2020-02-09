package Entities;

import java.math.BigInteger;

public class Client {
	
	private BigInteger id;
	private int version;
	private String titre;
	private String nom;
	private String prenom;
	
	public Client(int version, String titre, String nom, String prenom) {
		this.setVersion(version);
		this.setTitre(titre);
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
