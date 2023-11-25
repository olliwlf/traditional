package com.example.springboot.controllers;

import com.example.springboot.entities.Education;
import com.example.springboot.entities.EducationDirection;
import com.example.springboot.entities.Person;
import com.example.springboot.repositories.IEducationDirectionRepository;
import com.example.springboot.repositories.IEducationRepository;
import com.example.springboot.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class HelloController {
	@Autowired
	private IEducationRepository educationRepository;

	@Autowired
	private IEducationDirectionRepository educationDirectionRepository;

	@Autowired
	private IPersonRepository personRepository;

	@Value("${spring.application.name}")
	String appName;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(Model model) {
		model.addAttribute("appName", appName);
		return "startPage";
	}

	@RequestMapping(value = "/testPageA", method = RequestMethod.GET)
	public String showTestPageA(Model model) {

		return "testPageA";
	}

	@RequestMapping(value = "/testPageB", method = RequestMethod.GET)
	public String showTestPageB(Model model) {

		return "testPageB";
	}

	@RequestMapping(value = "/survey", method = RequestMethod.GET)
	public String showSurvey(Model model) {
		List<Education> educations = educationRepository.findAll();
		model.addAttribute("educations", educations);

		List<EducationDirection> educationDirections = educationDirectionRepository.findAll();
		model.addAttribute("educationDirections", educationDirections);

		Person currentPerson = new Person();
		//currentPerson.setTestGroup(0); // traditional -> redirect to testPageA
		currentPerson.setTestGroup(1); // scrollytelling -> redirect to testPageB
		model.addAttribute("person", currentPerson);
		return "survey";
	}

	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveData(@RequestParam(value = "age", required = false) Integer age,
						  @RequestParam("educationId") Long educationId,
						  @RequestParam("educationDirectionId") Long educationDirectionId,
						  @RequestParam(value = "a1") Integer attractivity1,
						  @RequestParam(value = "a2") Integer attractivity2,
						  @RequestParam(value = "a3") Integer attractivity3) {

		Optional<Education> educationOpt = educationRepository.findById(educationId);
		Optional<EducationDirection> educationDirectionOpt = educationDirectionRepository.findById(educationDirectionId);

		Person currentPerson = new Person();
		currentPerson.setAge(age);
		//currentPerson.setTestGroup(0); // traditional -> redirect to testPageA
		currentPerson.setTestGroup(1); // scrollytelling -> redirect to testPageB
		if(educationOpt.isPresent() && educationDirectionOpt.isPresent()) {
			currentPerson.setEducation(educationOpt.get());
			currentPerson.setEducationDirection(educationDirectionOpt.get());
		}

		// save user experience data to database
		currentPerson.setValue1(attractivity1);
		currentPerson.setValue2(attractivity2);
		currentPerson.setValue3(attractivity3);

		Person newPerson = personRepository.saveAndFlush(currentPerson);

		return "redirect:goodbye";
	}

	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String showEndPage(Model model) {
		return "endPage";
	}
}
