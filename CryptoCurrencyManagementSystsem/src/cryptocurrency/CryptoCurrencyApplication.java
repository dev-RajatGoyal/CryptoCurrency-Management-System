package cryptocurrency;

import java.util.Scanner;

import entities.Admin;
import entities.User;
import utilities.AdminUtil;
import utilities.ClientUtil;

public class CryptoCurrencyApplication {
	
	static User admin = new Admin();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to login as User");
		System.out.println("Press 2 to login as Admin");
		System.out.println("Press 3 to show all CryptoCurrency");
		System.out.println("Press 4 exit");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter user id");
			int id = sc.nextInt();
			System.out.println("Enter user password");
			String password = sc.next();
			ClientUtil.loginUser(id, password);
			break;
		case 2:
			System.out.println("Enter admin id");
			int adminID = sc.nextInt();
			System.out.println("Enter admin password");
			String adminPass = sc.next();
			AdminUtil.loginAdmin(adminID, adminPass);
			break;
		case 3:
			System.out.println("You need to login first to proceed further");
			System.out.println("Press 1 to login as User");
			System.out.println("Press 2 to login as Admin");
			System.out.println("Press 3 to exit");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter user id");
				int userid = sc.nextInt();
				System.out.println("Enter user password");
				String userpass = sc.next();
				ClientUtil.loginUser(userid, userpass);
				break;
			case 2:
				System.out.println("Enter admin id");
				int adID = sc.nextInt();
				System.out.println("Enter admin password");
				String adPass = sc.next();
				AdminUtil.loginAdmin(adID, adPass);
				break;
			case 3:
				System.exit(0);
				break;
				default :
					System.out.println("Please enter valid option");
			}
		case 4:
			System.exit(0);
			break;
			default :
				System.out.println("Please select valid option");
		}
	}
}
