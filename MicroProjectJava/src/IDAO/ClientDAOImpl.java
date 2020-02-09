package IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entities.Client;
import DAO.ClientDAO;
import DbConnection.DbConnection;
public class ClientDAOImpl implements ClientDAO{
	ArrayList<Client> ClientsList = new ArrayList<Client>();
	
	private Connection connection = DbConnection.getDbConnection();;
    private PreparedStatement pst;
    public ClientDAOImpl(){}
    
	@Override
	public ArrayList<Client> getClients() {
		try {
		ResultSet rs = connection.createStatement().executeQuery("select * from client");
			while(rs.next()) {
				ClientsList.add(new Client(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5) ));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ClientsList;
	}

	@Override
	public void ajouterClient(Client client) {
		try {
	        String insert = "Insert into client(version, titre, nom, prenom) values (?,?,?,?)";
	        pst = connection.prepareStatement(insert);
	        pst.setInt(1, client.getVersion());
	        pst.setString(2, client.getTitre());
	        pst.setString(3, client.getNom());
	        pst.setString(4, client.getPrenom());
	        pst.executeUpdate();
	    	JOptionPane.showMessageDialog(null, "Client bien ajouté ! ");
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	@Override
	public void SupprimerClient(Client client) {
		try {
			Statement stat=connection.createStatement();
			String sql="delete from client where version='"+client.getVersion()+"' &&   titre='"+client.getTitre()+"' &&  nom='"+client.getNom()+"' && prenom='"+client.getPrenom()+"'    ";
			stat.executeUpdate(sql);		
			JOptionPane.showMessageDialog(null, "Client bien supprimé :) ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	@Override
	public void ModifierClient(Client client) {
		try {
			Statement stat = connection.createStatement();
			String sql = "update client set titre ='"+client.getTitre()+"', nom='"+client.getNom()+"',prenom='"+client.getPrenom()+"' where version='"+client.getVersion()+"' ";
			int rs=stat.executeUpdate(sql);	
			JOptionPane.showMessageDialog(null, "Client bien Modifié... ");
		}
		catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}
	


	
