package IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.MedecinDAO;
import DbConnection.DbConnection;
import Entities.Medecin;

public class MedecinDAOImpl implements MedecinDAO{
	
	List<Medecin> MedecinsList = new ArrayList<Medecin>();
	private Connection connection = DbConnection.getDbConnection();;
    private PreparedStatement pst;
    
	@Override
	public List<Medecin> getMedecins() {
		try {
			ResultSet rs = connection.createStatement().executeQuery("select * from medecin");
				while(rs.next()) {
					MedecinsList.add(new Medecin(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5) ));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return MedecinsList;
	}

	@Override
	public void ajouterMedecin(Medecin medecin) {
		try {
	        String insert = "Insert into medecin(version, titre, nom, prenom) values (?,?,?,?)";
	        pst = connection.prepareStatement(insert);
	        pst.setInt(1, medecin.getVersion());
	        pst.setString(2, medecin.getTitre());
	        pst.setString(3, medecin.getNom());
	        pst.setString(4, medecin.getPrenom());
	        pst.executeUpdate();
	    	JOptionPane.showMessageDialog(null, "Medecin bien ajouté ! ");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public void ModifierMedecin(Medecin medecin) {
		try {
			Statement stat = connection.createStatement();
			String sql = "update medecin set titre ='"+medecin.getTitre()+"', nom='"+medecin.getNom()+"',prenom='"+medecin.getPrenom()+"' where version='"+medecin.getVersion()+"' ";
			int rs=stat.executeUpdate(sql);	
			JOptionPane.showMessageDialog(null, "medecin bien Modifié... ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public void SupprimerMedecin(Medecin medecin) {
		try {
			Statement stat=connection.createStatement();
			String sql="delete from medecin where version='"+medecin.getVersion()+"' &&   titre='"+medecin.getTitre()+"' &&  nom='"+medecin.getNom()+"' && prenom='"+medecin.getPrenom()+"'";
			stat.executeUpdate(sql);		
			JOptionPane.showMessageDialog(null, "medecin bien supprimé :) ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}

}
