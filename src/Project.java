import java.util.ArrayList;
import java.util.Collections;

public class Project {
    private ProjectType projectType;
    String name;
    String deadline;
    ArrayList<String> skills = new ArrayList<>();
    ArrayList<Programmer> programmers = new ArrayList<>();
    private Budget budget;
    private Schedule schedule;
    private int numberOfProgrammers;
    private Accounts accounts = Accounts.getInstance();
    private int totalTasks = Math.round((float) (Math.random() * 100));
    private int completedTasks = 0;


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

        budget.displayInfo();
        schedule.displayInfo();
        System.out.println("Project type: " + projectType);
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + completedTasks);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setBudget(Budget budget) {
        this.budget = budget;
    }


    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getRemainingTasks() {
        return totalTasks - completedTasks;
    }

    public void displayStatus() {
        System.out.println("Deadline: " + deadline);
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + completedTasks);
        System.out.println("Remaining tasks: " + getRemainingTasks());
        System.out.println();
    }

    public void completeTask() {
        if (totalTasks - completedTasks > 0) {
            completedTasks++;
        }
        System.out.println("Task completed!" + " Remaining tasks: " + getRemainingTasks());
    }

    public void setNumberOfProgrammers(int numberOfProgrammers) {
        this.numberOfProgrammers = numberOfProgrammers;
        assignProgrammers();
    }

     void assignProgrammers() {
        for (Programmer programmer : accounts.getProgrammers()) {
            if (!programmer.isAssigned()) {
                if (!Collections.disjoint(skills, programmer.getSkills()) && programmers.size() < numberOfProgrammers) {
                    programmer.assignProject(this);
                    programmers.add(programmer);
                    accounts.assignProject(this, programmer.getName());
                }
            }
        }
    }

    public void displayProgrammers() {
        for (Programmer programmer : programmers) {
            programmer.displayInfo();
        }
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public ArrayList<Programmer> getProgrammers() {
        return programmers;
    }
}
