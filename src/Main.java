import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Commands commands = new Commands();
    static boolean quit = false;
    static Accounts accounts = Accounts.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Type info to see the commands");



        while(!quit) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "info" -> displayInfo(commands.getMainMenuCommands());
                case "quit" -> quit = true;
                case "login" -> displayLoginMenu();
            }
        }

    }

    public static void displayInfo(ArrayList<String> info) {
        System.out.println();
        System.out.println("Available commands:");

        for (String command : info) {
            System.out.println("    -"+command);
        }
        System.out.println();
    }

    public static void displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        System.out.println("Login menu. Type info to see the commands");

        while(!back && !quit){
            System.out.print("Please enter a  login command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "info" -> displayInfo(commands.getLoginCommands());
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

            switch (accounts.getAccountType(username, password)) {
                case Admin -> {
                    displayAdminMenu();
                    back = true;
                }
                case Company -> {
                    displayCompanyMenu();
                }
                case Programmer -> {
                    displayProgrammerMenu();
                }
                case Unauthorized -> {
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

    public static void displayAdminMenu() {
        System.out.println("Admin menu.Type info to see the commands");
        boolean logout = false;
        Scanner scanner = new Scanner(System.in);

        while (!logout && !quit) {
            System.out.print("Please enter an Admin menu command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "info" -> displayInfo(commands.getAdminCommands());
                case "add" -> addProgrammer();
                case "list" -> accounts.displayProgrammers();
                case "create" -> createAccount();
                case "modify" -> displayModifyMenu();
                case "logout" -> logout = true;
                case "quit" -> quit = true;
                default -> System.out.println("Unknown command.Please try again");
            }
        }
    }

    public static void addProgrammer() {
        Programmer programmer = new Programmer();
        Scanner scanner = new Scanner(System.in);

        System.out.println();

        System.out.print("Please enter programmer's full name: ");
        String name = scanner.nextLine();
        programmer.setName(name);

        System.out.print("Please enter programmer's country: ");
        String country = scanner.nextLine();
        programmer.setCountry(country);

        System.out.print("Please enter programmer's city: ");
        String city = scanner.nextLine();
        programmer.setCity(city);

        System.out.print("Please enter programmer's schedule: ");
        String schedule = scanner.nextLine();
        programmer.setSchedule(schedule);

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();
        programmer.setPassword(password);

        boolean back = false;
        while (!back) {
            System.out.println("Add a skill: ");
            String skill = scanner.nextLine();
            programmer.addSkill(skill);
            System.out.println("Add another skill? Type yes or no");
            String command = scanner.nextLine();
            if (command.equals("no")) {
                back = true;
            }
        }

        accounts.addProgrammer(programmer);
        System.out.println("Programmer successfully added");
    }

    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of the following type: admin, company, programmer");
        String accountType = scanner.nextLine();

        switch (accountType) {
            case "programmer" -> addProgrammer();
            case "company" -> addCompany();
            case "admin" -> addAdmin();
        }
    }

    public static void addCompany() {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();

        System.out.println();

        System.out.print("Please enter the name of the company: ");
        String name = scanner.nextLine();
        company.setName(name);

        System.out.print("Please enter the country: ");
        String country = scanner.nextLine();
        company.setCountry(country);

        System.out.print("Please enter the city");
        String city = scanner.nextLine();
        company.setCity(city);

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();
        company.setPassword(password);

        accounts.addCompany(company);
        System.out.println("Company successfully added");

    }

    public static void addAdmin() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println();

        System.out.print("Please enter the name of the company: ");
        String name = scanner.nextLine();
        admin.setName(name);

        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();
        admin.setPassword(password);

        accounts.addAdmin(admin);
        System.out.println("Admin successfully added");
    }

    public static void displayModifyMenu() {
        System.out.println("Modify menu.Type info to see the commands");
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while(!back) {
            System.out.print("Please enter an Admin modify menu command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "modify" -> modifyAccount();
                case "password" -> resetPassword();
                case "delete" -> deleteAccount();
                case "back" -> back = true;
            }
        }
    }

    public static void modifyAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        String username = scanner.nextLine();
        Account account = accounts.modifyAccount(username);

        if (account instanceof Programmer) {
            modifyProgrammer((Programmer) account);
        } else {
            if (account instanceof Company) {
                modifyCompany((Company) account);
            } else {
                if (account instanceof Admin) {

                }
            }
        }
    }

    public static void modifyProgrammer(Programmer programmer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type info to see the which details can be changed");
        boolean back = false;

        while (!back) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "name" -> {
                    System.out.print("Please enter the new name: ");
                    String name = scanner.nextLine();
                    programmer.setName(name);
                }
                case "country" -> {
                    System.out.print("Please enter the new country: ");
                    String country = scanner.nextLine();
                    programmer.setCountry(country);
                }
                case "city" -> {
                    System.out.print("Please enter the new city: ");
                    String city = scanner.nextLine();
                    programmer.setCountry(city);
                }
                case "schedule" -> {
                    System.out.print("Please enter the new schedule: ");
                    String schedule = scanner.nextLine();
                    programmer.setSchedule(schedule);
                }
                case "back" -> back = true;
            }
        }

        System.out.println("The new details are: ");
        programmer.displayInfo();
        accounts.addProgrammer(programmer);
    }

    public static void modifyCompany(Company company) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type info to see the which details can be changed");
        boolean back = false;

        while (!back) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "name" -> {
                    System.out.print("Please enter the new name: ");
                    String name = scanner.nextLine();
                    company.setName(name);
                }
                case "country" -> {
                    System.out.print("Please enter the new country: ");
                    String country = scanner.nextLine();
                    company.setCountry(country);
                }
                case "city" -> {
                    System.out.print("Please enter the new city: ");
                    String city = scanner.nextLine();
                    company.setCountry(city);
                }
                case "back" -> back = true;
            }
        }

        System.out.println("The new details are: ");
        company.displayInfo();
        accounts.addCompany(company);
    }

    public static void resetPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        String username = scanner.nextLine();
        Account account = accounts.modifyAccount(username);
        System.out.print("Please enter the new password: ");
        String password = scanner.nextLine();
        account.setPassword(password);

        if (account instanceof Programmer) {
            accounts.addProgrammer((Programmer) account);
        } else {
            if (account instanceof Company) {
                accounts.addCompany((Company) account);
            } else {
                if (account instanceof Admin) {
                    accounts.addAdmin((Admin) account);
                }
            }
        }

    }

    public static void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name");
        String name = scanner.nextLine();
        accounts.deleteAccount(name);
    }

    public static void displayCompanyMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Company menu! Type info to see the commands");

        boolean back = false;
        while (!back && !quit) {
            System.out.println("Type a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add" -> addProject();
                case "project" -> displayProjectMenu();
                case "info" -> displayInfo(commands.getCompanyMenuCommands());
                case "list" -> accounts.displayProjects();
                case "delete" -> deleteProject();
                case "logout" -> back = true;
                case "quit" -> quit = true;
            }
        }
    }

    public static void addProject() {
        Scanner scanner = new Scanner(System.in);
        Project project = new Project();

        System.out.print("Name of the project: ");
        String name = scanner.nextLine();
        project.setName(name);

        System.out.print("Deadline: ");
        String deadline = scanner.nextLine();
        project.setDeadline(deadline);

        System.out.println("Budget: ");
        int budget = scanner.nextInt();
        project.setBudget(budget);

        boolean back = false;
        while (!back) {
            System.out.println("Add a skill: ");
            String skill = scanner.nextLine();
            project.addSkill((skill));
            System.out.println("Add another skill? Type yes or no");
            String command = scanner.nextLine();
            if (command.equals("no")) {
                back = true;
            }
        }

        System.out.println("Number of programmers: ");
        int numberOfProgrammers = scanner.nextInt();
        project.setNumberOfProgrammers(numberOfProgrammers);

        project.displayInfo();
        accounts.addProject(project);

    }

    public static void deleteProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of the project: ");
        String name = scanner.nextLine();
        accounts.deleteProject(name);
        System.out.println("Project deleted");
    }

    public static void displayProjectMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the name of the project: ");
        String projectName = scanner.nextLine();

        if (!accounts.projectExists(projectName)) {
            System.out.println("Project doesn't exist");
            return;
        }


        System.out.println("Project menu. Type info to see the commands");
        boolean back = false;

        while (!back) {
            System.out.println("Type a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "modify" -> modifyProject(accounts.getProject(projectName));
                case "display" -> accounts.displayProgrammersOnProject(projectName);
                case "status" -> accounts.displayProjectStatus(projectName);
                case "info" -> displayInfo(commands.getProjectMenuCommands());
                case  "back" -> back = true;

            }
        }
    }

    public static void modifyProject(Project project) {
        Scanner scanner = new Scanner(System.in);
        accounts.deleteProject(project.getName());
        System.out.println("Type info to see the which details can be changed");
        boolean back = false;

        while (!back) {
            System.out.print("Please enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "name" -> {
                    System.out.print("Please enter the new name: ");
                    String name = scanner.nextLine();
                    project.setName(name);
                }
                case "deadline" -> {
                    System.out.print("Please enter the new deadline: ");
                    String deadline = scanner.nextLine();
                    project.setDeadline(deadline);
                }
                case "budget" -> {
                    System.out.print("Please enter the new budget: ");
                    int budget = scanner.nextInt();
                    project.setBudget(budget);
                }
                case "info" -> displayInfo(commands.getProjectMenuCommands());
                case "back" -> back = true;
            }
        }

        System.out.println("The new details are: ");
        project.displayInfo();
        accounts.addProject(project);
    }

    public static void displayProgrammerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programmer menu! Type info to see the commands");

        boolean back = false;
        while (!back && !quit) {
            System.out.println("Type a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add" -> addSkill();
                case "info" -> displayInfo(commands.getProgrammerMenuCommands());
                case "list" -> accounts.displaySkills();
                case "task" -> accounts.completeTask();
                case "logout" -> back = true;
                case "quit" -> quit = true;
            }
        }
    }

    public static void addSkill() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        while (!back) {
            System.out.println("Add a skill: ");
            String skill = scanner.nextLine();
            accounts.addSkill(skill);
            System.out.println("Add another skill? Type yes or no");
            String command = scanner.nextLine();
            if (command.equals("no")) {
                back = true;
            }
        }
    }
}
