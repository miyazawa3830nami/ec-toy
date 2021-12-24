package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Item> ITEM_ROW_MAPPER
	= (rs,i) -> {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPrice(rs.getInt("price"));
		item.setImagePath(rs.getString("image_path"));
		item.setCategory(rs.getString("category"));
		item.setDeleted(rs.getBoolean("deleted"));
		item.setCreatedAt(rs.getTimestamp("created_at"));
		item.setUpdatedAt(rs.getTimestamp("updated_at"));
	return item;
	};
	
	/**
	 * 商品全件検索
	 * @return
	 */
	public List<Item> findAll(){
		String findAllSql = "SELECT * FROM items ORDER BY updated_at DESC;";
		List<Item> itemList = template.query(findAllSql, ITEM_ROW_MAPPER);
		return itemList;
	}
	
	/**
	 * 商品分類から商品を検索（1件もなければnullを返す）
	 * @param category
	 * @return
	 */
	public List<Item> findByCategory(String category){
		String findByCategorySql = "SELECT * FROM items WHERE category = :category ORDER BY updated_at DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("category", category);
		List<Item> itemList = template.query(findByCategorySql, param, ITEM_ROW_MAPPER);
		if(itemList.size() == 0) {
			return null;
		}
		return itemList;
	}

	/**
	 * 価格から商品を検索（1件もなければnullを返す）
	 * @param price
	 * @return
	 */
	public List<Item> findByPrice(Integer price){
		String findByPriceSql = "SELECT * FROM items WHERE price < :price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Item> itemList = template.query(findByPriceSql, param, ITEM_ROW_MAPPER);
		if(itemList.size() == 0) {
			return null;
		}
		return itemList;
	}

	/**
	 * ユーザーIDから商品を検索
	 * @param userId
	 * @return
	 */
	public List<Item> findByUserId(String userId){
		String findByUserIdSql = "SELECT * FROM items WHERE user_id = :userId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		List<Item> itemList = template.query(findByUserIdSql, param, ITEM_ROW_MAPPER);
		if(itemList.size() == 0) {
			return null;
		}
		return itemList;
	}
	
	/**
	 * 商品詳細を表示(idから商品を検索)
	 * @param id
	 * @return
	 */
	public Item showDetail(Integer id) {
		String showDetailSql = "SELECT * FROM items WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(showDetailSql, param, ITEM_ROW_MAPPER);
		return item;
	}
	
	
	/**
	 * 商品の登録（ユーザーid送るようにしたいかも！！！！）
	 * @param item
	 */
	public void insertItem(Item item) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		String insertItemSql = "INSERT INTO items (name, description, price, image_path, category, official) "
				+ "VALUES (:name, :description, :price, :image_path, :category, :official);";
		template.update(insertItemSql, param);
	}
	
	/**
	 * 商品の編集
	 * @param item
	 */
	public void update(Item item) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		String updateSql = "UPDATE items SET name=:name WHERE id = :id;";
		template.update(updateSql, param);
	}
	
	/**
	 * 出品の一時停止（deleteわかりにくいから名前変える？、deleteした商品は履歴では削除されました表示にする？）
	 * @param id
	 */
	public void deleteItem(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		String deleteItemSql = "UPDATE items SET deleted = ture WHERE id = :id;";
		template.update(deleteItemSql, param);
	}
	
}
