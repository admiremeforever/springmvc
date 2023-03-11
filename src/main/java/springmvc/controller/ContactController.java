package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

	@RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}

	@RequestMapping(value = "/processform", method = RequestMethod.POST)
	public String handleForm(
			@RequestParam("email") String userEmail, 
			@RequestParam("userName") String userName,
			@RequestParam("password") String userPassword, Model model) {

		System.out.println("user Email "+ userEmail);
		System.out.println("user Name "+ userName);
		System.out.println("user Password "+ userPassword);
		
		
		//process data
		model.addAttribute("name", userName);
		model.addAttribute("email", userEmail);
		model.addAttribute("password", userPassword);
		
		
		return "success";
	}
}
