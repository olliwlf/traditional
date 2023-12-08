package com.example.springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /** Columns */

    @Column(name="age")
    private Integer age;

    @Column(name="test_group")
    private Integer testGroup = 0; // 0 traditional, 1 scrollytelling

    /** Stimulation */
    @Column(name="stimulation1_langweilig_spannend")
    private Integer stimulation1LangweiligSpannend;
    @Column(name="stimulation2_uninteressant_interessant")
    private Integer stimulation2UninteressantInteressant;
    @Column(name="stimulation3_einschlaefernd_aktivierend")
    private Integer stimulation3EinschlaeferndAktivierend;
    @Column(name="stimulation4_minderwertig_wertvoll")
    private Integer stimulation4MinderwertigWertvoll;
    @Column(name="stimulation_feedback")
    private Integer stimulationFeedback;

    /** Originalität */
    @Column(name="originalitaet1_phantasielos_kreativ")
    private Integer originalitaet1PhantasielosKreativ;
    @Column(name="originalitaet2_konventionell_originell")
    private Integer originalitaet2KonventionellOriginell;
    @Column(name="originalitaet3_herkoemmlich_neuartig")
    private Integer originalitaet3HerkoemmlichNeuartig;
    @Column(name="originalitaet4_konservativ_innovativ")
    private Integer originalitaet4KonservativInnovativ;
    @Column(name="originalitaet_feedback")
    private Integer originalitaetFeedback;

    /** Visuelle Ästhetik */
    @Column(name="visuelleAesthetik1_haesslich_schoen")
    private Integer visuelleAesthetik1HaesslichSchoen;
    @Column(name="visuelleAesthetik2_stillos_stilvoll")
    private Integer visuelleAesthetik2StillosStilvoll;
    @Column(name="visuelleAesthetik3_nichtAnsprechend_ansprechend")
    private Integer visuelleAesthetik3NichtAnsprechendAnsprechend;
    @Column(name="visuelleAesthetik4_unaesthetisch_aesthetisch")
    private Integer visuelleAesthetik4UnaesthetischAesthetisch;
    @Column(name="visuelleAesthetik_feedback")
    private Integer visuelleAesthetikFeedback;

    /** Intuitive Bedienung */
    @Column(name="intuitiveUsability1_muehevoll_muehelos")
    private Integer intuitiveUsability1MuehevollMuehelos;
    @Column(name="intuitiveUsability2_unlogisch_logisch")
    private Integer intuitiveUsability2UnlogischLogisch;
    @Column(name="intuitiveUsability3_nichtEinleuchtend_einleuchtend")
    private Integer intuitiveUsability3NichtEinleuchtendEinleuchtend;
    @Column(name="intuitiveUsability4_nichtSchluessig_schluessig")
    private Integer intuitiveUsability4NichtSchluessigSchluessig;
    @Column(name="intuitiveUsability_feedback")
    private Integer intuitiveUsabilityFeedback;

    /** Inhaltsseriösität */
    @Column(name="inhaltsserioesitaet1_nutzlos_nuetzlich")
    private Integer inhaltsserioesitaet1NutzlosNuetzlich;
    @Column(name="inhaltsserioesitaet2UnglaubwuerdigGlaubwuerdig")
    private Integer inhaltsserioesitaet2UnglaubwuerdigGlaubwuerdig;
    @Column(name="inhaltsserioesitaet3_unserioes_serioes")
    private Integer inhaltsserioesitaet3UnserioesSerioes;
    @Column(name="inhaltsserioesitaet4_ungenau_genau")
    private Integer inhaltsserioesitaet4UngenauGenau;
    @Column(name="inhaltsserioesitaet_feedback")
    private Integer inhaltsserioesitaetFeedback;

    /** Inhaltsqualität */
    @Column(name="inhaltsqualitaet1_veraltet_aktuell")
    private Integer inhaltsqualitaet1VeraltetAktuell;
    @Column(name="inhaltsqualitaet2_uninteressant_interessant")
    private Integer inhaltsqualitaet2UninteressantInteressant;
    @Column(name="inhaltsqualitaet3_schlechtAufbereitet_gutAufbereitet")
    private Integer inhaltsqualitaet3SchlechtAufbereitetGutAufbereitet;
    @Column(name="inhaltsqualitaet4_unverstaendlich_verstaendlich")
    private Integer inhaltsqualitaet4UnverstaendlichVerstaendlich;
    @Column(name="inhaltsqualitaet_feedback")
    private Integer inhaltsqualitaetFeedback;

    /** Foreign Keys */

    @ManyToOne
    @JoinColumn(name="education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name="education_direction_id")
    private EducationDirection educationDirection;

    /** Hibernate */

    @Column(name="created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    private Date createdAt;

    @Column(name="modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @UpdateTimestamp
    private Date modifiedAt;
}
