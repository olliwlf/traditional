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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/t")
public class TradController {
	@Autowired
	private IEducationRepository educationRepository;

	@Autowired
	private IEducationDirectionRepository educationDirectionRepository;

	@Autowired
	private IPersonRepository personRepository;

	@Value("${spring.application.name}")
	String appName;

	/* traditional test page */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(Model model) {
		model.addAttribute("appName", appName);
		return "startPageT";
	}

	@RequestMapping(value = "/testPage", method = RequestMethod.GET)
	public String showTestPageA(Model model) {

		return "testPageT";
	}

	@RequestMapping(value = "/survey", method = RequestMethod.GET)
	public String showSurvey(Model model) {
		List<Education> educations = educationRepository.findAll();
		model.addAttribute("educations", educations);

		List<EducationDirection> educationDirections = educationDirectionRepository.findAll();
		model.addAttribute("educationDirections", educationDirections);

		Person currentPerson = new Person();
		currentPerson.setTestGroup(0); // traditional -> redirect to testPageT
		model.addAttribute("person", currentPerson);
		return "survey";
	}
}
