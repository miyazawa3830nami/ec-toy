package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Company;
import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.CompanyService;
import com.example.service.UserService;

@Controller
@RequestMapping("")
public class UserController {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * ユーザー登録画面に遷移
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "register_user";
	}
	
	/**
	 * ユーザー登録を行う
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insert(@Validated UserForm form, BindingResult result, 
						RedirectAttributes redirectAttributes, Model model) {

		//	バリデーションチェックによるエラー
		if(result.hasErrors()) {
			System.out.println("error");
			return "register_user";
		}
		
		//パスワードと確認用パスワードが不一致の場合エラー文をリクエストスコープに格納してユーザー登録画面に遷移
		if(!(form.getPassword().equals(form.getConfirmPassword()))) {
			model.addAttribute("passwordNotMatchError", "パスワードと確認用パスワードが不一致です");	
			return "register_user";
		}
		
		//	フォームの値をドメインにコピー
		User user = new User();
		BeanUtils.copyProperties(form, user);

		//	画像の名前を取得・ファイルに保存
		MultipartFile multiFile = form.getImagePath();
		String fileName = multiFile.getOriginalFilename();
		
		System.out.println(form.getPurpose());
		//	画像選択がない場合、デフォルト画像を設定
		if(fileName.equals("") && form.getPurpose().equals("private")){
			try {
				if(form.getGender().equals("male")) {
					user.setImagePath("man.png");
				} else {
					user.setImagePath("woman.png");
				}
			} catch(Exception e) {
				model.addAttribute("genderError","性別を選択してください");
				return "register_user";
			}
		} else if(form.getPurpose().equals("official")){
				//	企業IDから企業名を検索
				Company company = companyService.login(form.getCompanyId());
				
				System.out.println(companyService.login(form.getCompanyId()));
				System.out.println(form.getCompanyId());
				System.out.println(company);
				if(company == null) {
					model.addAttribute("companyIdError","企業がみつかりません");
					return "register_user";
				} else {
					user.setImagePath("woman.png");
					user.setCompanyId(company.getCompanyId());
				}
		} else {
			File filepath = new File("src/main/resources/static/img/user/"+fileName);
			try {
				byte[] bytes = multiFile.getBytes();
				FileOutputStream stream = new FileOutputStream(filepath.toString());
				stream.write(bytes);
				stream.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

			//	画像名をドメインにセット
			user.setImagePath(fileName);
		}

			//	郵便番号のハイフンを消してドメインにセット
			user.setZipcode(form.getZipcode().replace("-", ""));

			//	紹介コード100pt加算
			if(form.getUsecode().equals("shokai")) {
				user.setPoint(100);
			} else if (form.getUsecode().equals("")) {
				user.setPoint(0);
			} else {
				model.addAttribute("codeError", "紹介コードが正しくありません");
				return  "register_user";
			}

			//	ユーザーID	とメールが登録済の場合はSQLで例外が発生するのでtry-catchを行う
			try {
				userService.insert(user);
				redirectAttributes.addFlashAttribute("","登録が完了しました");
				session.removeAttribute("userId");
				session.removeAttribute("email");
				return "login_user";
			} catch (DataIntegrityViolationException e) {
				e.printStackTrace();
				if(userService.checkUserId(form.getUserId()).equals("duplicateUserId")) {
					model.addAttribute("userIdRegistredError","そのユーザーIDはすでに使われています");
					System.out.println(userService.checkUserId(form.getUserId()));
				}
				
				if(userService.checkEmail(form.getEmail()).equals("duplicateEmail")) {
					model.addAttribute("emailRegistredError","そのメールアドレスはすでに使われています");
					System.out.println(userService.checkEmail(form.getEmail()));
				}
				return "register_user";
			}
			
	}

	/**
	 * マイページに遷移
	 * @return
	 */
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}
