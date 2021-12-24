package com.example.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 全件検索
	 * @return
	 */
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	/**
	 * ユーザーの商品を表示
	 * @param userId
	 * @return
	 */
	public List<Item> findUserItem(String userId) {
		return itemRepository.findByUserId(userId);
	}
	
	/**
	 * 商品IDを渡して詳細表示
	 * @param id
	 * @return
	 */
	public Item showDetail(Integer id) {
		System.out.println(itemRepository.showDetail(id));
		return itemRepository.showDetail(id);
	}
	
	/**
	 * 商品の登録
	 * @param item
	 */
	public void insertItem(Item item) {
		itemRepository.insertItem(item);
	}
	
	/**
	 * 商品の編集
	 * @param item
	 */
	public void update(Item item) {
		itemRepository.update(item);
	}
	
	/**
	 * 出品の一時停止
	 * @param id
	 */
	public void deleteItem(Integer id) {
		itemRepository.deleteItem(id);
	}
	
	/**
	 * 2つの日付差を求める
	 * @param updatedAt
	 * @return
	 */
	public static int differenceMonth(Timestamp updatedAt) {
		Calendar up = Calendar.getInstance();
		up.setTime(updatedAt);
		up.set(Calendar.DATE, 1);
		LocalDateTime nowDateTime = LocalDateTime.now();
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, 1);
		int count = 0;
		if(up.before(now)) {
			while(up.before(now)) {
				up.add(Calendar.MONTH, 1);
				count--;
			}
		} else {
			count--;
			while (!up.before(now)) {
				up.add(Calendar.MONTH, -1);
				count++;
			}
		}
		return count;
	}
}
