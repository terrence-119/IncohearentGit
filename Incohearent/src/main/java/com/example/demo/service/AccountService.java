package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Account;

/** Account Service Interface */
public interface AccountService 
{
	/**　アカウント情報を全件取得する */
	Iterable<Account> selectAll();
	/** Accountを登録します */
	void insertAccount(Account account);
	/** Account情報を、idをキーに一件取得する */
	Optional<Account> selectOneById(Integer id);
	/** Accountを更新します */
	void updateAccount(Account account);
	/** アカウントを削除します */
	void deleteAccount(Integer id);
}
