package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;

@Service
@Transactional
public class CardServiceImpl implements CardService 
{
	@Autowired
	CardRepository repository;
	
	@Override
	public Iterable<Card> selectAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Card> selectOneById(Integer card_id) {
		// TODO Auto-generated method stub
		return repository.findById(card_id);
	}

	@Override
	public Optional<Card> selectOneRandomCard() {
		// TODO Auto-generated method stub
		//ランダムでcard_idの値を取得
		Integer randid = repository.getRandomId();
		//問題がない場合
		if (randid == null)
		{
			//空のOptionalインスタンスを返す
			return Optional.empty();
		}
		return repository.findById(randid);
	}

	@Override
	public Boolean checkCard(Integer card_id, String answer) {
		// TODO Auto-generated method stub
		Boolean check = false;
		//対象のクイズを取得
		Optional<Card> optCard = repository.findById(card_id);
		//値存在確認チェック
		if (optCard.isPresent())
		{
			Card card = optCard.get();
			//クイズの解答チェック
			if (card.getAnswer().equals(answer))
			{
				check = true;
			}
		}
		return check;
	}

	@Override
	public void insertCard(Card card) {
		// TODO Auto-generated method stub
		repository.save(card);
	}

	@Override
	public void updateCard(Card card) {
		// TODO Auto-generated method stub
		repository.save(card);
	}

	@Override
	public void deleteCardById(Integer card_id) {
		// TODO Auto-generated method stub
		repository.deleteById(card_id);
	}

}
