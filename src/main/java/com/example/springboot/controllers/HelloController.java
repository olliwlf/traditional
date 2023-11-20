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
public class HelloController {
	@Autowired
	private IEducationRepository educationRepository;

	@Autowired
	private IEducationDirectionRepository educationDirectionRepository;

	@Autowired
	private IPersonRepository personRepository;

	Person currentPerson;


	@Value("${spring.application.name}")
	String appName;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(Model model) {
		model.addAttribute("appName", appName);
		return "startPage";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String showPersonPage(Model model) {
		List<Education> educations = educationRepository.findAll();
		model.addAttribute("educations", educations);

		List<EducationDirection> educationDirections = educationDirectionRepository.findAll();
		model.addAttribute("educationDirections", educationDirections);

		return "personalInfos";
	}

	@RequestMapping(value = "savePerson", method = RequestMethod.POST)
	public String saveUxData(@RequestParam(value = "age", required = false) Integer age,
							 @RequestParam("educationId") Long educationId,
							 @RequestParam("educationDirectionId") Long educationDirectionId) {
		Optional<Education> educationOpt = educationRepository.findById(educationId);
		Optional<EducationDirection> educationDirectionOpt = educationDirectionRepository.findById(educationDirectionId);

		currentPerson = new Person();
		currentPerson.setAge(age);
		if(educationOpt.isPresent() && educationDirectionOpt.isPresent()) {
			currentPerson.setEducation(educationOpt.get());
			currentPerson.setEducationDirection(educationDirectionOpt.get());
		}
		personRepository.saveAndFlush(currentPerson);

		return "redirect:testPage";
	}

	@RequestMapping(value = "/testPage", method = RequestMethod.GET)
	public String showTestPage(Model model) {

		return "testPage";
	}

	@RequestMapping(value = "/survey", method = RequestMethod.GET)
	public String showSurvey(Model model) {
		model.addAttribute("person", currentPerson);
		return "survey";
	}

	@RequestMapping(value = "/saveUxData", method = RequestMethod.POST)
	public String saveUxData(@RequestParam(value = "value1", required = false) Integer value1,
							 @RequestParam(value = "value2", required = false) Integer value2,
							 @RequestParam(value = "value3", required = false) Integer value3) {

		// save user experience data to database
		currentPerson.setValue1(value1);
		currentPerson.setValue2(value2);
		currentPerson.setValue3(value3);
		personRepository.save(currentPerson);

		return "redirect:goodbye";
	}

	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String showEndPage(Model model) {
		Optional<Person> person = personRepository.findAll().stream().findFirst();
		model.addAttribute("person", person.get());
		return "endPage";
	}
}
