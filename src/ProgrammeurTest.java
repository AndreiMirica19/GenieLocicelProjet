import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammeurTest {

    @Test
    void setNom() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        programmeur.setNom("Programmer");
        programmeur.setNom("DDD");
        assertEquals("DDD", programmeur.getNom());
    }

    @Test
    void setMotDePasse() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        programmeur.setMot("Password");
        programmeur.setMot("DDD");
        assertEquals("DDD", programmeur.getMot());
    }

    @Test
    void setProject() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        Projet projet = new Projet();
        projet.setNom("Project");
        programmeur.setProject(projet);
        assertEquals("Project", programmeur.getProject().getNom());
    }

    @Test
    void setNomDeEntreprise() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        programmeur.setNomEntreprise("Company");
        programmeur.setNomEntreprise("DDD");
        assertEquals("DDD", programmeur.getNomEntreprise());
    }

    @Test
    void assignProject() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        Projet projet = new Projet();
        projet.setNom("Project");
        programmeur.assignProject(projet);
        assertEquals("Project", programmeur.getProject().getNom());
    }

    @Test
    void isAssigned() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        Projet projet = new Projet();
        projet.setNom("Project");
        programmeur.assignProject(projet);
        assertTrue(programmeur.isAssignee());
    }

    @Test
    void addSkill() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        programmeur.addSkill("Skill");
        assertTrue(programmeur.getSkills().contains("Skill"));
    }

    /**
     * AUTHOR  Walid Mansour
     * Complex test
     * 1. Create a programmer
     * 2. Create a project
     * 3. Create a company and add the project to the company
     * 4.Assign the project to the programmer
     * 5.Complete tasks
     * 6.Check how many tasks were completed
     */

    @Test
    void completeTask() {
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer2");
        programmeur.addSkill("java");
        Horaire horaire = new Horaire();
        horaire.setHeureDebut("10:00");
        horaire.setHeureFin("11:00");
        horaire.setTimezone("EST");
        programmeur.setHoraire(horaire);
        Comptes.getInstance().ajouterProgrammeur(programmeur);

        Projet projet = new Projet();
        projet.setNom("Project");
        projet.addSkill("java");
        projet.setHoraire(horaire);

        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company2");
        enterprise.ajouterProject(projet);
        Comptes.getInstance().ajouterEntreprise(enterprise);
        programmeur.assignProject(projet);
        programmeur.setNomEntreprise(enterprise.getNom());
        programmeur.completeTask();

        assertEquals(1, programmeur.getProject().getTasksCompletee());

        for (int i = 0; i < 10; i++) {
            programmeur.completeTask();
        }

        assertEquals(11, programmeur.getProject().getTasksCompletee());
    }
}