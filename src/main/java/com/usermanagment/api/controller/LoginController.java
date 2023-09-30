package com.usermanagment.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usermanagment.api.entity.RegistrationEntity;
import com.usermanagment.api.service.RegistrationService;
import com.usermanagment.api.service.UserManagementService;

@Controller
public class LoginController {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	UserManagementService managementService;

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {
		RegistrationEntity entity = new RegistrationEntity();
		entity.setPassword(password);
		entity.setUsername(username);
		RegistrationEntity response = registrationService.login(entity);
		if (response != null) {
			session.setAttribute("username", username);
			session.setAttribute("userId", response.getId());
			model.addAttribute("registration", "Hi, " + username);
//			List<UserEntity> entities = managementService.findbyRegId(response.getId());
//			model.addAttribute("users", entities);

			return "redirect:/user/management";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	@GetMapping("/register")
	public String registrationForm() {
		return "register";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("userId");
		return "login";
	}

	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String password, Model model) {
		RegistrationEntity entity = new RegistrationEntity();
		entity.setPassword(password);
		entity.setUsername(username);
		String response = registrationService.register(entity);
		if (response != null) {
			model.addAttribute("success", response);
			return "redirect:/login";
		} else {
			model.addAttribute("error", "error while registering");
			return "redirect:/login";
		}
	}

}
