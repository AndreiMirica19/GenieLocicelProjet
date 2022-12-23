import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterpriseTest {

    @Test
    void setNom() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        enterprise.setNom("Company");
        enterprise.setNom("DDD");
        assertEquals("DDD", enterprise.getNom());
    }


    @Test
    void setPays() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        enterprise.setPays("Country");
        enterprise.setPays("DDD");
        assertEquals("DDD", enterprise.getPays());
    }

    @Test
    void setVille() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        enterprise.setVille("City");
        enterprise.setVille("DDD");
        assertEquals("DDD", enterprise.getVille());
    }


    @Test
    void setMot() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        enterprise.setMot("Password");
        enterprise.setMot("DDD");
        assertEquals("DDD", enterprise.getMot());
    }

    @Test
    void ajouterProject() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        Projet projet = new Projet();
        projet.setNom("Project");
        enterprise.ajouterProject(projet);
        assertTrue(enterprise.projectExist("Project"));
    }

    @Test
    void effacerProject() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        Projet projet = new Projet();
        projet.setNom("Project");
        enterprise.ajouterProject(projet);
        enterprise.effacerProject("Project");
        assertFalse(enterprise.projectExist("Project"));
    }

    @Test
    void projectExist() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        Projet projet = new Projet();
        projet.setNom("Project");
        enterprise.ajouterProject(projet);
        assertTrue(enterprise.projectExist("Project"));
    }

    @Test
    void getProject() {
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Company");
        Projet projet = new Projet();
        projet.setNom("Project");
        enterprise.ajouterProject(projet);
        assertEquals("Project", enterprise.getProject("Project").getNom());
    }

}