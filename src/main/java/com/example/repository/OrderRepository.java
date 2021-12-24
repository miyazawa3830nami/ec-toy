package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.domain.OrderItem;

@Repository
public class OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * order_itemsにINSERT orderId自動採番
	 * @param orderItem
	 * @return
	 */
	public Integer order(OrderItem orderItem) {
		String orderSql = "INSERT INTO order_items (item_id) VALUES (:itemId);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String[] keyColumnNames = {"id"};
		template.update(orderSql, param, keyHolder, keyColumnNames);
		orderItem.setOrderId(keyHolder.getKey().intValue());
		return orderItem.getOrderId();
	}
	
	//	テーブル結合
}
