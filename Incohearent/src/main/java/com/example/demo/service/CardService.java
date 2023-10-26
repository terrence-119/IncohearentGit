package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Card;

/** Card Service Interface */
public interface CardService 
{
	/** クイズ情報を全件取得 */
	Iterable<Card> selectAll();
	/** カード情報を、card_idをキーに1件取得 */
	Optional<Card> selectOneById(Integer card_id);
	/** クイズ情報をランダムで1件取得 */
	Optional<Card> selectOneRandomCard();
	/** カードの正解・不正解を判定 */
	Boolean checkCard(Integer card_id, String answer);
	/** カードを登録 */
	void insertCard(Card card);
	/** カードを更新 */
	void updateCard(Card card);
	/** カードを削除 */
	void deleteCardById(Integer card_id);
}
