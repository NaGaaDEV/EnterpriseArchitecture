package edu.miu.cs.cs544.exercise17_1.bank.dao;

import java.util.ArrayList;
import java.util.Collection;

import edu.miu.cs.cs544.exercise17_1.bank.domain.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveAccount(Account account) {
		sessionFactory.getCurrentSession().persist(account.getCustomer());
		sessionFactory.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			sessionFactory.getCurrentSession().update(account);
		}
	}

	public Account loadAccount(long accountnumber) {
		return sessionFactory.getCurrentSession()
				.createQuery(
						"from Account a left join fetch a.entryList where a.id = :id",
						Account.class
				).setParameter(
						"id",
						accountnumber
				).uniqueResult();
	}

	public Collection<Account> getAccounts() {
		return sessionFactory.getCurrentSession()
				.createQuery(
						"from Account a left join fetch a.entryList",
						Account.class
				).list();
	}
}
