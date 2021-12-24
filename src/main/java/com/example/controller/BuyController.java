package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BuyController {

	/**
	 * 購入手続き画面を表示
	 * @param model
	 * @return
	 */
	@RequestMapping("/showCart")
	public String showCart(Model model) {
		return "buy_item";
	}
	
//	@RequestMapping("/AddToCart")
//	public String addToCart() {
//		
//	}
}
