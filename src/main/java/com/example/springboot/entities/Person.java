package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;

    /** Columns */

    private Integer age;

    private Integer testGroup = 0; // 0 traditional, 1 scrollytelling

    /** Stimulation */
    private Integer stimulation1LangweiligSpannend;
    private Integer stimulation2UninteressantInteressant;
    private Integer stimulation3EinschlaeferndAktivierend;
    private Integer stimulation4MinderwertigWertvoll;
    private Integer stimulationFeedback;

    /** Originalität */
    private Integer originalitaet1PhantasielosKreativ;
    private Integer originalitaet2KonventionellOriginell;
    private Integer originalitaet3HerkoemmlichNeuartig;
    private Integer originalitaet4KonservativInnovativ;
    private Integer originalitaetFeedback;

    /** Visuelle Ästhetik */
    private Integer visuelleAesthetik1HaesslichSchoen;
    private Integer visuelleAesthetik2StillosStilvoll;
    private Integer visuelleAesthetik3NichtAnsprechendAnsprechend;
    private Integer visuelleAesthetik4UnaesthetischAesthetisch;
    private Integer visuelleAesthetikFeedback;

    /** Intuitive Bedienung */
    private Integer intuitiveUsability1MuehevollMuehelos;
    private Integer intuitiveUsability2UnlogischLogisch;
    private Integer intuitiveUsability3NichtEinleuchtendEinleuchtend;
    private Integer intuitiveUsability4NichtSchluessigSchluessig;
    private Integer intuitiveUsabilityFeedback;

    /** Inhaltsseriösität */
    private Integer inhaltsserioesitaet1NutzlosNuetzlich;
    private Integer inhaltsserioesitaet2UnglaubwuerdigGlaubwuerdig;
    private Integer inhaltsserioesitaet3UnserioesSerioes;
    private Integer inhaltsserioesitaet4UngenauGenau;
    private Integer inhaltsserioesitaetFeedback;

    /** Inhaltsqualität */
    private Integer inhaltsqualitaet1VeraltetAktuell;
    private Integer inhaltsqualitaet2UninteressantInteressant;
    private Integer inhaltsqualitaet3SchlechtAufbereitetGutAufbereitet;
    private Integer inhaltsqualitaet4UnverstaendlichVerstaendlich;
    private Integer inhaltsqualitaetFeedback;

    /** Foreign Keys */
    private Education education;

    private EducationDirection educationDirection;

    /** Hibernate */

    private Date createdAt;

    private Date modifiedAt;
}
