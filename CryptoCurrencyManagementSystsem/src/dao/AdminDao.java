package dao;

import java.util.ArrayList;

import entities.CryptoCurrency;
import exception.CryptoCurrecnyAlreadyAddedException;
import entities.Client;

public interface AdminDao {
	
	void addCryptoCurrency(CryptoCurrency cryptocurrency) throws CryptoCurrecnyAlreadyAddedException;
	
	void updateCryptoCurrency(CryptoCurrency cryptocurrency);
	
	void deleteCryptoCurrency(int id);
	
	ArrayList<CryptoCurrency> viewAllCryptoCurrency();
	
	void buyCryptoCurrency(Client user);
	
	void sellCryptoCurrency(Client user);
}
