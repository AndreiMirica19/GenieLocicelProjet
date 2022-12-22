import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {


    @Test
    void getNom() {
        Admin admin = new Admin();
        admin.setNom("admin");
        assertEquals("admin", admin.getNom());
    }

    @Test
    void setNom() {
        Admin admin = new Admin();
        admin.setNom("admin3");
        assertEquals("admin3", admin.getNom());
    }

    @Test
    void setMotDePass() {
        Admin admin = new Admin();
        admin.setMot("admin3");
        assertEquals("admin3", admin.getMot());
    }


    @Test
    void ajouterProgrammeur() {
        Admin admin = new Admin();
        Programmeur programmeur = new Programmeur();
        programmeur.setNom("programmer");
        programmeur.setMot("programmer");
        Horaire horaire = new Horaire();
        horaire.setHeureDebut("10:00");
        horaire.setHeureFin("11:00");
        horaire.setTimezone("EST");
        programmeur.setHoraire(horaire);
        programmeur.addSkill("java");
        admin.ajouterProgrammer(programmeur);
        assertTrue( Comptes.getInstance().getProgrammeurs().contains(programmeur));
    }

    @Test
    void ajouterEntreprise() {
        Admin admin = new Admin();
        Enterprise enterprise = new Enterprise();
        enterprise.setNom("Entreprise");
        enterprise.setMot("company");
        admin.ajouterEntreprise(enterprise);
        assertTrue(Comptes.getInstance().getEntreprises().contains(enterprise));
    }

    @Test
    void addAdmin() {
        Admin admin = new Admin();
        Admin admin2 = new Admin();
        admin2.setNom("admin2");
        admin2.setMot("admin2");
        admin.ajouterAdmin(admin2);
        assertEquals("admin2", Comptes.getInstance().getAdmins().get(0).getNom());
    }

    /**
     * Complex test
     * 1. Create a programmer
     * 2.call modifyAccount(which returns an account)
     * 3. cast the account to a programmer
     * 4. change the name of the programmer
     * 5. check if the name was changed
     * 6. check if the programmer is in the list of programmers
     * 7. create a company
     * 8. call modifyAccount
     * 9. cast the account to a company
     * 10. change the name of the company
     * 11. check if the name was changed
     * 12. check if the company is in the list of companies
     * 13. create an admin
     * 14. call modifyAccount
     * 15. cast the account to an admin
     * 16. change the name of the admin
     * 17. check if the name was changed
     * 18. call modifyAccount
     * 19. cast the account to a programmer
     * 20. change the password of the programmer
     * 21. check if the password was changed
     * 22. check if the programmer is in the list of programmers
     * 23. create a company
     * 24. call modifyAccount
     * 25. cast the account to a company
     * 26. change the password of the company
     * 27. check if the password was changed
     * 28. check if the company is in the list of companies
     * 29. create an admin
     * 30. call modifyAccount
     * 31. cast the account to an admin
     * 32. change the password of the admin
     * 33. check if the password was changed
     */
    @Test
    void modifierCompte() {
        Admin admin = new Admin();

        Programmeur programmeur = new Programmeur();
        programmeur.setNom("programmer");
        programmeur.setMot("programmer");
        Horaire horaire = new Horaire();
        horaire.setHeureDebut("10:00");
        horaire.setHeureFin("11:00");
        horaire.setTimezone("EST");
        programmeur.setHoraire(horaire);

        Comptes.getInstance().ajouterProgrammeur(programmeur);
        programmeur = (Programmeur) Comptes.getInstance().modifierCompte("programmer");
        assertTrue(Comptes.getInstance().getProgrammeurs().isEmpty());
        programmeur.setNom("programmer2");
        Comptes.getInstance().ajouterProgrammeur(programmeur);
        assertEquals("programmer2", Comptes.getInstance().getProgrammeurs().get(0).getNom());

        Enterprise enterprise = new Enterprise();
        enterprise.setNom("company");
        enterprise.setMot("company");
        Comptes.getInstance().ajouterEntreprise(enterprise);
        enterprise = (Enterprise) Comptes.getInstance().modifierCompte("company");
        assertTrue(Comptes.getInstance().getEntreprises().isEmpty());
        enterprise.setNom("company2");
        Comptes.getInstance().ajouterEntreprise(enterprise);
        assertEquals("company2", Comptes.getInstance().getEntreprises().get(0).getNom());

        Admin admin2 = new Admin();
        admin2.setNom("admin2");
        admin2.setMot("admin2");
        Comptes.getInstance().ajouterAdmin(admin2);
        admin2 = (Admin) Comptes.getInstance().modifierCompte("admin2");
        assertFalse(Comptes.getInstance().getAdmins().contains(admin2));
        admin2.setNom("admin3");
        Comptes.getInstance().ajouterAdmin(admin2);
        assertTrue(Comptes.getInstance().getAdmins().contains(admin2));

        programmeur = (Programmeur) Comptes.getInstance().modifierCompte("programmer2");
        programmeur.setMot("d");
        Comptes.getInstance().ajouterProgrammeur(programmeur);
        assertEquals("d", Comptes.getInstance().getProgrammeurs().get(0).getMot());

        enterprise = (Enterprise) Comptes.getInstance().modifierCompte("company2");
        enterprise.setMot("d");
        Comptes.getInstance().ajouterEntreprise(enterprise);
        assertEquals("d", Comptes.getInstance().getEntreprises().get(0).getMot());

        admin2 = (Admin) Comptes.getInstance().modifierCompte("admin3");
        admin2.setMot("d");
        Comptes.getInstance().ajouterAdmin(admin2);
        assertEquals("d", Comptes.getInstance().getAdmins().get(1).getMot());
    }

    /**
     * Complex test
     * 1. Create 2 programmers
     * 2. Delete one of them
     * 3. Check if the  right programmer was deleted
     * 4. Create 2 companies
     * 5. Delete one of them
     * 6. Check if the right company was deleted
     * 7. Create 2 admins
     * 8. Delete one of them
     * 9. Check if the right admin was deleted
     */
    @Test
    void effacerAccount() {
        Admin admin = new Admin();
        admin.setNom("admin");
        admin.setMot("admin");
        Comptes.getInstance().ajouterAdmin(admin);

        Programmeur programmeur = new Programmeur();
        programmeur.setNom("Programmer");
        programmeur.addSkill("java");
        Horaire horaire = new Horaire();
        horaire.setHeureDebut("10:00");
        horaire.setHeureFin("11:00");
        horaire.setTimezone("EST");
        programmeur.setHoraire(horaire);
        admin.ajouterProgrammer(programmeur);

        Programmeur programmeur2 = new Programmeur();
        programmeur2.setNom("Programmer2");
        programmeur2.addSkill("java");
        programmeur2.setHoraire(horaire);
        admin.ajouterProgrammer(programmeur);
        admin.effacerAccount("Programmer2");
        assertTrue(Comptes.getInstance().getProgrammeurs().contains(programmeur));
        assertFalse(Comptes.getInstance().getProgrammeurs().contains(programmeur2));

        Admin admin2 = new Admin();
        admin2.setNom("admin2");
        admin2.setMot("admin2");
        admin.ajouterAdmin(admin2);
        admin.effacerAccount("admin2");
        assertFalse(Comptes.getInstance().getAdmins().contains(admin2));
        assertTrue(Comptes.getInstance().getAdmins().contains(admin));

        Enterprise enterprise = new Enterprise();
        enterprise.setNom("company");
        admin.ajouterEntreprise(enterprise);

        Enterprise enterprise2 = new Enterprise();
        enterprise2.setNom("company2");
        admin.ajouterEntreprise(enterprise2);

        admin.effacerAccount("company2");
        assertTrue(Comptes.getInstance().getEntreprises().contains(enterprise));
        assertFalse(Comptes.getInstance().getEntreprises().contains(enterprise2));
    }
}