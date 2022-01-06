package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * ユーザー登録
	 * @param user
	 */
	public void insert(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.insert(user);
	}
	
	/**
	 * 個人ユーザーログイン
	 * @param userId
	 * @param password
	 * @return
	 */
	public User login(String userId, String password) {
		User user = userRepository.findByUserId(userId);
		if(user == null) {
			return null;
		}
		if(!(user.getPassword().equals(password))) {
			return null;
		}
		return user;
	}
	
	/**
	 * 企業ユーザーログイン
	 * @param userId
	 * @param password
	 * @param companyId
	 * @return
	 */
	public User companyLogin(String userId, String password, String companyId) {
		try{
			int intCompanyId = Integer.parseInt(companyId);
			User user = userRepository.findByUserId(userId);
			if(user == null) {
				return null;
			}
			if(!(user.getPassword().equals(password))) {
				return null;
			}
			if(!(user.getCompanyId().equals(intCompanyId))){
				return null;
			}
			return user;
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	/** 
	 * ユーザーIDが重複しているか確認
	 * @param userId
	 * @return
	 */
	public String checkUserId(String userId) {
		System.out.println(userRepository.findByUserId(userId)+"重複");
		if(userRepository.findByUserId(userId) == null) {
			return "OK";
		} else {
			return "duplicateUserId";
		}
	}
	/**
	 * メールアドレスが重複しているか確認
	 * @param email
	 * @return
	 */
	public String checkEmail(String email) {
		System.out.println(userRepository.findByEmail(email)+"重複");
		if(userRepository.findByEmail(email) == null) {
			return "OK";
		} else {
			return "duplicateEmail";
		}
	}
	
	/**
	 * ログインボーナス獲得
	 * @param id
	 * @param Point
	 * @return
	public User bonusPoint(Integer id, Integer Point) {
		
	}
	 */
}
