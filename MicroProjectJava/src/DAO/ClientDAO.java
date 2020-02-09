package DAO;

import java.util.ArrayList;
import java.util.List;

import Entities.Client;

public interface ClientDAO {
	public ArrayList<Client> getClients();
	public void ajouterClient(Client client);
	public void ModifierClient(Client client);
	public void SupprimerClient(Client client);
	
}
