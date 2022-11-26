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

            switch (getAccountType(username, password)) {
                case Admin -> {
                    displayAdminMenu();
                    back = true;
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

    public static AccountType getAccountType(String username, String password) {
        if (username.equals("Admin") && password.equals("admin")) {
            return AccountType.Admin;
        } else {
            return AccountType.Unauthorized;
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
                case "modify" -> System.out.println("Modify");
                case "password" -> System.out.println("Password");
                case "delete" -> deleteAccount();
                case "back" -> back = false;
            }
        }
    }

    public static void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the name");
        String name = scanner.nextLine();
        accounts.deleteAccount(name);
    }
}
