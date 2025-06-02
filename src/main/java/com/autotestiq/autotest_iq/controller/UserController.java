package com.autotestiq.autotest_iq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.autotestiq.autotest_iq.model.User;
import com.autotestiq.autotest_iq.service.TestCaseService;
import com.autotestiq.autotest_iq.service.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserServices services;
	
	@Autowired
	private TestCaseService testCaseService;
	

	@GetMapping("/regPage")
	public String openRegPage(Model model) {

		model.addAttribute("user", new User());

		return "register";
	}

	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {

		boolean status = services.registerUser(user);

		if (status) {

			model.addAttribute("sucessMsg", "User registered successfully");

		} else {

			model.addAttribute("errorsMsg", "User not registered due to some error");

		}

		return "login";

	}

	@GetMapping("/loginPage")
	public String loginPage(Model model) {

		model.addAttribute("user", new User());
		return "login";

	}

	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {
		User validUser = services.loginUser(user.getEmail(), user.getPassword());

		if (validUser != null) {
			model.addAttribute("userName", validUser.getName());
			
			model.addAttribute("testCases", testCaseService.getAllTestCases());
			return "home";
			
			//return "profile";
		} else {
			model.addAttribute("errorMsg", "Email id and password didnt matched");
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		return "redirect:/loginPage";
	}

}
