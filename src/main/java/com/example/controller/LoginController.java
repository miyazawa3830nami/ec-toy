package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Company;
import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.CompanyService;
import com.example.service.UserService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login_user";
	}
	
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Company company = companyService.login(form.getCompanyId());

		if(!(form.getCompanyUse() == null)) {
			User user = userService.companyLogin(form.getUserId(), form.getPassword(), form.getCompanyId());
			if(company == null) {
				model.addAttribute("companyIdError","企業がみつかりません");
				return toLogin();
			} else {
				if(user == null) {
					model.addAttribute("loginError","ユーザーIDまたはパスワードが間違っています");
					return toLogin();
				}
				session.setAttribute("user", user);
				return "forward:/showList";
			}
		} else {
			User user = userService.login(form.getUserId(), form.getPassword());
			if(user == null) {
				model.addAttribute("loginError","ユーザーIDまたはパスワードが間違っています");
				return toLogin();
			}
			session.setAttribute("user", user);
			return "forward:/showList";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "forward:/";
	}
}
