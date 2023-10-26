package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Card;

/** Card Table RepositoryImpl */
public interface CardRepository extends CrudRepository<Card, Integer> 
{
	@Query("SELECT card_id FROM card ORDER BY RANDOM() limit 1")
	Integer getRandomId();
}
