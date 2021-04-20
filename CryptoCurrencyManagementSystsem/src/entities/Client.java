package entities;

public class Client extends User {
	
	private int user_Id;
	private String user_Name;
	private String user_Email;
	private String user_PhoneNo;
	private String user_Address;
	private String user_Password;
	private double user_Balance;
	private double investment;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(int user_Id, String user_Name, String user_Email, String user_PhoneNo, String user_Address,
			String user_Password, double user_Balance, double investment) {
		super();
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.user_Email = user_Email;
		this.user_PhoneNo = user_PhoneNo;
		this.user_Address = user_Address;
		this.user_Password = user_Password;
		this.user_Balance = user_Balance;
		this.investment = investment;
	}
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	public String getUser_PhoneNo() {
		return user_PhoneNo;
	}
	public void setUser_PhoneNo(String user_PhoneNo) {
		this.user_PhoneNo = user_PhoneNo;
	}
	public String getUser_Address() {
		return user_Address;
	}
	public void setUser_Address(String user_Address) {
		this.user_Address = user_Address;
	}
	public String getUser_Password() {
		return user_Password;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	public double getUser_Balance() {
		return user_Balance;
	}
	public void setUser_Balance(double user_Balance) {
		this.user_Balance = user_Balance;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}
	
}
