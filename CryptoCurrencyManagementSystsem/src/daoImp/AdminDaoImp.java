package daoImp;

import java.sql.ResultSet;  
import java.util.ArrayList;
import java.util.Scanner;

import dao.AdminDao;
import entities.CryptoCurrency;
import entities.User;
import exception.CryptoCurrecnyAlreadyAddedException;
import entities.Admin;
import entities.Client;
import utilities.DatabaseConnection;

public class AdminDaoImp implements AdminDao {

	User admin = new Admin();
	
	public void addCryptoCurrency(CryptoCurrency cryptocurrency) throws CryptoCurrecnyAlreadyAddedException {
		
		if(admin.isCurrencyExists(cryptocurrency))
		{
			throw new CryptoCurrecnyAlreadyAddedException();
		}
		
		try {
			DatabaseConnection.statement.executeUpdate("insert into cryptocurrency(id,name,price) values "
					+ "('"+cryptocurrency.getCurrency_Id()+"','"+cryptocurrency.getCurrency_Name()+"',"
					+ "'"+cryptocurrency.getCurrency_Price()+"')");
			System.out.println("CryptoCurrency added successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void updateCryptoCurrency(CryptoCurrency cryptocurrency) {
		try {
			DatabaseConnection.statement.executeUpdate("update cryptocurrency set "
					+ "id='"+cryptocurrency.getCurrency_Id()+"', "
					+ "name = '"+cryptocurrency.getCurrency_Name()+"', "
					+ "price = '"+cryptocurrency.getCurrency_Price()+"' ");
			System.out.println("CryptoCurrency updated successfully");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void deleteCryptoCurrency(int id)
	{
		try {
			DatabaseConnection.statement.executeUpdate("delete from cryptocurrency where id = '"+id+"'");
			System.out.println("CryptoCurrency deleted successfully");
		}catch(Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<CryptoCurrency> viewAllCryptoCurrency()
	{
		ArrayList<CryptoCurrency> list = new ArrayList<CryptoCurrency>();
		try {
			ResultSet rs = DatabaseConnection.statement.executeQuery("select * from cryptocurrency");
			while(rs.next()) {
				CryptoCurrency cryptocurrency = new CryptoCurrency();
				cryptocurrency.setCurrency_Id(rs.getInt("id"));
				cryptocurrency.setCurrency_Name(rs.getString("name"));
				cryptocurrency.setCurrency_Price(rs.getDouble("price"));
				list.add(cryptocurrency);
			}

		}catch(Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public void buyCryptoCurrency(Client user) {
		Scanner sc = new Scanner(System.in);
		ArrayList<CryptoCurrency> list = viewAllCryptoCurrency();
		int count = 1;
		for(CryptoCurrency cryptoCurrency : list) {
			System.out.println("Press "+count+" to Buy "+cryptoCurrency.getCurrency_Name());
			count++;
		}
		System.out.println("Press 6 to exit");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();

		switch(choice) {

		case 1:
			CryptoCurrency cryptocurrency1 = list.get(0);
			if(user.getUser_Balance() >= cryptocurrency1.getCurrency_Price()) {
				int coins = (int)(user.getUser_Balance()/cryptocurrency1.getCurrency_Price());
				System.out.println("You can buy "+coins+" BitCoins");
				System.out.println("Please enter how many bitcoins do you want : ");
				int totalcoins = sc.nextInt();
				if(totalcoins <= coins)
				{
					user.setInvestment( cryptocurrency1.getCurrency_Price() * totalcoins ); 
					user.setUser_Balance(user.getUser_Balance() - user.getInvestment());
					try {
						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");

						System.out.println("You have successfully invested "+user.getInvestment()+" in BitCoin");
						System.out.println("Balance left : "+user.getUser_Balance());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("You can buy upto "+coins+" BitCoins");
				}

			}else {
				System.out.println("You don't have sufficient balance to buy BitCoin");
			}
			break;
		case 2:
			CryptoCurrency cryptocurrency2 = list.get(1);
			if(user.getUser_Balance() >= cryptocurrency2.getCurrency_Price()) {
				int coins = (int)(user.getUser_Balance()/cryptocurrency2.getCurrency_Price());
				System.out.println("You can buy "+coins+" Ethereum");
				System.out.println("Please enter how many ethereum do you want : ");
				int totalcoins = sc.nextInt();
				if(totalcoins <= coins)
				{
					user.setInvestment(cryptocurrency2.getCurrency_Price() * totalcoins ); 
					user.setUser_Balance(user.getUser_Balance() - user.getInvestment());
					try {

						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully invested "+user.getInvestment()+" in Ethereum");
						System.out.println("Balance left : "+user.getUser_Balance());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("You can buy upto "+coins+" Ethereum");
				}

			}else {
				System.out.println("You don't have sufficient balance to buy Ethereum");
			}
			break;
		case 3:
			CryptoCurrency cryptocurrency3 = list.get(2);
			if(user.getUser_Balance() >= cryptocurrency3.getCurrency_Price()) {
				int coins = (int)(user.getUser_Balance()/cryptocurrency3.getCurrency_Price());
				System.out.println("You can buy "+coins+" BinanceCoin");
				System.out.println("Please enter how many BinanceCoin do you want : ");
				int totalcoins = sc.nextInt();
				if(totalcoins <= coins)
				{
					user.setInvestment(cryptocurrency3.getCurrency_Price() * totalcoins ); 
					user.setUser_Balance(user.getUser_Balance() - user.getInvestment());
					try {
						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully invested "+user.getInvestment()+" in BinanceCoin");
						System.out.println("Balance left : "+user.getUser_Balance());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("You can buy upto "+coins+" BinanceCoin");
				}

			}else {
				System.out.println("You don't have sufficient balance to buy BinanceCoin");
			}
			break;
		case 4:
			CryptoCurrency cryptocurrency4 = list.get(3);
			if(user.getUser_Balance() >= cryptocurrency4.getCurrency_Price()) {
				int coins = (int)(user.getUser_Balance()/cryptocurrency4.getCurrency_Price());
				System.out.println("You can buy "+coins+" Tether");
				System.out.println("Please enter how many Tether do you want : ");
				int totalcoins = sc.nextInt();
				if(totalcoins <= coins)
				{
					user.setInvestment(cryptocurrency4.getCurrency_Price() * totalcoins ); 
					user.setUser_Balance(user.getUser_Balance() - user.getInvestment());
					try {
						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully invested "+user.getInvestment()+" in Tether");
						System.out.println("Balance left : "+user.getUser_Balance());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("You can buy upto "+coins+" Tether");
				}

			}else {
				System.out.println("You don't have sufficient balance to buy Tether");
			}
			break;
		case 5:
			CryptoCurrency cryptocurrency5 = list.get(4);
			if(user.getUser_Balance() >= cryptocurrency5.getCurrency_Price()) {
				int coins = (int)(user.getUser_Balance()/cryptocurrency5.getCurrency_Price());
				System.out.println("You can buy "+coins+" XPR");
				System.out.println("Please enter how many XPR do you want : ");
				int totalcoins = sc.nextInt();
				if(totalcoins <= coins)
				{
					user.setInvestment(cryptocurrency5.getCurrency_Price() * totalcoins ); 
					user.setUser_Balance(user.getUser_Balance() - user.getInvestment());
					try {
						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully invested "+user.getInvestment()+" in XPR");
						System.out.println("Balance left : "+user.getUser_Balance());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("You can buy upto "+coins+" XPR");
				}

			}else {
				System.out.println("You don't have sufficient balance to buy XPR");
			}
			break;
		case 6:
			System.out.println("Application Terminated, Thank you !");
			System.exit(0);
		default :
			System.out.println("Please select valid option");
		}
	}

	public void sellCryptoCurrency(Client user)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<CryptoCurrency> list = viewAllCryptoCurrency();
		int count = 1;
		for(CryptoCurrency cryptoCurrency : list) {
			System.out.println("Press "+count+" to sell "+cryptoCurrency.getCurrency_Name());
			count++;
		}
		System.out.println("Press 6 to exit");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();

		switch(choice){

		case 1:

			CryptoCurrency cryptocurrency1 = list.get(0);
			System.out.println("Minimum sell criteria is 5 BitCoin");
			System.out.println();
			int bitcoin = (int)(user.getInvestment()/cryptocurrency1.getCurrency_Price());
			System.out.println("You have total "+bitcoin+" BitCoins");
			System.out.println();
			System.out.println("Please enter how many bitcoins do you want to sell : ");
			int sellcoins = sc.nextInt();
			
			double totalCost = sellcoins * cryptocurrency1.getCurrency_Price();
			
			System.out.println("");
			if(sellcoins >= 5 ) {
				
				if(user.getInvestment() >= totalCost) 
				{
					double sellAmount = cryptocurrency1.getCurrency_Price() * sellcoins;
					user.setUser_Balance(user.getUser_Balance() + sellAmount);
					user.setInvestment( user.getInvestment() - sellAmount ); 

					try 
					{

						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully sell "+sellcoins+" BitCoin of worth : "+sellAmount);
						System.out.println("Total Balance : "+user.getUser_Balance());
						System.out.println("Total Investment : "+user.getInvestment());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("Insufficient BitCoin to sell");
				}
				

			}else {
				System.out.println("Please sell atleast 5 BitCoin");
			}
			
			break;
		case 2:
			CryptoCurrency cryptocurrency2 = list.get(1);
			System.out.println("Minimum sell criteria is 10 Ethereum");
			System.out.println();
			int ethereum = (int)(user.getInvestment()/cryptocurrency2.getCurrency_Price());
			System.out.println("You have total "+ethereum+" Ethereum");
			System.out.println();
			System.out.println("Please enter how many ethereum do you want to sell : ");
			int sellethereum = sc.nextInt();
			
			double totalCostofethereum = sellethereum * cryptocurrency2.getCurrency_Price();
			
			System.out.println("");
			if(sellethereum >= 10 ) {
				
				if(user.getInvestment() >= totalCostofethereum) 
				{
					double sellAmount = cryptocurrency2.getCurrency_Price() * sellethereum;
					user.setUser_Balance(user.getUser_Balance() + sellAmount);
					user.setInvestment( user.getInvestment() - sellAmount ); 

					try 
					{

						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully sell "+sellethereum+" Ethereum of worth : "+sellAmount);
						System.out.println("Total Balance : "+user.getUser_Balance());
						System.out.println("Total Investment : "+user.getInvestment());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("Insufficient Ethereum to sell");
				}
				

			}else {
				System.out.println("Please sell atleast 10 Ethereum");
			}

			break;
		case 3:
			CryptoCurrency cryptocurrency3 = list.get(2);
			System.out.println("Minimum sell criteria is 10 BinanceCoin");
			System.out.println();
			int BinanceCoin = (int)(user.getInvestment()/cryptocurrency3.getCurrency_Price());
			System.out.println("You have total "+BinanceCoin+" BinanceCoin");
			System.out.println();
			System.out.println("Please enter how many BinanceCoin do you want to sell : ");
			int sellBinanceCoin = sc.nextInt();
			
			double totalCostofsellBinanceCoin = sellBinanceCoin * cryptocurrency3.getCurrency_Price();
			
			System.out.println("");
			if(sellBinanceCoin >= 10 ) {
				
				if(user.getInvestment() >= totalCostofsellBinanceCoin) 
				{
					double sellAmount = cryptocurrency3.getCurrency_Price() * sellBinanceCoin;
					user.setUser_Balance(user.getUser_Balance() + sellAmount);
					user.setInvestment( user.getInvestment() - sellAmount ); 

					try 
					{

						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully sell "+sellBinanceCoin+" BinanceCoin of worth : "+sellAmount);
						System.out.println("Total Balance : "+user.getUser_Balance());
						System.out.println("Total Investment : "+user.getInvestment());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("Insufficient BinanceCoin to sell");
				}
				

			}else {
				System.out.println("Please sell atleast 10 BinanceCoin");
			}
			
			break;
		case 4:
			CryptoCurrency cryptocurrency4 = list.get(3);
			System.out.println("Minimum sell criteria is 15 Tether");
			System.out.println();
			int Tether = (int)(user.getInvestment()/cryptocurrency4.getCurrency_Price());
			System.out.println("You have total "+Tether+" Ethereum");
			System.out.println();
			System.out.println("Please enter how many Tether do you want to sell : ");
			int sellTether = sc.nextInt();
			
			double totalCostofsellTether = sellTether * cryptocurrency4.getCurrency_Price();
			
			System.out.println("");
			if(sellTether >= 15 ) {
				
				if(user.getInvestment() >= totalCostofsellTether) 
				{
					double sellAmount = cryptocurrency4.getCurrency_Price() * sellTether;
					user.setUser_Balance(user.getUser_Balance() + sellAmount);
					user.setInvestment( user.getInvestment() - sellAmount ); 

					try 
					{

						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully sell "+sellTether+" Tether of worth : "+sellAmount);
						System.out.println("Total Balance : "+user.getUser_Balance());
						System.out.println("Total Investment : "+user.getInvestment());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("Insufficient Tether to sell");
				}
				

			}else {
				System.out.println("Please sell atleast 15 Tether");
			}
			
			break;
			
		case 5:
			
			CryptoCurrency cryptocurrency5 = list.get(4);
			System.out.println("Minimum sell criteria is 15 XRP");
			System.out.println();
			int XRP = (int)(user.getInvestment()/cryptocurrency5.getCurrency_Price());
			System.out.println("You have total "+XRP+" Ethereum");
			System.out.println();
			System.out.println("Please enter how many XRP do you want to sell : ");
			int sellXRP = sc.nextInt();
			
			double totalCostofsellXRP = sellXRP * cryptocurrency5.getCurrency_Price();
			
			System.out.println("");
			if(sellXRP >= 15 ) {
				
				if(user.getInvestment() >= totalCostofsellXRP) 
				{
					double sellAmount = cryptocurrency5.getCurrency_Price() * sellXRP;
					user.setUser_Balance(user.getUser_Balance() + sellAmount);
					user.setInvestment( user.getInvestment() - sellAmount ); 

					try 
					{

						DatabaseConnection.statement.executeUpdate(""
								+ "update user set balance = '"+user.getUser_Balance()+"', "
								+ "investment = '"+user.getInvestment()+"' where id = '"+user.getUser_Id()+"' ");
						System.out.println("You have successfully sell "+sellXRP+" XRP of worth : "+sellAmount);
						System.out.println("Total Balance : "+user.getUser_Balance());
						System.out.println("Total Investment : "+user.getInvestment());
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("Insufficient XRP to sell");
				}
				

			}else {
				System.out.println("Please sell atleast 15 XRP");
			}
			
			break;
			
		case 6:
			System.out.println("Application Terminate, Thank you !");
			default:
				System.out.println("Please enter valid option");
		}
	}
}
