package com.usermanagment.api.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.usermanagment.api.entity.UserEntity;
import com.usermanagment.api.service.UserManagementService;

@Controller
public class UserManagerController {

	@Autowired
	private UserManagementService userService;

	@GetMapping("/user/management")
	public String userManagement(Model model, HttpSession session) {
		Long user = (Long) session.getAttribute("userId");
		String username = (String) session.getAttribute("username");
		model.addAttribute("registration", "Hi, " + username);
		List<UserEntity> entities = userService.findbyRegId(user);
		model.addAttribute("users", entities);
		return "user-management";
	}

	@GetMapping("/addUser")
	public String loginForm() {
		return "addUser";
	}

	@PostMapping("/addUser")
	public String login(@RequestParam String name, @RequestParam String roles, @RequestParam String location,
			HttpSession session, Model model) {
		UserEntity entity = new UserEntity();
		entity.setLocation(location);
		entity.setName(name);
		entity.setRoles(roles);
		String username = (String) session.getAttribute("username");
		Long user = (Long) session.getAttribute("userId");
		entity.setRegId(Long.valueOf(user));
		if (userService.addUser(entity) != null) {
			model.addAttribute("registration", "Hi, " + username);
			List<UserEntity> entities = userService.findbyRegId(user);
			model.addAttribute("users", entities);

			return "redirect:/user/management";
		}
		return "redirect:/user/management";
	}

	@GetMapping("/user/{id}")
	public String deleteStudent(@PathVariable String id, HttpSession session, Model model) {
		Long vLong = Long.valueOf(id);
		Long user = (Long) session.getAttribute("userId");
		String username = (String) session.getAttribute("username");
		model.addAttribute("registration", "Hi, " + username);
		List<UserEntity> entities = userService.findbyRegId(user);
		model.addAttribute("users", entities);
		userService.deleteUser(vLong);
		return "redirect:/user/management";
	}

}
