import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Commands commands = new Commands();
    static boolean quit = false;
    static Comptes comptes = Comptes.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Type info to see the commands");

        Admin admin = new Admin();
        admin.setNom("Admin");
        admin.setMot("admin");
        comptes.ajouterAdmin(admin);


        while(!quit) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "info" -> afficherInfo(commands.getMainMenuCommands());
                case "quit" -> quit = true;
                case "login" -> afficherLoginMenu();
            }
        }

    }

    public static void afficherInfo(ArrayList<String> info) {
        System.out.println();
        System.out.println("Available commands:");

        for (String command : info) {
            System.out.println("    -"+command);
        }
        System.out.println();
    }

    public static void afficherLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        System.out.println("Login menu. Type info to see the commands");

        while(!back && !quit){
            System.out.print("Please enter a  login command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "info" -> afficherInfo(commands.getLoginCommands());
                case "quit" -> quit = true;
                case "login" -> login();
                case "back" -> {
                    System.out.println("Main menu.Type info to see the commands");
                    back = true;
                }
            }
        }
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back && !quit) {
            System.out.print("Please enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();

            switch (comptes.getTypeDuCompte(username, password)) {
                case Admin -> {
                    afficherAdminMenu();
                    back = true;
                }
                case Enterprise -> {
                    afficherEntrepriseMenu();
                }
                case Programmeur -> {
                    afficherMenuDeProgrammeur();
                }
                case NonAutorisé -> {
                    System.out.println("Incorrect Credentials, try again?");
                    System.out.println("Type yes or no");
                    String command = scanner.nextLine();
                    if (command.equals("no")) {
                        back = true;
                    }
                }
            }

        }

    }

    public static void afficherAdminMenu() {
        System.out.println("Admin menu.Type info to see the commands");
        boolean logout = false;
        Scanner scanner = new Scanner(System.in);

        Admin admin =  comptes.getAdmin();

        while (!logout && !quit) {
            System.out.print("Please enter an Admin menu command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "info" -> afficherInfo(commands.getAdminCommands());
                case "add" -> ajouterProgrammeur();
                case "list" -> admin.afficherProgrammers();
                case "create" -> createCompte();
                case "modify" -> afficheModifyMenu();
                case "logout" -> logout = true;
                case "quit" -> quit = true;
                default -> System.out.println("Unknown command.Please try again");
            }
        }
    }

    public static void ajouterProgrammeur() {
        Programmeur programmeur = new Programmeur();
        Scanner scanner = new Scanner(System.in);
        Admin admin =  comptes.getAdmin();

        System.out.println();

        System.out.print("Please enter programmer's full name: ");
        String name = scanner.nextLine();
        programmeur.setNom(name);

        System.out.print("Please enter programmer's country: ");
        String country = scanner.nextLine();
        programmeur.setPays(country);

        System.out.print("Please enter programmer's city: ");
        String city = scanner.nextLine();
        programmeur.setVille(city);

        System.out.print("Please enter programmer's start time: ");
        Horaire horaire = new Horaire();
        String startTime = scanner.nextLine();
        horaire.setHeureDebut(startTime);
        System.out.print("Please enter programmer's end time: ");
        String endTime = scanner.nextLine();
        horaire.setHeureFin(endTime);
        System.out.print("Please enter programmer's timezone: ");
        String timezone = scanner.nextLine();
        horaire.setTimezone(timezone);
        programmeur.setHoraire(horaire);

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();
        programmeur.setMot(password);

        boolean back = false;
        while (!back) {
            System.out.println("Add a skill: ");
            String skill = scanner.nextLine();
            programmeur.addSkill(skill);
            System.out.println("Add another skill? Type yes or no");
            String command = scanner.nextLine();
            if (command.equals("no")) {
                back = true;
            }
        }

        admin.ajouterProgrammer(programmeur);
        System.out.println("Programmer successfully added");
    }

    public static void createCompte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of the following type: admin, company, programmer");
        String accountType = scanner.nextLine();

        switch (accountType) {
            case "programmer" -> ajouterProgrammeur();
            case "company" -> ajouterEntreprise();
            case "admin" -> ajouterAdmin();
        }
    }

    public static void ajouterEntreprise() {
        Scanner scanner = new Scanner(System.in);
        Enterprise enterprise = new Enterprise();
        Admin admin =  comptes.getAdmin();
        System.out.println();

        System.out.print("Please enter the name of the company: ");
        String name = scanner.nextLine();
        enterprise.setNom(name);

        System.out.print("Please enter the country: ");
        String country = scanner.nextLine();
        enterprise.setPays(country);

        System.out.print("Please enter the city");
        String city = scanner.nextLine();
        enterprise.setVille(city);

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();
        enterprise.setMot(password);

        admin.ajouterEntreprise(enterprise);
        System.out.println("Company successfully added");

    }

    public static void ajouterAdmin() {
        Scanner scanner = new Scanner(System.in);
        Admin currentAdmin =  comptes.getAdmin();
        Admin admin = new Admin();

        System.out.println();

        System.out.print("Please enter the name of the company: ");
        String name = scanner.nextLine();
        admin.setNom(name);

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();
        admin.setMot(password);

        currentAdmin.ajouterAdmin(admin);
        System.out.println("Admin successfully added");
    }

    public static void afficheModifyMenu() {
        System.out.println("Modify menu.Type info to see the commands");
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while(!back) {
            System.out.print("Please enter an Admin modify menu command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "modify" -> modifierAccount();
                case "password" -> resetMotDePasse();
                case "delete" -> effacerCompte();
                case "back" -> back = true;
            }
        }
    }

    public static void modifierAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        String username = scanner.nextLine();

        Admin currentAdmin =  comptes.getAdmin();
        Compte compte = currentAdmin.modifierCompte(username);

        if (compte instanceof Programmeur) {
            modifierProgrammer((Programmeur) compte);
        } else {
            if (compte instanceof Enterprise) {
                modifierEntreprise((Enterprise) compte);
            } else {
                if (compte instanceof Admin) {

                }
            }
        }
    }

    public static void modifierProgrammer(Programmeur programmeur) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type info to see the which details can be changed");
        boolean back = false;
        Admin currentAdmin =  comptes.getAdmin();

        while (!back) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "name" -> {
                    System.out.print("Please enter the new name: ");
                    String name = scanner.nextLine();
                    programmeur.setNom(name);
                }
                case "country" -> {
                    System.out.print("Please enter the new country: ");
                    String country = scanner.nextLine();
                    programmeur.setPays(country);
                }
                case "city" -> {
                    System.out.print("Please enter the new city: ");
                    String city = scanner.nextLine();
                    programmeur.setPays(city);
                }
                case "schedule" -> {
                    System.out.print("Please enter programmer's start time: ");
                    Horaire horaire = new Horaire();
                    String startTime = scanner.nextLine();
                    horaire.setHeureDebut(startTime);
                    System.out.print("Please enter programmer's end time: ");
                    String endTime = scanner.nextLine();
                    horaire.setHeureFin(endTime);
                    System.out.print("Please enter programmer's timezone: ");
                    String timezone = scanner.nextLine();
                    horaire.setTimezone(timezone);
                    programmeur.setHoraire(horaire);
                }
                case "back" -> back = true;
            }
        }

        System.out.println("The new details are: ");
        programmeur.afficherInfo();
        currentAdmin.ajouterProgrammer(programmeur);
    }

    public static void modifierEntreprise(Enterprise enterprise) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type info to see the which details can be changed");
        boolean back = false;
        Admin currentAdmin =  comptes.getAdmin();

        while (!back) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "name" -> {
                    System.out.print("Please enter the new name: ");
                    String name = scanner.nextLine();
                    enterprise.setNom(name);
                }
                case "country" -> {
                    System.out.print("Please enter the new country: ");
                    String country = scanner.nextLine();
                    enterprise.setPays(country);
                }
                case "city" -> {
                    System.out.print("Please enter the new city: ");
                    String city = scanner.nextLine();
                    enterprise.setPays(city);
                }
                case "back" -> back = true;
            }
        }

        System.out.println("The new details are: ");
        enterprise.afficherInfo();
        currentAdmin.ajouterEntreprise(enterprise);
    }

    public static void resetMotDePasse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        Admin currentAdmin =  comptes.getAdmin();
        String username = scanner.nextLine();
        Compte compte = currentAdmin.modifierCompte(username);
        System.out.print("Please enter the new password: ");
        String password = scanner.nextLine();
        compte.setMot(password);

        if (compte instanceof Programmeur) {
            currentAdmin.ajouterProgrammer((Programmeur) compte);
        } else {
            if (compte instanceof Enterprise) {
                currentAdmin.ajouterEntreprise((Enterprise) compte);
            } else {
                if (compte instanceof Admin) {
                    currentAdmin.ajouterAdmin((Admin) compte);
                }
            }
        }

    }

    public static void effacerCompte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name");
        String name = scanner.nextLine();
        Admin admin = comptes.getAdmin();
        admin.effacerAccount(name);
    }

    public static void afficherEntrepriseMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Company menu! Type info to see the commands");
        Enterprise enterprise = comptes.getCompany();

        boolean back = false;
        while (!back && !quit) {
            System.out.println("Type a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add" -> ajouterProject();
                case "project" -> afficherProjectMenu();
                case "info" -> afficherInfo(commands.getMenuDeEntrepriseCommands());
                case "list" -> enterprise.afficherProjects();
                case "delete" -> effacerProject();
                case "logout" -> back = true;
                case "quit" -> quit = true;
            }
        }
    }

    public static void ajouterProject() {
        Scanner scanner = new Scanner(System.in);
        Projet projet = new Projet();
        Enterprise enterprise = comptes.getCompany();

        System.out.print("Name of the project: ");
        String name = scanner.nextLine();
        projet.setNom(name);

        System.out.println("Select one of the following type of projects (long, short, medium): ");
        ProjectType type;
        while (true) {
            String typeString = scanner.nextLine();
            if (typeString.equals("long")) {
                type = ProjectType.longTerm;
                break;
            } else {
                if (typeString.equals("short")) {
                    type = ProjectType.shortTerm;
                    break;
                } else {
                    if (typeString.equals("medium")) {
                        type = ProjectType.midTerm;
                        break;
                    } else {
                        System.out.println("Please enter a valid type of project");
                    }
                }
            }
        }
        projet.setTypeDuProjet(type);

        System.out.print("Please enter projects's start time: ");
        Horaire horaire = new Horaire();
        String startTime = scanner.nextLine();
        horaire.setHeureDebut(startTime);
        System.out.print("Please enter projects's end time: ");
        String endTime = scanner.nextLine();
        horaire.setHeureFin(endTime);
        System.out.print("Please enter projects's timezone: ");
        String timezone = scanner.nextLine();
        horaire.setTimezone(timezone);
        projet.setHoraire(horaire);

        System.out.print("Deadline: ");
        String deadline = scanner.nextLine();
        projet.setDateLimite(deadline);

        Budget budget = new Budget();
        System.out.print("Salary budget: ");
        String salaryBudget = scanner.nextLine();
        budget.setSalaireBudget(salaryBudget);
        System.out.print("Equipment budget: ");
        String equipmentBudget = scanner.nextLine();
        budget.setEquipmentBudget(equipmentBudget);
        System.out.print("Staff development budget: ");
        budget.setPersonnelDevelopmentBudget(scanner.nextLine());
        projet.setBudget(budget);


        boolean back = false;
        while (!back) {
            System.out.println("Add a skill: ");
            String skill = scanner.nextLine();
            projet.addSkill((skill));
            System.out.println("Add another skill? Type yes or no");
            String command = scanner.nextLine();
            if (command.equals("no")) {
                back = true;
            }
        }

        System.out.println("Number of programmers: ");
        int numberOfProgrammers = scanner.nextInt();
        projet.setNombreDeProgrammeurs(numberOfProgrammers);

        projet.aficheeInfo();
        enterprise.ajouterProject(projet);

    }

    public static void effacerProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of the project: ");
        Enterprise enterprise = comptes.getCompany();
        String name = scanner.nextLine();
        enterprise.effacerProject(name);
        System.out.println("Project deleted");
    }

    public static void afficherProjectMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the project: ");
        String projectName = scanner.nextLine();
        Enterprise enterprise = comptes.getCompany();

        if (!enterprise.projectExist(projectName)) {
            System.out.println("Project doesn't exist");
            return;
        }


        System.out.println("Project menu. Type info to see the commands");
        boolean back = false;

        while (!back) {
            System.out.println("Type a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "modify" -> modifierProject(enterprise.getProject(projectName));
                case "display" -> enterprise.afficherProgrammeursSurProjet(projectName);
                case "status" -> enterprise.afficherStatusDeProjet(projectName);
                case "info" -> afficherInfo(commands.getMenuDuProjetCommands());
                case  "back" -> back = true;

            }
        }
    }

    public static void modifierProject(Projet projet) {
        Scanner scanner = new Scanner(System.in);
        Enterprise enterprise = comptes.getCompany();
        enterprise.effacerProject(projet.getNom());
        System.out.println("Type info to see the which details can be changed");
        boolean back = false;

        while (!back) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "name" -> {
                    System.out.print("Please enter the new name: ");
                    String name = scanner.nextLine();
                    projet.setNom(name);
                }
                case "deadline" -> {
                    System.out.print("Please enter the new deadline: ");
                    String deadline = scanner.nextLine();
                    projet.setDateLimite(deadline);
                }
                case "budget" -> {
                    Budget budget = new Budget();
                    System.out.print("Salary budget: ");
                    String salaryBudget = scanner.nextLine();
                    budget.setSalaireBudget(salaryBudget);
                    System.out.print("Equipment budget: ");
                    String equipmentBudget = scanner.nextLine();
                    budget.setEquipmentBudget(equipmentBudget);
                    System.out.print("Staff development budget: ");
                    budget.setPersonnelDevelopmentBudget(scanner.nextLine());
                    projet.setBudget(budget);
                    projet.aficheeInfo();
                }
                case "info" -> afficherInfo(commands.getModifierProjectCommands());
                case "back" -> back = true;
            }
        }

        System.out.println("The new details are: ");
        projet.aficheeInfo();
        enterprise.ajouterProject(projet);
    }

    public static void afficherMenuDeProgrammeur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programmer menu! Type info to see the commands");
        Programmeur programmeur = comptes.getProgrammer();

        boolean back = false;
        while (!back && !quit) {
            System.out.println("Type a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add" -> addSkill();
                case "info" -> afficherInfo(commands.getMenuDeProgrammeurCommands());
                case "list" -> programmeur.afficherSkills();
                case "task" -> programmeur.completeTask();
                case "status" -> programmeur.aficherStatusDeProjet();
                case "logout" -> back = true;
                case "quit" -> quit = true;
            }
        }
    }

    public static void addSkill() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        Programmeur programmeur = comptes.getProgrammer();
        while (!back) {
            System.out.println("Add a skill: ");
            String skill = scanner.nextLine();
            programmeur.addSkill(skill);
            System.out.println("Add another skill? Type yes or no");
            String command = scanner.nextLine();
            if (command.equals("no")) {
                back = true;
            }
        }
    }
}
