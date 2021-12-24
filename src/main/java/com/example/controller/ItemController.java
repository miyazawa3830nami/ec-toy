package com.example.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.form.ItemForm;
import com.example.service.ItemService;

@Controller
@RequestMapping("")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 商品一覧を表示
	 * @param model
	 * @return
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList", itemList);
		return "item_list";
	}

	@RequestMapping("/showUserItemList")
	public String showUserItemList(String userId, Model model) {
		List<Item> itemList = itemService.findUserItem(userId);
		model.addAttribute("itemList", itemList);
		return "mypage";
	}
	/**
	 * 商品詳細画面を表示
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Item item = itemService.showDetail(Integer.parseInt(id));
		model.addAttribute("item",item);
		return "item_detail";
	}
	
	/**
	 * まだとちゅう
	 * @param form
	 * @param result
	 * @param model
	 * @param id
	 * @return
	@RequestMapping("/updateItem")
	public String updateItem(@Validated ItemForm form,
								BindingResult result,
								Model model, Integer id) {
		if(result.hasErrors()) {
			return showDetail("id", model);
		}
	}
	 */
	
	/**
	 * 出品の一時停止
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteItem")
	public String deleteItem(Integer id) {
		itemService.deleteItem(id);
		return "redirect:/showList";
	}
	
	/**
	 * 商品登録
	 * @param itemform
	 * @param result
	 * @param model
	 * @return
	@RequestMapping("/insertItem")
	public String insertItem(@Validated ItemForm itemform,
								BindingResult result,
								Model model) {
		if(result.hasErrors()) {
			return "アイテム登録ページ";
		}
	}
	 */
}
