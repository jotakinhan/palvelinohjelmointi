package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
	@RequestMapping("/index")
	public String index() {
		return "This is the main page";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "This is the contact page";
	}
	
	@RequestMapping("/hello")
	public String home(@RequestParam(value = "name") String name, @RequestParam(value = "location") String location, Model model) {
		model.addAttribute("name",name);
		// do something
		return "welcome to the "+location+" "+name;
	}
	
	/*public String homea(@RequestParam(value = "location") String location, Model model) {
		model.addAttribute("location",location);
		// do something
		return "hello "+location;
	}*/

}
