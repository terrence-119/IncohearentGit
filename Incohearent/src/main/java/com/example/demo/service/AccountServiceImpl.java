package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountCrudRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService 
{
	@Autowired
	AccountCrudRepository repository;

	@Override
	public Iterable<Account> selectAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		repository.save(account);
	}

	@Override
	public Optional<Account> selectOneById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		repository.save(account);
	}

	@Override
	public void deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
