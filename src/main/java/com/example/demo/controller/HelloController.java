package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Student;
import com.example.demo.domain.Student2;
import com.example.demo.domain.StudentRepository;

@Controller
public class HelloController {
	
	@Autowired
	private StudentRepository repository;
	
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
	
	@RequestMapping("/agelimit")
	public String hello(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		// do something
		return "agelimit";
	}

	@RequestMapping("/list")
	public String studentlist(Model model) {
		List<Student> oppilasLista = new ArrayList<Student>();
		Student oppilas1 = new Student();
		Student oppilas2 = new Student();
		Student oppilas3 = new Student();
		oppilas1.setFirstName("Kate");
		oppilas1.setLastName("Cole");
		oppilas1.setEmail("kateemail");
		oppilasLista.add(oppilas1);
		oppilas2.setFirstName("Dan");
		oppilas2.setLastName("Brown");
		oppilas2.setEmail("danemail");
		oppilasLista.add(oppilas2);
		oppilas3.setFirstName("Mike");
		oppilas3.setLastName("Mars");
		oppilas3.setEmail("mikeemail");
		oppilasLista.add(oppilas3);
		model.addAttribute("students", oppilasLista);
		return "list";
	}
	
	@RequestMapping(value = "/list2")
	public String studentlist2(Model model) {
		List<Student2> students = repository.findAll();
		model.addAttribute("students", students);
		/*model.addAttribute("students", repository.findAll());*/
		return "list2";
	}
	
	@RequestMapping(value = "/save/{firstName}", method = RequestMethod.POST)
    public String save(@PathVariable("firstName") String firstName, Student student){
        //repository.save(student);
        return "redirect:list2";
    }

}
