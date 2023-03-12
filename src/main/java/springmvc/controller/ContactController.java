package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void commonDataForMOder(Model m) {
		m.addAttribute("Header", "Submit the below form ");
		m.addAttribute("Desc", "Home for programmer");
		System.out.println("Adding common data to model");
	}

	@RequestMapping("/contact")
	public String showForm(Model m) {
		System.out.println("Form created...");
		return "contact";
	}

	@RequestMapping(value = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		System.out.println(user);
		// process
		int createdUser = this.userService.createUser(user);
		// model.addAttribute("user", user);
		model.addAttribute("msg","User created with id " +createdUser);
		return "success";
	}

}

/*
 * //handler method using @RequestParam will be replaced by @ModelAttribute
 * 
 * @RequestMapping(value = "/processform", method = RequestMethod.POST) public
 * String handleForm(
 * 
 * @RequestParam("email") String userEmail,
 * 
 * @RequestParam("userName") String userName,
 * 
 * @RequestParam("password") String userPassword, Model model) {
 * 
 * // System.out.println("user Email " + userEmail); //
 * System.out.println("user Name " + userName); //
 * System.out.println("user Password " + userPassword);
 * 
 * User user = new User(); user.setEmail(userEmail); user.setUserName(userName);
 * user.setPassword(userPassword); // process data // model.addAttribute("name",
 * userName); // model.addAttribute("email", userEmail); //
 * model.addAttribute("password", userPassword); model.addAttribute(user);
 * System.out.println(user); return "success"; }
 */
