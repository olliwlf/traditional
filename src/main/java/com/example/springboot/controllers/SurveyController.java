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
		return "startPageS";
	}

	@RequestMapping(value = "/t", method = RequestMethod.GET)
	public String showStartPageT(Model model) {
		model.addAttribute("appName", appName);
		return "startPageT";
	}

	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public String showStartPageS(Model model) {
		model.addAttribute("appName", appName);
		return "startPageS";
	}

	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveData(@RequestParam(value = "age", required = false) Integer age,
						   @RequestParam("testGroup") Integer testGroup,
						   @RequestParam(value = "s1") Integer stimulation1,
						   @RequestParam(value = "s2") Integer stimulation2,
						   @RequestParam(value = "s3") Integer stimulation3,
						   @RequestParam(value = "s4") Integer stimulation4,
						   @RequestParam(value = "sf") Integer stimulationFeedback,
						   @RequestParam(value = "o1") Integer originalitat1,
						   @RequestParam(value = "o2") Integer originalitat2,
						   @RequestParam(value = "o3") Integer originalitat3,
						   @RequestParam(value = "o4") Integer originalitat4,
						   @RequestParam(value = "of") Integer originalitatFeedback,
						   @RequestParam(value = "a1") Integer visuelleAesthetik1,
						   @RequestParam(value = "a2") Integer visuelleAesthetik2,
						   @RequestParam(value = "a3") Integer visuelleAesthetik3,
						   @RequestParam(value = "a4") Integer visuelleAesthetik4,
						   @RequestParam(value = "af") Integer visuelleAesthetikFeedback,
						   @RequestParam(value = "b1") Integer intuitiveBedienung1,
						   @RequestParam(value = "b2") Integer intuitiveBedienung2,
						   @RequestParam(value = "b3") Integer intuitiveBedienung3,
						   @RequestParam(value = "b4") Integer intuitiveBedienung4,
						   @RequestParam(value = "bf") Integer intuitiveBedienungFeedback,
						   @RequestParam(value = "is1") Integer inhaltsseriositat1,
						   @RequestParam(value = "is2") Integer inhaltsseriositat2,
						   @RequestParam(value = "is3") Integer inhaltsseriositat3,
						   @RequestParam(value = "is4") Integer inhaltsseriositat4,
						   @RequestParam(value = "isf") Integer inhaltsseriositatFeedback,
						   @RequestParam(value = "iq1") Integer inhaltsqualitat1,
						   @RequestParam(value = "iq2") Integer inhaltsqualitat2,
						   @RequestParam(value = "iq3") Integer inhaltsqualitat3,
						   @RequestParam(value = "iq4") Integer inhaltsqualitat4,
						   @RequestParam(value = "iqf") Integer inhaltsqualitatFeedback,
						   @RequestParam("educationId") Long educationId,
						   @RequestParam("educationDirectionId") Long educationDirectionId) {

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
		// - Stimulation
		currentPerson.setStimulation1LangweiligSpannend(stimulation1);
		currentPerson.setStimulation2UninteressantInteressant(stimulation2);
		currentPerson.setStimulation3EinschlaeferndAktivierend(stimulation3);
		currentPerson.setStimulation4MinderwertigWertvoll(stimulation4);
		currentPerson.setStimulationFeedback(stimulationFeedback);
		// - Originalität
		currentPerson.setOriginalitaet1PhantasielosKreativ(originalitat1);
		currentPerson.setOriginalitaet2KonventionellOriginell(originalitat2);
		currentPerson.setOriginalitaet3HerkoemmlichNeuartig(originalitat3);
		currentPerson.setOriginalitaet4KonservativInnovativ(originalitat4);
		currentPerson.setOriginalitaetFeedback(originalitatFeedback);
		// - Visuelle Ästhetik
		currentPerson.setVisuelleAesthetik1HaesslichSchoen(visuelleAesthetik1);
		currentPerson.setVisuelleAesthetik2StillosStilvoll(visuelleAesthetik2);
		currentPerson.setVisuelleAesthetik3NichtAnsprechendAnsprechend(visuelleAesthetik3);
		currentPerson.setVisuelleAesthetik4UnaesthetischAesthetisch(visuelleAesthetik4);
		currentPerson.setVisuelleAesthetikFeedback(visuelleAesthetikFeedback);
		// - Intuitive Bedienung
		currentPerson.setIntuitiveUsability1MuehevollMuehelos(intuitiveBedienung1);
		currentPerson.setIntuitiveUsability2UnlogischLogisch(intuitiveBedienung2);
		currentPerson.setIntuitiveUsability3NichtEinleuchtendEinleuchtend(intuitiveBedienung3);
		currentPerson.setIntuitiveUsability4NichtSchluessigSchluessig(intuitiveBedienung4);
		currentPerson.setIntuitiveUsabilityFeedback(intuitiveBedienungFeedback);
		// - Inhaltsseriösität
		currentPerson.setInhaltsserioesitaet1NutzlosNuetzlich(inhaltsseriositat1);
		currentPerson.setInhaltsserioesitaet2UnglaubwuerdigGlaubwuerdig(inhaltsseriositat2);
		currentPerson.setInhaltsserioesitaet3UnserioesSerioes(inhaltsseriositat3);
		currentPerson.setInhaltsserioesitaet4UngenauGenau(inhaltsseriositat4);
		currentPerson.setInhaltsserioesitaetFeedback(inhaltsseriositatFeedback);
		// - Inhaltsqualität
		currentPerson.setInhaltsqualitaet1VeraltetAktuell(inhaltsqualitat1);
		currentPerson.setInhaltsqualitaet2UninteressantInteressant(inhaltsqualitat2);
		currentPerson.setInhaltsqualitaet3SchlechtAufbereitetGutAufbereitet(inhaltsqualitat3);
		currentPerson.setInhaltsqualitaet4UnverstaendlichVerstaendlich(inhaltsqualitat4);
		currentPerson.setInhaltsqualitaetFeedback(inhaltsqualitatFeedback);

		Person newPerson = personRepository.saveAndFlush(currentPerson);

		return "redirect:goodbye";
	}

	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String showEndPage(Model model) {
		return "endPage";
	}
}
