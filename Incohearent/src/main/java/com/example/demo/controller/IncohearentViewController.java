package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Account;
import com.example.demo.entity.Card;
import com.example.demo.form.AccountForm;
import com.example.demo.form.CardForm;
import com.example.demo.service.AccountService;
import com.example.demo.service.CardService;


@Controller
@RequestMapping("/Incohearent")
public class IncohearentViewController 
{
	/** DI対象 */
	@Autowired
	AccountService service;
	@Autowired
	CardService cardservice;
	
	/** 「form-backing bean」の初期化 */
	@ModelAttribute("signup/index")
	public AccountForm setUpForm()
	{
		return new AccountForm();
	}
	
	
	
	@GetMapping("play")
	public String showCard(CardForm cardForm, Model model)
	{
		// Get A Card(wrapping by Optional)
		Optional<Card> cardOpt = cardservice.selectOneRandomCard();
		//check if it is present
		if (cardOpt.isPresent())
		{
			//Convert it to CardForm
			Optional<CardForm> cardFormOpt =  cardOpt.map(t -> makeCardForm(t));
			cardForm = cardFormOpt.get();
		}
		else
		{
			model.addAttribute("msg", "Card Not Found");
			return "play";
		}
		
		model.addAttribute("cardForm", cardForm);
		return "play";
	}
	
	@GetMapping("signup/index")
	public String indexView(AccountForm accountForm, Model model)
	{
		return "signup/index";
	}
	
	@PostMapping("signup/confirm")
	public String confirmView(@Validated AccountForm accountForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		//FormからEntityへの変換
		Account account = new Account();
		account.setEmail(accountForm.getEmail());
		account.setUsername(accountForm.getUsername());
		account.setPassword(accountForm.getPassword());
		
		if (!bindingResult.hasErrors())
		{
			service.insertAccount(account);
			return "signup/confirm";
		}
		else
		{
			model.addAttribute("accountForm", accountForm);
			return "signup/index";
		}
	}
	
	@GetMapping("register")
	public String registerView(CardForm cardForm, Model model)
	{
		return "register";
	}
	
	@PostMapping("/insert")
	public String insert(@Validated CardForm cardForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		//FormからEntityへの変換
		Card card = new Card();
		card.setQuestion(cardForm.getQuestion());
		card.setAnswer(cardForm.getAnswer());
		card.setDescription(cardForm.getDescription());
		
		//入力チェック
		if (!bindingResult.hasErrors())
		{
			cardservice.insertCard(card);
			redirectAttributes.addFlashAttribute("complete", "The card is successfully registerd.");
			return "redirect:/Incohearent/register";
		}
		else
		{
			//エラーがある場合は、登録画面を再表示
			return "register";
		}
	}
	
	
	
	@PostMapping("check")
	public String checkCard(CardForm cardForm, @RequestParam String answer, Model model)
	{
		if (cardservice.checkCard(cardForm.getCard_id(), answer))
		{
			model.addAttribute("msg", "Correct!");
		}
		else
		{
			model.addAttribute("msg", "Not Correct!");
		}
		return "answer";
	}
	
	private Card makeCard(CardForm cardForm)
	{
		Card card = new Card();
		card.setCard_id(cardForm.getCard_id());
		card.setQuestion(cardForm.getQuestion());
		card.setAnswer(cardForm.getAnswer());
		card.setDescription(cardForm.getDescription());
		return card;
	}
	
	private CardForm makeCardForm(Card card)
	{
		CardForm form = new CardForm();
		form.setCard_id(card.getCard_id());
		form.setQuestion(card.getQuestion());
		form.setAnswer(card.getAnswer());
		form.setDescription(card.getDescription());
		return form;
	}
	
}
