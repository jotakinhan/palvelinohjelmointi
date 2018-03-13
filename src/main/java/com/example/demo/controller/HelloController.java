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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Student;
import com.example.demo.domain.Student2;
import com.example.demo.domain.StudentRepository;

@Controller
public class HelloController {

	@Autowired
	private StudentRepository repository;

	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		return "This is the main page";
	}

	@RequestMapping("/contact")
	@ResponseBody
	public String contact() {
		return "This is the contact page";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String home(@RequestParam(value = "name") String name, @RequestParam(value = "location") String location,
			Model model) {
		model.addAttribute("name", name);
		// do something
		return "welcome to the " + location + " " + name;
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

	List<String> frList = new ArrayList<String>();

	@RequestMapping("/list2")
	public String index(@RequestParam(value = "friend", defaultValue = "") String name, Model model) {
		if (name.length() > 0) {
			frList.add(name);
		}
		model.addAttribute("friends", frList);
		return "list2";
	}

	@RequestMapping(value = "/list3")
	public String bookList(Model model) {
		List<Student2> books = repository.findAll();
		Student2 oppilas1 = new Student2();
		oppilas1.setFirstName("Kate");
		oppilas1.setLastName("Cole");
		oppilas1.setEmail("kateemail");
		books.add(oppilas1);
		model.addAttribute("student2s", books);
		model.addAttribute("student2s", new Student2());
		return "list3";
	}

	@RequestMapping(value = "/add")
	public String addStudent2(Model model) {
		model.addAttribute("student", new Student2());
		return "add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Student2 student) {
		repository.save(student);
		return "redirect:list2";
	}

	/*
	 * @RequestMapping(value = "/save/{firstName}", method = RequestMethod.POST)
	 * public String save(@PathVariable("firstName") String firstName, Student
	 * student){ //repository.save(student); return "redirect:list2"; }
	 */

}
