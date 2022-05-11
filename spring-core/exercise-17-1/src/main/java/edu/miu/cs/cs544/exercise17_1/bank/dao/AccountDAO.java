package edu.miu.cs.cs544.exercise17_1.bank.dao;

import java.util.Collection;

import edu.miu.cs.cs544.exercise17_1.bank.domain.Account;


public interface AccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
