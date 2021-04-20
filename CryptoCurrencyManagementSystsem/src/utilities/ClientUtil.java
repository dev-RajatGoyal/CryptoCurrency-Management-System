package utilities;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import daoImp.AdminDaoImp;
import daoImp.ClientDaoImp;
import entities.CryptoCurrency;
import entities.Client;

public class ClientUtil extends ClientDaoImp {
	
	public static void loginUser(int id, String password) {
		try {
			
			ClientDaoImp userDaoImp = new ClientDaoImp();
			AdminDaoImp adminDaoImp = new AdminDaoImp();
			Client user = new Client();
			
			Scanner sc = new Scanner(System.in);
			ResultSet rs = DatabaseConnection.statement
					.executeQuery("select * from User where id = '" + id + "' " + "and password = '" + password + "'");
			if (rs.next() && rs.getString("password").equals(password)) {
				user.setUser_Id(rs.getInt("id"));
				user.setUser_Name(rs.getString("name"));
				user.setUser_Email(rs.getString("email"));
				user.setUser_PhoneNo(rs.getString("phone"));
				user.setUser_Address(rs.getString("address"));
				user.setUser_Password(rs.getString("password"));
				user.setUser_Balance(rs.getDouble("balance"));
				user.setInvestment(rs.getDouble("investment"));
				System.out.println();
				System.out.println("Login Successfull");
				int choice = 0;

				while (choice != 7) {
					
					
					System.out.println("Select option given below");
					System.out.println("Press 1 to check balance");
					System.out.println("Press 2 to show all CryptoCurrency");
					System.out.println("Press 3 to buy CryptoCurrency");
					System.out.println("Press 4 to sell CryptoCurrency");
					System.out.println("Press 5 to update details");
					System.out.println("Press 6 to delete accont");
					System.out.println("Press 7 to exit");
					System.out.println();
					System.out.println("Enter your choice :");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						userDaoImp.checkBalance(id);
						System.out.println();
						System.out.println("Press any key except 7 to continue");
						System.out.println("Press 7 to exit");
						System.out.println();
						break;
					case 2:
						ArrayList<CryptoCurrency> list = adminDaoImp.viewAllCryptoCurrency();
						for (CryptoCurrency cryptocurrency : list) {
							System.out.println("cryptocurrency id : " + cryptocurrency.getCurrency_Id());
							System.out.println("cryptocurrency name : " + cryptocurrency.getCurrency_Name());
							System.out.println("cryptocurrency price : " + cryptocurrency.getCurrency_Price());
							System.out.println();
						}
						System.out.println();
						System.out.println("Press any key except 7 to continue");
						System.out.println("Press 7 to exit");
						System.out.println();
						break;
					case 3:
						System.out.println("***** You can invest in only 1 crytocurrency at a time *****");
						adminDaoImp.buyCryptoCurrency(user);
						System.out.println();
						System.out.println("Press any key except 7 to continue");
						System.out.println("Press 7 to exit");
						System.out.println();
						break;
					case 4:
						System.out.println("***** You can sell only 1 crytocurrency at a time *****");
						adminDaoImp.sellCryptoCurrency(user);
						System.out.println();
						System.out.println("Press any key except 7 to continue");
						System.out.println("Press 7 to exit");
						System.out.println();
						break;
					case 5:
						System.out.println("Enter id");
						int user_id = sc.nextInt();
						System.out.println("Enter name");
						String name = sc.next();
						System.out.println("Enter email");
						String email = sc.next();
						System.out.println("Enter phone no.");
						String phone = sc.next();
						System.out.println("Enter address");
						String address = sc.next();
						System.out.println("Enter password");
						String pwd = sc.next();
						System.out.println("Enter balance");
						double balance = sc.nextDouble();
						double investment = 0;
						userDaoImp.updateUser(new Client(user_id, name, email, phone, address, pwd, balance, investment));
						System.out.println();
						System.out.println("Press any key except 7 to continue");
						System.out.println("Press 7 to exit");
						System.out.println();
						break;
					case 6:
						System.out.println("Enter your id to delete");
						int deleteId = sc.nextInt();
						userDaoImp.deleteUser(deleteId);
						System.out.println();
						break;
					case 7:
						System.out.println("Application Terminated, Thank you !");
						System.exit(0);
						break;
					default:
						continue;
					}

				}
			} else {
				System.out.println("User does not exist");
				System.out.println("Press 1 to create account");
				System.out.println("Press 2 to exit");
				System.out.println();
				System.out.println("Enter your choice :");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter id");
					int user_id = sc.nextInt();
					System.out.println("Enter name");
					String name = sc.next();
					System.out.println("Enter email");
					String email = sc.next();
					System.out.println("Enter phone no.");
					String phone = sc.next();
					System.out.println("Enter address");
					String address = sc.next();
					System.out.println("Enter password");
					String pwd = sc.next();
					System.out.println("Enter balance");
					double balance = sc.nextDouble();
					double investment = 0;
					userDaoImp.addUser(new Client(user_id, name, email, phone, address, pwd, balance, investment));
					System.out.println("Press 1 to login");
					System.out.println("Press 2 to exit");
					System.out.println();
					System.out.println("Enter your choice");
					int choice1 = sc.nextInt();
					
					switch(choice1) {
					case 1:
						System.out.println("Enter user id");
						int userid = sc.nextInt();
						System.out.println("Enter user password");
						String userpassword = sc.next();
						ClientUtil.loginUser(userid, userpassword);
						System.out.println();
						break;
					case 2:
						System.out.println("Application Terminated, Thank you !");
						System.exit(0);
						break;
						default:
							System.out.println("Enter valid option");
					}
					break;
				case 2:
					System.out.println("Application Terminated, Thank you !");
					System.exit(0);
					break;
				default:
					System.out.println("Please select valid option");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
