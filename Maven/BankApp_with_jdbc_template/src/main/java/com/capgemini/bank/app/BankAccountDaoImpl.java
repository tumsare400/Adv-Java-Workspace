package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;  
import com.capgemini.bankapp.client.BankAccount;
import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.util.DbUtil;
import javax.sql.DataSource;
import org.springframework.transaction.annotation.*;

@Transactional
public class BankAccountDaoImpl implements BankAccountDao {

	private JdbcTemplate jdbcTemplate;  
	

	public void setDataSource(JdbcTemplate jdbcTemplate) {
 		this.jdbcTemplate = jdbcTemplate;
 		
 	}

	@Override
	public double getBalance(long accountId) throws AccountNotFoundException{

		
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id="+accountId;
		Double balance = -1.0;
               try{
		 balance = jdbcTemplate.queryForObject(query, Double.class);
		
		} catch (Exception e) {
			throw new AccountNotFoundException("Account not exist");
		}
		

		return balance;
	}

	@Override
	public void updateBalance(long accountId, double newBalance) throws AccountNotFoundException{
		String query = "UPDATE bankaccounts SET account_balance= '"+newBalance+"' WHERE account_id= '"+accountId+"'";
 		try{
                int result = jdbcTemplate.update(query);
		System.out.println(result);
		} catch (Exception e) {
			throw new AccountNotFoundException("Account not exist");
		}
            
	}

	@Override
	public boolean deleteBankAccount(long accountId) throws AccountNotFoundException{
		String query = "DELETE FROM bankaccounts WHERE account_id=?";
                Object params[] = {accountId};
		try{
		int result = jdbcTemplate.update(query, params);
                 
                  if(result==1)
                       return true;

		} catch (Exception e) {
			throw new AccountNotFoundException("Account not exist");
		}
		return false;
	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {

		String query = "INSERT INTO bankaccounts (customer_name,account_type,account_balance) VALUES (?,?,?)";
		Object params[] = {account.getAccountHolderName(),account.getAccountType(),account.getAccountBalance()};
		int result = jdbcTemplate.update(query, params);

		if(result==1)
			return true;

		return false;
	}

	@Override
	public List<BankAccount> findAllBankAccountsDetails() {
		String query = "SELECT * FROM bankaccounts";
		List<BankAccount> accounts = jdbcTemplate.query(query,(resultSet, rowNum)->{
                                              BankAccount account = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
                                              return account;
                   });

		return accounts;
	}

	@Override
	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException {
		String query = "SELECT * FROM bankaccounts WHERE account_id=" + accountId;
		BankAccount account=null;
		try{
		 account = jdbcTemplate.queryForObject(query,(resultSet, rowNum)->{
                                      BankAccount accounts = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
                                       return accounts;
                			});

		
		
		} catch (Exception e) {
			throw new AccountNotFoundException("Account not exist");
		}
		return account;
	}

	@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType)throws AccountNotFoundException {

		String query = "UPDATE bankaccounts SET customer_name=?,account_type=? WHERE account_id=?";
                Object params[] = {accountHolderName, accountType,accountId};
                try{
		int result = jdbcTemplate.update(query, params);
                
                 if(result==1)
                      return  true;


		} catch (Exception e) {
			throw new AccountNotFoundException("Account not exist");
		}
		return false;
	}
	
 	

}