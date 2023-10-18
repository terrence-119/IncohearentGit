package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountCrudRepository;

/**
 * Spring Boot 起動クラス
 */
@SpringBootApplication
public class IncohearentApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(IncohearentApplication.class, args).getBean(IncohearentApplication.class).execute();
	}
	
	@Autowired
	AccountCrudRepository repository;
	
	/**
	 * 「登録」と「全件取得」を実行
	 */
	private void execute()
	{
		//登録
		executeInsert();
		//全件取得
		executeSelect();
	}
	
	/**
	 * 登録
	 */
	private void executeInsert()
	{
		//エンティティの作成（idは自動連番で設定するためnullを設定)
		Account account = new Account(null, "a.teppei@icloud.com", "Terrence", "helloworld");
		//リポジトリを使用して登録を実施、結果を取得
		account = repository.save(account);
		//結果を表示
		System.out.println("登録したデータ:" + account);
	}
	
	/**
	 * 全件取得
	 */
	private void executeSelect()
	{
		System.out.println("全件取得します");
		//リポジトリを使用して全件取得を実施、結果を取得
		Iterable<Account> accounts = repository.findAll();
		for (Account account : accounts)
		{
			System.out.println(account);
		}
	}

}
