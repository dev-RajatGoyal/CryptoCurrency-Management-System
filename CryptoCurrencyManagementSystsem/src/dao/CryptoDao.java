package dao;

import java.util.List;

import entities.CryptoCurrency;

public interface CryptoDao {
	
	List<CryptoCurrency> getAllCryptoCurrencies();

}
