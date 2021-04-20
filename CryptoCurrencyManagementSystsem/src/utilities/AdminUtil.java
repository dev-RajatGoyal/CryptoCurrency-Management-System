package utilities;

import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.Scanner;
import daoImp.AdminDaoImp;
import daoImp.ClientDaoImp;
import entities.CryptoCurrency;
import entities.Client;

public class AdminUtil extends AdminDaoImp{
	
	public static void loginAdmin(int id, String password)
	{
		try 
		{	
			ClientDaoImp userDaoImp = new ClientDaoImp();
			AdminDaoImp adminDaoImp = new AdminDaoImp();
			Scanner sc = new Scanner(System.in);
			ResultSet rs = DatabaseConnection.statement.executeQuery("select * from admin where id ='"+id+"' "
					+ "and password ='"+password+"'");	
			if(rs.next() && rs.getString("password").equals(password)) {
				
				System.out.println("Admin login successfully");
				
				int choice = 0;
				
				while(choice!=8)
				{
					System.out.println("Press 1 to Add Cryptocurrency");
					System.out.println("Press 2 to Update Cryptocurrency");
					System.out.println("Press 3 to Delete Cryptocurrency");
					System.out.println("Press 4 View all Cryptocurrency");
					System.out.println("Press 5 to Add user");
					System.out.println("Press 6 to Delete user");
					System.out.println("Press 7 to View all users");
					System.out.println("Press 8 Exit");
					System.out.println("Enter your choice : ");
					choice = sc.nextInt();
					System.out.println();
					
					switch(choice) {
					case 1:
						System.out.println("Enter id");
						int cid = sc.nextInt();
						System.out.println("Enter name");
						String cname = sc.next();
						System.out.println("Enter price");
						double cprice = sc.nextDouble();
						adminDaoImp.addCryptoCurrency(new CryptoCurrency(cid, cname, cprice));
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 2:
						System.out.println("Enter id");
						int idNew = sc.nextInt();
						System.out.println("Enter name");
						String nameNew = sc.next();
						System.out.println("Enter price");
						double priceNew = sc.nextDouble();
						adminDaoImp.updateCryptoCurrency(new CryptoCurrency(idNew, nameNew, priceNew));
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 3:
						System.out.println("Enter id to delete");
						int deleteId = sc.nextInt();
						adminDaoImp.deleteCryptoCurrency(deleteId);
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 4:
						ArrayList<CryptoCurrency> list = adminDaoImp.viewAllCryptoCurrency();
						for(CryptoCurrency cryptocurrency : list) {
							System.out.println("cryptocurrency id : "+cryptocurrency.getCurrency_Id());
							System.out.println("cryptocurrency name : "+cryptocurrency.getCurrency_Name());
							System.out.println("cryptocurrency price : "+cryptocurrency.getCurrency_Price());
							System.out.println();
						}
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 5:
						System.out.println("Enter id");
						int u_id = sc.nextInt();
						System.out.println("Enter name");
						String uname = sc.next();
						System.out.println("Enter email");
						String uemail = sc.next();
						System.out.println("Enter phone no.");
						String uphone = sc.next();
						System.out.println("Enter address");
						String uaddress = sc.next();
						System.out.println("Enter password");
						String upwd = sc.next();
						System.out.println("Enter balance");
						double ubalance = sc.nextDouble();
						double investment = 0;
						userDaoImp.addUser(new Client(u_id, uname, uemail, uphone, uaddress, upwd, ubalance, investment));
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 6:
						System.out.println("Enter your id to delete");
						int delUser = sc.nextInt();
						userDaoImp.deleteUser(delUser);
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 7:
						ArrayList<Client> users = userDaoImp.viewAllUsers();
						for(Client user : users) {
							System.out.println("id : "+user.getUser_Id());
							System.out.println("name : "+user.getUser_Name());
							System.out.println("email : "+user.getUser_Email());
							System.out.println("phone : "+user.getUser_PhoneNo());
							System.out.println("address :"+user.getUser_Address());
							System.out.println("balance : "+user.getUser_Balance());
							System.out.println();
						}
						System.out.println();
						System.out.println("Press any key except 8 to continue");
						System.out.println("Press 8 to exit");
						System.out.println();
						break;
					case 8:
						System.out.println("Application Terminated, Thank you !");
						System.exit(0);
						break;
						 default :
							continue;
					}
				}
				
			}
			else {
				System.out.println("Invalid credentials");
				System.out.println("Press 1 to login again");
				System.out.println("Press 2 to exit");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				
				switch(choice)
				{
				case 1:
					System.out.println();
					System.out.println("Enter admin id");
					int adminID = sc.nextInt();
					System.out.println("Enter admin password");
					String adminPass = sc.next();
					AdminUtil.loginAdmin(adminID, adminPass);
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.println("Application Terminated, Thank you !");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter valid option");
				}
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
