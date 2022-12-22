import java.util.ArrayList;

public class Programmeur extends Compte {
    private String ville;
    private  String pays;

    private ArrayList<String> skills = new ArrayList<>();
    private Horaire horaire;
    private boolean assignee = false;
    private Projet projet;
    private String nomEntreprise;
    private Comptes comptes = Comptes.getInstance();



    public Programmeur() {
    }

    public String getNom() {
        return super.getNom();
    }

    public void setNom(String nom) {
        super.setNom(nom);
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMot() {
        return super.getMot();
    }

    public void setMot(String mot) {
        super.setMot(mot);
    }

    public Projet getProject() {
        return projet;
    }

    public void setProject(Projet projet) {
        this.projet = projet;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public void assignProject(Projet projet) {
        this.projet = projet;
        assignee = true;
    }


    public boolean isAssignee() {
        return assignee;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void afficherInfo() {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Name: " + getNom());
        System.out.println("Country: " + pays);
        System.out.println("City: " + ville);
        horaire.displayInfo();
        System.out.println("skills: ");

        for (String skill : skills) {
            System.out.println("    -"+skill);
        }
        System.out.println("-------------------");
    }

    public void aficherStatusDeProjet() {
        projet.aficheStatus();
    }

    public void afficherSkills() {
        System.out.println("Skills: ");
        for (String skill : skills) {
            System.out.println("    -"+skill);
        }
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public void completeTask() {
        comptes.completeTask();
    }
}
