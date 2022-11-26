import java.util.ArrayList;

public class Programmer {
    private String name;
    private String city;
    private  String country;
    private ArrayList<String> programmingLanguages = new ArrayList<>();
    private ArrayList<String> pendingTasks = new ArrayList<>();
    private ArrayList<String> doneTasks = new ArrayList<>();
    private String schedule;
    private  String password;

    public Programmer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
