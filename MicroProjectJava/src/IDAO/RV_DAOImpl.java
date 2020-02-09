package IDAO;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DAO.RvDAO;
import DbConnection.DbConnection;
import Entities.Creneau;
import Entities.RV;

public class RV_DAOImpl implements RvDAO{

	private Connection connection = DbConnection.getDbConnection();;
    private PreparedStatement pst;
    public RV_DAOImpl(){}
    
	@Override
	public void AjouterRV(Date date, int id_client, Creneau creneau) {
		try {
			
			if(creneau.getHdebut()<8 || (creneau.getHdebut()>12 && creneau.getHdebut()<14) || creneau.getHdebut()>18 ||
			   creneau.getHfin()<8 || (creneau.getHfin()>12 && creneau.getHfin()<14) || creneau.getHfin()>18 ||
			   creneau.getMdebut()<0 || creneau.getMdebut()>60 || creneau.getMfin()<0 || creneau.getMfin()>60) {
				JOptionPane.showMessageDialog(null, "l'horaire du travail est du 8h à 12h er du 14h à 18 :) ");
			}
			else {
	        String insert = "Insert into creneaux(version, hdebut, mdebut, hfin, mfin, id_medecin) values (?,?,?,?,?,?)";
	        pst = connection.prepareStatement(insert);
	        pst.setInt(1, creneau.getVersion());
	        pst.setInt(2, creneau.getHdebut());
	        pst.setInt(3, creneau.getMdebut());
	        pst.setInt(4, creneau.getHfin());
	        pst.setInt(5, creneau.getMfin());
	        pst.setInt(6, creneau.getId_medecin());
	        pst.executeUpdate();
	        
	        String sql="select max(id) from creneaux";
	        pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			int id_creneau = -1;
			if(rs.next()) {
				id_creneau = rs.getInt(1);
				String insertRv = "Insert into rv( jour, id_client, id_creneau) values (?,?,?)";
		        pst = connection.prepareStatement(insertRv);
		        pst.setDate(1, date);
		        pst.setInt(2, id_client);
		        pst.setInt(3, id_creneau);
		        pst.executeUpdate();
			}
			//System.out.println(id_creneau);
		
			
	    	JOptionPane.showMessageDialog(null, "rendez-vous bien ajouté ! ");
	    	
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public void SupprimerRV(RV rv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModifierRV(RV rv) {
		// TODO Auto-generated method stub
		
	}


}
