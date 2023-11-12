package com.example.springboot;

import entities.Education;
import entities.Person;
import entities.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import services.IUserExperienceService;
import services.implementations.EducationService;
import services.implementations.PersonService;
import services.implementations.UserExperienceService;

@Controller
public class HelloController {

	EducationService educationService = new EducationService();
	IUserExperienceService userExperienceService = new UserExperienceService();
	PersonService personService = new PersonService();


	@Value("${spring.application.name}")
	String appName;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(Model model) {
		// get next id from database
		// add id to model for each page to create a new dataset

		model.addAttribute("appName", appName);
		return "startPage";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String showPersonPage(Model model) {

		return "personalInfos";
	}

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public String saveUxData(@RequestParam("age") Integer age,
							 @RequestParam("educationId") Long educationId) {
		Education education = educationService.getById(educationId);

		Person person = new Person();
		person.setAge(age);
		person.setEducation(education);
		personService.save(person);

		return "redirect:testPage";
	}

	@RequestMapping(value = "/testPage", method = RequestMethod.GET)
	public String showTestPage(Model model) {

		return "testPage";
	}

	@RequestMapping(value = "/survey", method = RequestMethod.GET)
	public String showSurvey(Model model) {
		model.addAttribute("userExperience", new UserExperience());
		return "survey";
	}

	@RequestMapping(value = "/saveUxData", method = RequestMethod.POST)
	public String saveUxData(@RequestParam("value1") Integer value1,
							 @RequestParam("value2") Integer value2,
							 @RequestParam("value3") Integer value3) {

		UserExperience userExperience = new UserExperience();
		userExperience.setValue1(value1);
		userExperience.setValue1(value2);
		userExperience.setValue1(value3);
		userExperienceService.save(userExperience);

		return "redirect:goodbye";
	}

	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String showEndPage(Model model) {
		return "endPage";
	}

}
