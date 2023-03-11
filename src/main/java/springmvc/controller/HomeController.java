package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("this is home url...");
		model.addAttribute("name", "Manish Kumar Prasad");
		model.addAttribute("id", 1213);

		List<String> friends = new ArrayList<String>();
		friends.add("Vandan");
		friends.add("Chandan");
		friends.add("Nandan");
		model.addAttribute("f", friends);

		return "index";

	}

	@RequestMapping("/about")
	public String about() {
		System.out.println("This is about controller....");
		return "about";
	}

	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("This is about help cotroler....");
		// creating m&v object
		ModelAndView modelAndView = new ModelAndView();
		// setting data
		modelAndView.addObject("name", "Aman Mehra");

		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time", now);
		//marks 
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(23);
		list.add(34);
		list.add(333);
		list.add(3339);
		
		modelAndView.addObject("marks",  list);
		// setting view name
		modelAndView.setViewName("help");
		return modelAndView;
	}

}
