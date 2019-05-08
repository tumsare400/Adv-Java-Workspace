package com.capgemini.bankapp.dao;

import java.util.List;

import com.capgemini.bankapp.client.BankAccount;
import com.capgemini.bankapp.exception.AccountNotFoundException;

public interface BankAccountDao {

	public double getBalance(long accountId) throws AccountNotFoundException;

	public void updateBalance(long accountId, double newBalance) throws AccountNotFoundException;

	public boolean deleteBankAccount(long accountId) throws AccountNotFoundException;

	public boolean addNewBankAccount(BankAccount account);

	public List<BankAccount> findAllBankAccountsDetails();

	public BankAccount searchAccountDetails(long accountId) throws AccountNotFoundException;

	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) throws AccountNotFoundException;

}