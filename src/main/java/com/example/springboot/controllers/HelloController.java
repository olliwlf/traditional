package com.example.springboot.controllers;

import com.example.springboot.entities.Education;
import com.example.springboot.entities.EducationDirection;
import com.example.springboot.entities.UserExperience;
import com.example.springboot.repositories.IEducationDirectionRepository;
import com.example.springboot.repositories.IEducationRepository;
import com.example.springboot.repositories.IPersonRepository;
import com.example.springboot.repositories.IUserExperienceRepository;
import com.example.springboot.services.IPersonService;
import com.example.springboot.services.implementations.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.springboot.services.IEducationDirectionService;
import com.example.springboot.services.IEducationService;
import com.example.springboot.services.IUserExperienceService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	@Autowired
	private IEducationRepository educationRepository;

	@Autowired
	private IEducationDirectionRepository educationDirectionRepository;

	@Autowired
	private IUserExperienceRepository userExperienceRepository;

	@Autowired
	private IPersonRepository personRepository;


	@Value("${spring.application.name}")
	String appName;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showStartPage(Model model) {
		model.addAttribute("appName", appName);
		return "startPage";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String showPersonPage(Model model) {
		List<Education> educations = new ArrayList<>();//educationRepository.findAll());
		Education e = new Education();
		e.setTitle("Test Education");
		e.setId(1L);
		educations.add(e);
		model.addAttribute("educations", educations);

		List<EducationDirection> educationDirections = new ArrayList<>(); //educationDirectionService.getAll();
		EducationDirection ed = new EducationDirection();
		ed.setTitle("Test EducationDirection");
		ed.setId(1L);
		educationDirections.add(ed);
		model.addAttribute("educationDirections", educationDirections);

		return "personalInfos";
	}

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public String saveUxData(@RequestParam("age") Integer age,
							 @RequestParam("educationId") Long educationId,
							 @RequestParam("educationDirectionId") Long educationDirectionId) {
		/*Education education = educationService.getById(educationId);
		EducationDirection educationDirection = educationDirectionService.getById(educationDirectionId);

		Person person = new Person();
		person.setAge(age);
		person.setEducation(education);
		person.setEducationDirection(educationDirection);
		personService.save(person);*/

		EducationDirection Wirtschaftswissenschaften = new EducationDirection();
		Wirtschaftswissenschaften.setTitle("Wirtschaftswissenschaften");
		educationDirectionRepository.save(Wirtschaftswissenschaften);

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
	public String saveUxData(@RequestParam(value = "value1", required = false) Integer value1,
							 @RequestParam(value = "value2", required = false) Integer value2,
							 @RequestParam(value = "value3", required = false) Integer value3) {

		/*UserExperience userExperience = new UserExperience();
		userExperience.setValue1(value1);
		userExperience.setValue1(value2);
		userExperience.setValue1(value3);
		userExperienceService.save(userExperience);*/

		return "redirect:goodbye";
	}

	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String showEndPage(Model model) {
		return "endPage";
	}

}
