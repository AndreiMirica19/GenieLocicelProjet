import java.util.ArrayList;

public class Programmer extends Account {
    private String city;
    private  String country;
    private ArrayList<String> programmingLanguages = new ArrayList<>();
    private ArrayList<String> pendingTasks = new ArrayList<>();
    private ArrayList<String> doneTasks = new ArrayList<>();
    private ArrayList<String> skills = new ArrayList<>();
    private String schedule;
    private boolean assigned = false;
    private Project project;



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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void addProgrammingLanguage(String programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }

    public void addTask(String task) {
        pendingTasks.add(task);
    }

    public void addDoneTask(String task) {
        pendingTasks.remove(task);
        doneTasks.add(task);
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
        System.out.println("Schedule: " + schedule);
        System.out.println("skills: ");

        for (String skill : skills) {
            System.out.println("    -"+skill);
        }
        System.out.println("-------------------");
    }
}
