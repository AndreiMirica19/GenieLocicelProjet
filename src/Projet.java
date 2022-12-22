import java.util.ArrayList;
import java.util.Collections;

public class Projet {
    private ProjectType typeDuProjet;
    String nom;
    String dateLimite;
    ArrayList<String> skills = new ArrayList<>();
    ArrayList<Programmeur> programmeurs = new ArrayList<>();
    private Budget budget;
    private Horaire horaire;
    private int nombreDeProgrammeurs;
    private Comptes comptes = Comptes.getInstance();
    private int totalTasks = Math.round((float) (Math.random() * 100));
    private int tasksCompletee = 0;


    public Projet() {
    }

    public void aficheeInfo() {
        System.out.println("-----------------------");

        System.out.println("Name: " + nom);
        System.out.println("Deadline: " + dateLimite);
        System.out.println("Necessary skills: ");

        for (String skill : skills) {
            System.out.println("    -"+skill);
        }

        System.out.println();
        System.out.println("Programmers: ");

        for(Programmeur programmeur : programmeurs) {
            programmeur.afficherInfo();
        }

        budget.displayInfo();
        horaire.displayInfo();
        System.out.println("Project type: " + typeDuProjet);
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + tasksCompletee);
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }


    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }

    public int getRemainingTasks() {
        return totalTasks - tasksCompletee;
    }

    public void aficheStatus() {
        System.out.println("Deadline: " + dateLimite);
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + tasksCompletee);
        System.out.println("Remaining tasks: " + getRemainingTasks());
        System.out.println();
    }

    public void completeTask() {
        if (totalTasks - tasksCompletee > 0) {
            tasksCompletee++;
        }
        System.out.println("Task completed!" + " Remaining tasks: " + getRemainingTasks());
    }

    public void setNombreDeProgrammeurs(int nombreDeProgrammeurs) {
        this.nombreDeProgrammeurs = nombreDeProgrammeurs;
        assignerProgrammeurs();
    }

     void assignerProgrammeurs() {
        for (Programmeur programmeur : comptes.getProgrammeurs()) {
            if (!programmeur.isAssignee()) {
                if (!Collections.disjoint(skills, programmeur.getSkills()) && programmeurs.size() < nombreDeProgrammeurs) {
                    programmeur.assignProject(this);
                    if (programmeur.getHoraire().equals(horaire)) {
                        programmeurs.add(programmeur);
                        comptes.attribuerProject(this, programmeur.getNom());
                    }
                }
            }
        }
    }

    public void displayProgrammers() {
        for (Programmeur programmeur : programmeurs) {
            programmeur.afficherInfo();
        }
    }

    public void setTypeDuProjet(ProjectType typeDuProjet) {
        this.typeDuProjet = typeDuProjet;
    }

    public int getTasksCompletee() {
        return tasksCompletee;
    }

    public ArrayList<Programmeur> getProgrammers() {
        return programmeurs;
    }
}
