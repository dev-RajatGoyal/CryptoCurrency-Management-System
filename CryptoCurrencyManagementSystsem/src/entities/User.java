package entities;

import java.util.List;

import dao.CryptoDao;
import daoImp.CryptoDaoImpl;

abstract public class User {

	static CryptoDao cryptoDao = new CryptoDaoImpl();
	private static CurrencyContainer currencyContainer = new CurrencyContainer();
	static {

		if (currencyContainer.getCryptoCurrency().size() == 0) {
			List<CryptoCurrency> currencies = cryptoDao.getAllCryptoCurrencies();

			currencyContainer.getCryptoCurrency().addAll(currencies);
		}

	}

	public CurrencyContainer getCurrencyContainer() {
		return currencyContainer;
	}

	public boolean isCurrencyExists(CryptoCurrency newCurrency) {
		boolean exists = false;

		if (currencyContainer.getCryptoCurrency().size() == 0)
			return exists;

		for (CryptoCurrency currency : currencyContainer.getCryptoCurrency()) {
			if (newCurrency.getCurrency_Id() == currency.getCurrency_Id()
					|| newCurrency.getCurrency_Name().equals(currency.getCurrency_Name())) {

				exists = true;
			}
		}

		return exists;
	}
}
