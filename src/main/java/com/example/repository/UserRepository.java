package com.example.repository;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepository {

	private static final RowMapper<User> USER_ROW_MAPPER = (rs,i) ->{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUserId(rs.getString("user_id"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setZipcode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setImagePath(rs.getString("image_path"));
		user.setCompanyId(rs.getInt("company_id"));
		user.setPoint(rs.getInt("point"));
		return user;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * ユーザー情報登録
	 * @param user
	 */
	public void insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String insertSql = "INSERT INTO users (name, user_id, password, zipcode, "
				+ "address, email, image_path, company_id, point)"
				+ " VALUES (:name, :userId, :password, :zipcode, :address, :email,"
				+ " :imagePath, :companyId, :point);";
		template.update(insertSql, param);
	}
	
	/**
	 * ユーザーIDからユーザー情報を検索
	 * @param userId
	 * @return
	 */
	public User findByUserId(String userId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("user_id", userId);
		System.out.println(userId);
		String findByUserIdSql = "SELECT * FROM users WHERE user_id = :user_id AND deleted = false;";
		try {
			User user = template.queryForObject(findByUserIdSql, param, USER_ROW_MAPPER);
			return user;
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * メールアドレスからユーザー情報を検索
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		String findByEmailSql = "SELECT * FROM users WHERE email = :email AND deleted = false;";
		try {
			User user = template.queryForObject(findByEmailSql, param, USER_ROW_MAPPER);
			return user;
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * 企業IDからユーザー情報を検索
	 * @param companyId
	 * @return
	 */
	public User findByCompanyId(Integer companyId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("companyId", companyId);
		String findByCompanyIdSql = "SELECT * FROM users WHERE company_id = :companyId AND deleted = false;";
		try {
			User user = template.queryForObject(findByCompanyIdSql, param, USER_ROW_MAPPER);
			return user;
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * ユーザー情報の変更
	 * @param user
	 */
	public void update(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String updateSql = "UPDATE users SET name = :name, password = :password ,"
				+ "zipcode = :zipcode, address = :address, email = :email, "
				+ "image_path = :image_path WHERE id = :id;";
		template.update(updateSql, param);
	}
	
	/**
	 * ユーザー退会処理
	 * @param id
	 */
	public void quit(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		String quitSql = "UPDATE users SET deleted = true WHERE id = :id;";
		template.update(quitSql, param);
	}
	
	/**
	 * ユーザー情報削除
	 * @param updatedAt
	 */
	public void delete(Timestamp date, boolean deleted) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("date", date);
		String deleteSql = "DELETE FROM users WHERE updated_at < :date AND deleted = true;";
		template.update(deleteSql, param);
	}
	
	/**
	 * 所有ポイントの更新
	 * @param id
	 * @param point
	 */
	public void changePoint(Integer id, Integer point) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("point", point);
		String changePointSql = "UPDATE users SET point = :point WHERE id = :id;";
		template.update(changePointSql, param);
	}
}
