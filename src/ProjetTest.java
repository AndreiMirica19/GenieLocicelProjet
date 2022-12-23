import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetTest {

    /**
     * AUTHOR: MIRICA ANDREI
     * Complex text
     * 1. Add a company
     * 2.Add a project
     * 3. Add a programmer with the same skills and schedule as the project
     * 4. Add a programmer with different skills and same schedule as the project
     * 5. Add a programmer with some skills that are in project skills and some that are not
     * 6. Add a programmer with the same skills but different schedule as the project
     * 7. Add programmers to the project
     * 8. Check if the project contains only the right programmers.
     */

    @Test
    void assignProgrammers() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");

        Projet projet = new Projet();
        projet.setNom("Project");
        Horaire horaire = new Horaire();
        horaire.setTimezone("EET");
        horaire.setHeureDebut("10:00");
        horaire.setHeureFin("18:00");
        projet.setHoraire(horaire);
        projet.addSkill("java");
        projet.addSkill("python");
        enterprise.ajouterProject(projet);
        Comptes.getInstance().ajouterEntreprise(enterprise);

        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer1");
        programmeur.addSkill("java");
        programmeur.addSkill("python");
        programmeur.setHoraire(horaire);
        Comptes.getInstance().ajouterProgrammeur(programmeur);

        Programmeur programmeur2 = new Programmeur();
        programmeur2.setNom("Programmer2");
        programmeur2.addSkill("swift");
        programmeur2.addSkill("c++");
        programmeur2.setHoraire(horaire);
        Comptes.getInstance().ajouterProgrammeur(programmeur2);

        Programmeur programmeur3 = new Programmeur();
        programmeur3.setNom("Programmer3");
        programmeur3.addSkill("java");
        programmeur3.addSkill("python");
        programmeur3.setHoraire(horaire);
        Comptes.getInstance().ajouterProgrammeur(programmeur3);

        Programmeur programmeur4 = new Programmeur();
        programmeur4.setNom("Programmer4");
        programmeur4.addSkill("java");
        programmeur4.setHoraire(horaire);
        Comptes.getInstance().ajouterProgrammeur(programmeur4);

        Horaire wrongHoraire = new Horaire();
        wrongHoraire.setTimezone("EET");
        wrongHoraire.setHeureDebut("10:00");
        wrongHoraire.setHeureFin("12:00");

        Programmeur programmeur5 = new Programmeur();
        programmeur5.setNom("Programmer5");
        programmeur5.addSkill("java");
        programmeur5.setHoraire(wrongHoraire);
        Comptes.getInstance().ajouterProgrammeur(programmeur5);

        projet.setNombreDeProgrammeurs(10);

        assertTrue(projet.getProgrammers().contains(programmeur));
        assertTrue(projet.getProgrammers().contains(programmeur3));
        assertFalse(projet.getProgrammers().contains(programmeur2));
        assertTrue(projet.getProgrammers().contains(programmeur4));
        assertFalse(projet.getProgrammers().contains(programmeur5));
    }
}