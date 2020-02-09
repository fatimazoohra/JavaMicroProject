package Entities;

import java.math.BigInteger;
import java.util.Date;

public class RV {
	private BigInteger id;
	private Date jour;
	private BigInteger id_client;
	private BigInteger id_creneau;
	
	public RV() {
	}
	public RV(Date jour, BigInteger id_client, BigInteger id_creneau) {
		this.setJour(jour);
		this.setId_client(id_client);
		this.setId_creneau(id_creneau);
	}
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public Date getJour() {
		return jour;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	public BigInteger getId_client() {
		return id_client;
	}
	public void setId_client(BigInteger id_client) {
		this.id_client = id_client;
	}
	public BigInteger getId_creneau() {
		return id_creneau;
	}
	public void setId_creneau(BigInteger id_creneau) {
		this.id_creneau = id_creneau;
	} 
}
