package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Form */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardForm 
{
	/** 識別ID */
	private Integer card_id;
	/** カードの内容 */
	@NotBlank
	private String question;
	/** カードの解答 */
	@NotBlank
	private String answer;
	/** カードの詳細 */
	@NotBlank
	private String description;
}
