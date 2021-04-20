package daoImp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.CryptoDao;
import entities.CryptoCurrency;
import utilities.DatabaseConnection;

public class CryptoDaoImpl implements CryptoDao {

	
	@Override
	public List<CryptoCurrency> getAllCryptoCurrencies() {
		List<CryptoCurrency> cryptos = new ArrayList<>();
		try {
			ResultSet rs = DatabaseConnection.statement.executeQuery("select * from cryptocurrency");
			while(rs.next()) {
				CryptoCurrency cryptocurrency = new CryptoCurrency();
				cryptocurrency.setCurrency_Id(rs.getInt("id"));
				cryptocurrency.setCurrency_Name(rs.getString("name"));
				cryptocurrency.setCurrency_Price(rs.getDouble("price"));
				cryptos.add(cryptocurrency);
			}

		}catch(Exception e) {
			System.out.println(e);
		}

		
		return cryptos;
	}

}
