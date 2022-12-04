import java.util.ArrayList;
import java.util.Collections;

public class Project {
    String name;
    String deadline;
    ArrayList<String> skills = new ArrayList<>();
    ArrayList<Programmer> programmers = new ArrayList<>();
    private int budget;
    private String schedule;
    private int numberOfProgrammers;
    private Accounts accounts = Accounts.getInstance();

    public Project() {
    }

    public void displayInfo() {
        System.out.println("-----------------------");

        System.out.println("Name: " + name);
        System.out.println("Deadline: " + deadline);
        System.out.println("Necessary skills: ");

        for (String skill : skills) {
            System.out.println("    -"+skill);
        }

        System.out.println();
        System.out.println("Programmers: ");

        for(Programmer programmer : programmers) {
            programmer.displayInfo();
        }

        System.out.println("Budget: " + budget);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public ArrayList<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(ArrayList<Programmer> programmers) {
        this.programmers = programmers;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getNumberOfProgrammers() {
        return numberOfProgrammers;
    }

    public void setNumberOfProgrammers(int numberOfProgrammers) {
        this.numberOfProgrammers = numberOfProgrammers;
        assignProgrammers();
    }

    private void assignProgrammers() {
        for (Programmer programmer : accounts.getProgrammers()) {
            if (!programmer.isAssigned()) {
                if (!Collections.disjoint(skills, programmer.getSkills()) && programmers.size() < numberOfProgrammers) {
                    programmer.assignProject(this);
                    programmers.add(programmer);
                }
            }
        }
    }

    public void displayProgrammers() {
        for (Programmer programmer : programmers) {
            programmer.displayInfo();
        }
    }
}
