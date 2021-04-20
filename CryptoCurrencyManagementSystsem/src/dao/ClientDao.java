package dao;

import java.util.ArrayList;

import entities.Client;

public interface ClientDao {
	public Client getUser(int userId);
	void addUser(Client user);
	
	void checkBalance(int id);
	
	void updateUser(Client user);
	
	void deleteUser(int id);
	
	ArrayList<Client> viewAllUsers();
	
}
