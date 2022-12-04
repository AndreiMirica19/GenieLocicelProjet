import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Accounts {
    private ArrayList<Programmer> programmers = new ArrayList<>();
    private ArrayList<Company> companies = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    private int currentIndex;
    private static Accounts accounts = null;

    private Accounts() {

    }

    public static Accounts getInstance() {
        if (accounts == null) {
            accounts = new Accounts();
        }
        return accounts;
    }

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void deleteAccount(String name) {
        Iterator<Programmer> programmerIterator = programmers.iterator();
        Iterator<Company> companyIterator = companies.iterator();
        Iterator<Admin> adminIterator = admins.iterator();

        while (programmerIterator.hasNext()) {
            Programmer programmer = programmerIterator.next();

            if (programmer.getName().equals(name)) {
                programmerIterator.remove();
            }
        }

        while (companyIterator.hasNext()) {
            Company company = companyIterator.next();
            if (company.getName().equals(name)) {
                companyIterator.remove();
            }
        }

        while (adminIterator.hasNext()) {
            Admin admin = adminIterator.next();
            if (admin.getName().equals(name)) {
                adminIterator.remove();
            }
        }
        displayAccounts();
    }

    public Account modifyAccount(String name) {
        Iterator<Programmer> programmerIterator = programmers.iterator();
        Iterator<Company> companyIterator = companies.iterator();
        Iterator<Admin> adminIterator = admins.iterator();

        while (programmerIterator.hasNext()) {
            Programmer programmer = programmerIterator.next();

            if (programmer.getName().equals(name)) {
                programmerIterator.remove();
                programmer.displayInfo();
                return programmer;
            }
        }

        while (companyIterator.hasNext()) {
            Company company = companyIterator.next();
            if (company.getName().equals(name)) {
                companyIterator.remove();
                company.displayInfo();
                return company;
            }
        }

        while (adminIterator.hasNext()) {
            Admin admin = adminIterator.next();
            if (admin.getName().equals(name)) {
                adminIterator.remove();
                admin.displayInfo();
                return admin;
            }
        }
        System.out.println("Account doesn't exist");
        return  null;
    }

    public void displayProgrammers() {
        for (Programmer programmer : programmers) {
            System.out.println();
            System.out.println("Name: " + programmer.getName());
            System.out.println("Country: " + programmer.getCountry());
            System.out.println("City: " + programmer.getCity());
            System.out.println("Password: " + programmer.getPassword());
        }
        System.out.println("------------------------");
    }

    public void displayAdmins() {
        for (Admin admin : admins) {
            System.out.println();
            System.out.println("Name: " + admin.getName());
            System.out.println("Password: " + admin.getPassword());
        }
        System.out.println("------------------------");
    }

    public void displayCompanies() {
        for (Company company : companies) {
            System.out.println();
            System.out.println("Name: " + company.getName());
            System.out.println("Country: " + company.getCountry());
            System.out.println("City: " + company.getCity());
            System.out.println("Password: " + company.getPassword());
        }
        System.out.println("------------------------");
    }

    private void displayAccounts() {
        System.out.println("Admins");
        displayAdmins();
        System.out.println("Programmers");
        displayProgrammers();
        System.out.println("Companies");
        displayCompanies();
    }

    public ArrayList<Programmer> getProgrammers() {
        return programmers;
    }

    public AccountType getAccountType(String username, String password) {
        if  (username.equals("Admin") && password.equals("admin")) {
            return AccountType.Admin;
        }
        for (Admin admin : admins) {
            if (admin.getName().equals(username) && admin.getPassword().equals(password)) {
                currentIndex = admins.indexOf(admin);
                return  AccountType.Admin;
            }
        }

        for (Programmer programmer : programmers) {
            if (programmer.getName().equals(username) && programmer.getPassword().equals(password)) {
                currentIndex = programmers.indexOf(programmer);
                return AccountType.Programmer;
            }
        }

        for (Company company : companies) {
            if (company.getName().equals(username) && company.getPassword().equals(password)) {
                currentIndex = companies.indexOf(company);
                return  AccountType.Company;
            }
        }
        return AccountType.Unauthorized;
    }

    public void addProject(Project project) {
        Company company = companies.remove(currentIndex);
        company.addProject(project);
        companies.add(company);
    }

    public void deleteProject(String project) {
        Company company = companies.remove(currentIndex);
        company.deleteProject(project);
        companies.add(company);
    }

    public void displayProjects() {
        companies.get(currentIndex).displayProjects();
    }
}
