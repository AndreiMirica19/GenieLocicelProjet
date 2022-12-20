import java.util.ArrayList;

public class Programmer extends Account {
    private String city;
    private  String country;
    private ArrayList<String> programmingLanguages = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();
    private Schedule schedule;
    private boolean assigned = false;
    private Project project;
    private String companyName;
    private Accounts accounts = Accounts.getInstance();



    public Programmer() {
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void addProgrammingLanguage(String programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void assignProject(Project project) {
        this.project = project;
        assigned = true;
    }


    public boolean isAssigned() {
        return assigned;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Name: " + getName());
        System.out.println("Country: " + country);
        System.out.println("City: " + city);
        schedule.displayInfo();
        System.out.println("skills: ");

        for (String skill : skills) {
            System.out.println("    -"+skill);
        }
        System.out.println("-------------------");
    }

    public void displayStatus() {
        project.displayStatus();
    }

    public void displaySkills() {
        System.out.println("Skills: ");
        for (String skill : skills) {
            System.out.println("    -"+skill);
        }
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void completeTask() {
        accounts.completeTask();
    }
}
