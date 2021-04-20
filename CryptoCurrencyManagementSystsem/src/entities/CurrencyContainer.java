package entities;

import java.util.ArrayList;
import java.util.List;

public class CurrencyContainer {
	
	List<CryptoCurrency> cryptos = new ArrayList<>();
	
	public void addCryptos(CryptoCurrency cryptoCurrency)
	{
		cryptos.add(cryptoCurrency);
	}
	
	public List<CryptoCurrency> getCryptoCurrency()
	{
		return cryptos;
	}

}
