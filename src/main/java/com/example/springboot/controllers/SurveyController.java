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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SurveyController {
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
		return "startPageT";
	}

	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveData(@RequestParam(value = "age", required = false) Integer age,
						  @RequestParam("testGroup") Integer testGroup,
						  @RequestParam("educationId") Long educationId,
						  @RequestParam("educationDirectionId") Long educationDirectionId,
						  @RequestParam(value = "a1") Integer attractivity1,
						  @RequestParam(value = "a2") Integer attractivity2,
						  @RequestParam(value = "a3") Integer attractivity3) {

		Optional<Education> educationOpt = educationRepository.findById(educationId);
		Optional<EducationDirection> educationDirectionOpt = educationDirectionRepository.findById(educationDirectionId);

		Person currentPerson = new Person();
		currentPerson.setAge(age);
		currentPerson.setTestGroup(testGroup);
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
