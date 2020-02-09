package DAO;

import java.util.List;

import Entities.Medecin;

public interface MedecinDAO {
	public List<Medecin> getMedecins();
	public void ajouterMedecin(Medecin medecin);
	public void ModifierMedecin(Medecin medecin);
	public void SupprimerMedecin(Medecin medecin);
}
