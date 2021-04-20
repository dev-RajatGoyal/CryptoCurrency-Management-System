package entities;

public class CryptoCurrency {
	
	private int currency_Id;
	private String currency_Name;
	private double currency_Price;
	
	public CryptoCurrency() {
		// TODO Auto-generated constructor stub
	}
	public CryptoCurrency(int currency_Id, String currency_Name, double currency_Price) {
		super();
		this.currency_Id = currency_Id;
		this.currency_Name = currency_Name;
		this.currency_Price = currency_Price;
	}

	public int getCurrency_Id() {
		return currency_Id;
	}

	public void setCurrency_Id(int currency_Id) {
		this.currency_Id = currency_Id;
	}

	public String getCurrency_Name() {
		return currency_Name;
	}

	public void setCurrency_Name(String currency_Name) {
		this.currency_Name = currency_Name;
	}

	public double getCurrency_Price() {
		return currency_Price;
	}

	public void setCurrency_Price(double currency_Price) {
		this.currency_Price = currency_Price;
	}
	
}
