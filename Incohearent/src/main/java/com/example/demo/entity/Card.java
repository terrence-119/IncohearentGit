package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Card Table Entity */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	/** 識別用ID */
	@Id
	private Integer card_id;
	/** Card問題 */
	private String question;
	/** Card解答 */
	private String answer;
	/** Card説明 */
	private String description;
}
