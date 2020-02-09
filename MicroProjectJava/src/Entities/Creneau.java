package Entities;

import java.math.BigInteger;

public class Creneau {
	private BigInteger id;
	private int version;
	private int hdebut;
	private int mdebut;
	private int hfin;
	private int mfin;
	private int id_medecin;
	
	public Creneau() {
	}
	
	public Creneau(int version, int hdebut, int mdebut, int hfin, int mfin, int id_medecin) {
		this.setVersion(version);
		this.setHdebut(hdebut);
		this.setMdebut(mdebut);
		this.setHfin(hfin);
		this.setHfin(hfin);
		this.setId_medecin(id_medecin);
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
	public int getHdebut() {
		return hdebut;
	}
	public void setHdebut(int hdebut) {
		this.hdebut = hdebut;
	}
	public int getMdebut() {
		return mdebut;
	}
	public void setMdebut(int mdebut) {
		this.mdebut = mdebut;
	}
	public int getHfin() {
		return hfin;
	}
	public void setHfin(int hfin) {
		this.hfin = hfin;
	}
	public int getMfin() {
		return mfin;
	}
	public void setMfin(int mfin) {
		this.mfin = mfin;
	}
	public int getId_medecin() {
		return id_medecin;
	}
	public void setId_medecin(int id_medecin) {
		this.id_medecin = id_medecin;
	}
}
