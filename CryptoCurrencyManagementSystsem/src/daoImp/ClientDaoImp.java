package daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ClientDao;
import entities.Client;
import utilities.DatabaseConnection;

public class ClientDaoImp implements ClientDao{
	Connection con;
	public void addUser(Client user) {
		try {
			DatabaseConnection.statement.executeUpdate("insert into User (id,name,email,phone,address,password,balance) values"
				+ "('"+user.getUser_Id()+"','"+user.getUser_Name()+"',"
				+ "'"+user.getUser_Email()+"','"+user.getUser_Password()+"',"
				+ "'"+user.getUser_Address()+"','"+user.getUser_Password()+"','"
				+ ""+user.getUser_Balance()+"')");
			System.out.println("User added successfully");
		} catch (Exception e) {
			System.out.println("User already exist");
		}
	}
	
	public void checkBalance(int id) {
		try {
			ResultSet rs = DatabaseConnection.statement.executeQuery("select * from User where id = '"+id+"' ");
			if(rs.next()) {
				double balance = rs.getDouble("balance");
				System.out.println("Your balance is : "+balance);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateUser(Client user) {
		try {
			DatabaseConnection.statement.executeUpdate("update user set "
					+ "id = '"+user.getUser_Id()+"', name = '"+user.getUser_Name()+"', "
					+ "email = '"+user.getUser_Email()+"', phone = '"+user.getUser_PhoneNo()+"', "
					+ "address = '"+user.getUser_Address()+"' ,password = '"+user.getUser_Password()+"', "
					+ "balance = '"+user.getUser_Balance()+"' ");
			System.out.println("User updated successfully");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteUser(int id)
	{
		try {
			DatabaseConnection.statement.executeUpdate("delete from user where id = '"+id+"' ");
			System.out.println("User deleted successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public ArrayList<Client> viewAllUsers(){
		ArrayList<Client> list = new ArrayList<Client>();
		try {
			ResultSet rs = DatabaseConnection.statement.executeQuery("select * from user");
			while(rs.next()) {
				Client user = new Client();
				user.setUser_Id(rs.getInt("id"));
				user.setUser_Name(rs.getString("name"));
				user.setUser_Email(rs.getString("email"));
				user.setUser_PhoneNo(rs.getString("phone"));
				user.setUser_Address(rs.getString("address"));
				user.setUser_Password(rs.getString("password"));
				user.setUser_Balance(rs.getDouble("balance"));
				list.add(user);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	@Override
	public Client getUser(int userId) {
		
		Client user = null;
		String sql = "select * from user where id = ?";
		
		return null;
	}
	
}
