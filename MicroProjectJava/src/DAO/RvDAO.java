package DAO;



import java.sql.Date;

import Entities.Creneau;
import Entities.RV;

public interface RvDAO {
	public void AjouterRV(Date date, int id_client, Creneau creneau);
	public void SupprimerRV(RV rv);
	public void ModifierRV(RV rv);
	
}
