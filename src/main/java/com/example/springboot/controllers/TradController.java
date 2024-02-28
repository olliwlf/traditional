package com.example.springboot.controllers;

import com.example.springboot.entities.Education;
import com.example.springboot.entities.EducationDirection;
import com.example.springboot.entities.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/t")
public class TradController {

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
		List<Education> educations = new ArrayList<>();
		var e0 = new Education();
		e0.setTitle("Schule");
		educations.add(e0);
		var e1 = new Education();
		e1.setTitle("Ausbildung");
		educations.add(e1);
		var e2 = new Education();
		e2.setTitle("Bachelor");
		educations.add(e2);
		var e3 = new Education();
		e3.setTitle("Master");
		educations.add(e3);
		model.addAttribute("educations", educations);

		List<EducationDirection> educationDirections = new ArrayList<>();
		var ed0 = new EducationDirection();
		ed0.setTitle("Technik");
		educationDirections.add(ed0);
		var ed1 = new EducationDirection();
		ed1.setTitle("Wirtschaft");
		educationDirections.add(ed1);
		var ed2 = new EducationDirection();
		ed2.setTitle("Verwaltung");
		educationDirections.add(ed2);
		var ed3 = new EducationDirection();
		ed3.setTitle("Kunst");
		educationDirections.add(ed3);
		model.addAttribute("educationDirections", educationDirections);

		Person currentPerson = new Person();
		currentPerson.setTestGroup(0); // traditional -> redirect to testPageT
		model.addAttribute("person", currentPerson);
		return "survey";
	}
}
