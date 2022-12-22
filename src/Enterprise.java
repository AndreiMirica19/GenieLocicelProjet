import java.util.ArrayList;
import java.util.Iterator;

public class Enterprise extends Compte {
    private String pays;
    private String ville;

    private ArrayList<Projet> projets = new ArrayList<>();
    private Comptes comptes = Comptes.getInstance();

    public Enterprise() {
    }

    public String getNom() {
        return super.getNom();
    }

    public void setNom(String nom) {
        super.setNom(nom);
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMot() {
        return super.getMot();
    }

    public void setMot(String mot) {
        super.setMot(mot);
    }

    public void ajouterProject(Projet projet) {
        projets.add(projet);
        comptes.effacherCompany(getNom());
        comptes.ajouterEntreprise(this);
    }

    public void effacerProject(String projectName) {
        Iterator<Projet> projectIterator = projets.iterator();

        while (projectIterator.hasNext()) {
            Projet projet = projectIterator.next();

            if (projet.getNom().equals(projectName)) {
                projectIterator.remove();
            }
        }

        comptes.effacherCompany(getNom());
        comptes.ajouterEntreprise(this);
    }

    public void afficherProjects() {
        for (Projet projet : projets) {
            projet.aficheeInfo();
        }
    }

    public boolean projectExist(String projectName) {
        for (Projet projet : projets) {
            if (projet.nom.equals(projectName)) {
                return true;
            }
        }
        return false;
    }

    public void afficherProgrammeursSurProjet(String projectName) {
        for (Projet projet : projets) {
            if (projet.nom.equals(projectName)) {
                projet.displayProgrammers();
            }
        }
    }

    public Projet getProject(String projectName) {
        for (Projet projet : projets) {
            if (projet.nom.equals(projectName)) {
                return projet;
            }
        }
        System.out.println("Project not found");
        return null;
    }

    public void afficherStatusDeProjet(String projectName) {
        for (Projet projet : projets) {
            if (projet.nom.equals(projectName)) {
                projet.aficheStatus();
            }
        }
    }

    public void completeTask(String projectName) {
        for (Projet projet : projets) {
            if (projet.nom.equals(projectName)) {
                projet.completeTask();
            }
        }
    }
    public void afficherInfo() {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Name: " + getNom());
        System.out.println("Country: " + pays);
        System.out.println("City: " + ville);
        System.out.println("-------------------");
    }

}
