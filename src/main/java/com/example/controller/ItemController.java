package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	 * 商品登録ページに遷移
	 * @return
	 */
	@RequestMapping("/toInsertItem")
	public String toInsertItem() {
		return "item_insert";
	}
	
	/**
	 * 商品登録
	 * @param itemform
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertItem")
	public String insertItem(@Validated ItemForm itemForm,
								BindingResult result,
								Model model) {
		if(result.hasErrors()) {
			return "item_insert";
		}
		
		MultipartFile multiFile = itemForm.getImagePath();
		String fileName = multiFile.getOriginalFilename();
		
		File filepath = new File("src/main/resources/static/img/item/"+fileName);
		try {
			byte[] bytes = multiFile.getBytes();
			FileOutputStream stream = new FileOutputStream(filepath.toString());
			stream.write(bytes);
			stream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Item item = new Item();
		BeanUtils.copyProperties(itemForm, item);
		item.setPrice(itemForm.getPrice());
		item.setImagePath(fileName);
		itemService.insertItem(item);
		return "redirect:/showList";
	}
}
