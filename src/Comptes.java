import java.util.ArrayList;
import java.util.Iterator;

public class Comptes {
    private ArrayList<Programmeur> programmeurs = new ArrayList<>();
    private ArrayList<Enterprise> entreprises = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    private int currentIndex;
    private static Comptes comptes = null;

    private Comptes() {

    }

    public static Comptes getInstance() {
        if (comptes == null) {
            comptes = new Comptes();
        }
        return comptes;
    }

    public void ajouterProgrammeur(Programmeur programmeur) {
        programmeurs.add(programmeur);
        System.out.println("Programmer added successfully!");
    }

    public void ajouterEntreprise(Enterprise enterprise) {
        if (!entreprises.contains(enterprise)) {
            entreprises.add(enterprise);
        }
    }

    public void ajouterAdmin(Admin admin) {
        admins.add(admin);
    }

    public void effacerAccount(String name) {
        Iterator<Programmeur> programmerIterator = programmeurs.iterator();
        Iterator<Enterprise> companyIterator = entreprises.iterator();
        Iterator<Admin> adminIterator = admins.iterator();

        while (programmerIterator.hasNext()) {
            Programmeur programmeur = programmerIterator.next();

            if (programmeur.getNom().equals(name)) {
                programmerIterator.remove();
            }
        }

        while (companyIterator.hasNext()) {
            Enterprise enterprise = companyIterator.next();
            if (enterprise.getNom().equals(name)) {
                companyIterator.remove();
            }
        }

        while (adminIterator.hasNext()) {
            Admin admin = adminIterator.next();
            if (admin.getNom().equals(name)) {
                adminIterator.remove();
            }
        }
        afficherComptes();
    }

    public Compte modifierCompte(String nom) {
        Iterator<Programmeur> programmerIterator = programmeurs.iterator();
        Iterator<Enterprise> companyIterator = entreprises.iterator();
        Iterator<Admin> adminIterator = admins.iterator();

        while (programmerIterator.hasNext()) {
            Programmeur programmeur = programmerIterator.next();

            if (programmeur.getNom().equals(nom)) {
                programmerIterator.remove();
                programmeur.afficherInfo();
                return programmeur;
            }
        }

        while (companyIterator.hasNext()) {
            Enterprise enterprise = companyIterator.next();
            if (enterprise.getNom().equals(nom)) {
                companyIterator.remove();
                enterprise.afficherInfo();
                return enterprise;
            }
        }

        while (adminIterator.hasNext()) {
            Admin admin = adminIterator.next();
            if (admin.getNom().equals(nom)) {
                adminIterator.remove();
                admin.afficherInfo();
                return admin;
            }
        }
        System.out.println("Account doesn't exist");
        return  null;
    }

    public void afficherProgrammers() {
        for (Programmeur programmeur : programmeurs) {
            System.out.println();
            System.out.println("Name: " + programmeur.getNom());
            System.out.println("Country: " + programmeur.getPays());
            System.out.println("City: " + programmeur.getVille());
            System.out.println("Password: " + programmeur.getMot());
            System.out.println("Skills: ");
            for(String skill : programmeur.getSkills()) {
                System.out.println("    -"+skill);
            }
            programmeur.getHoraire().displayInfo();
        }
        System.out.println("------------------------");
    }

    public void afficherAdmins() {
        for (Admin admin : admins) {
            System.out.println();
            System.out.println("Name: " + admin.getNom());
            System.out.println("Password: " + admin.getMot());
        }
        System.out.println("------------------------");
    }

    public void afficherCompanies() {
        for (Enterprise enterprise : entreprises) {
            System.out.println();
            System.out.println("Name: " + enterprise.getNom());
            System.out.println("Country: " + enterprise.getPays());
            System.out.println("City: " + enterprise.getVille());
            System.out.println("Password: " + enterprise.getMot());
        }
        System.out.println("------------------------");
    }

    private void afficherComptes() {
        System.out.println("Admins");
        afficherAdmins();
        System.out.println("Programmers");
        afficherProgrammers();
        System.out.println("Companies");
        afficherCompanies();
    }

    public ArrayList<Programmeur> getProgrammeurs() {
        return programmeurs;
    }

    public TypeDeCompte getTypeDuCompte(String username, String password) {

        for (Admin admin : admins) {
            if (admin.getNom().equals(username) && admin.getMot().equals(password)) {
                currentIndex = admins.indexOf(admin);
                return  TypeDeCompte.Admin;
            }
        }

        for (Programmeur programmeur : programmeurs) {
            if (programmeur.getNom().equals(username) && programmeur.getMot().equals(password)) {
                currentIndex = programmeurs.indexOf(programmeur);
                return TypeDeCompte.Programmeur;
            }
        }

        for (Enterprise enterprise : entreprises) {
            if (enterprise.getNom().equals(username) && enterprise.getMot().equals(password)) {
                currentIndex = entreprises.indexOf(enterprise);
                return  TypeDeCompte.Enterprise;
            }
        }
        return TypeDeCompte.NonAutorisé;
    }

    public  void effacherCompany(String name) {
        Iterator<Enterprise> companyIterator = entreprises.iterator();

        while (companyIterator.hasNext()) {
            Enterprise enterprise = companyIterator.next();
            if (enterprise.getNom().equals(name)) {
                companyIterator.remove();
            }
        }
    }

    public void attribuerProject(Projet projet, String programmerName) {
        for (Programmeur programmeur : programmeurs) {
            if (programmeur.getNom().equals(programmerName)) {
                programmeur.setProject(projet);
                programmeur.setNomEntreprise(entreprises.get(currentIndex).getNom());
            }
        }
    }

    public void completeTask() {
        for (Enterprise enterprise : entreprises) {

            if (enterprise.getNom().equals(programmeurs.get(currentIndex).getNomEntreprise())) {
                enterprise.completeTask(programmeurs.get(currentIndex).getProject().getNom());
                programmeurs.get(currentIndex).setProject(enterprise.getProject(programmeurs.get(currentIndex).getProject().getNom()));
            }
        }
    }

    public  void deleteProgrammer(String name) {
        Iterator<Programmeur> programmerIterator = programmeurs.iterator();

        while (programmerIterator.hasNext()) {
            Programmeur programmeur = programmerIterator.next();
            if (programmeur.getNom().equals(name)) {
                programmerIterator.remove();
            }
        }
    }

    public ArrayList<Enterprise> getEntreprises() {
        return entreprises;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public Admin getAdmin() {
        return admins.get(currentIndex);
    }

    public Programmeur getProgrammer() {
        return programmeurs.get(currentIndex);
    }

    public Enterprise getCompany() {
        return entreprises.get(currentIndex);
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
