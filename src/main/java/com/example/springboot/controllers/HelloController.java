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

	Person currentPerson;
	Long currentPersonId;


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
		currentPerson.setTestGroup(0); // traditional -> redirect to testPageA
		//currentPerson.setTestGroup(1); // scrollytelling -> redirect to testPageB
		if(educationOpt.isPresent() && educationDirectionOpt.isPresent()) {
			currentPerson.setEducation(educationOpt.get());
			currentPerson.setEducationDirection(educationDirectionOpt.get());
		}
		Person newPerson = personRepository.saveAndFlush(currentPerson);
		currentPersonId = newPerson.getId();

		return "redirect:testPageA"; // traditional -> redirect to testPageA
		//return "redirect:testPageB"; // scrollytelling -> redirect to testPageB
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
		if(currentPerson == null) {
			List<Person> persons = personRepository.findAll();
			Optional<Date> lastEntry = persons.stream().map(Person::getCreatedAt).max(Date :: compareTo);
			currentPerson = persons.stream().filter(p -> p.getCreatedAt() == lastEntry.get()).findFirst().get();
		}
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
		model.addAttribute("person", currentPerson);
		return "endPage";
	}
}
