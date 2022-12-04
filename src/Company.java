import java.util.ArrayList;
import java.util.Iterator;

public class Company extends Account {
    private String country;
    private String city;

    private ArrayList<Project> projects = new ArrayList<>();

    public Company() {
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void deleteProject(String projectName) {
        Iterator<Project> projectIterator = projects.iterator();

        while (projectIterator.hasNext()) {
            Project project = projectIterator.next();

            if (project.getName().equals(projectName)) {
                projectIterator.remove();
            }
        }
    }

    public void displayProjects() {
        for (Project project : projects) {
            project.displayInfo();
        }
    }

    public boolean projectExist(String projectName) {
        for (Project project : projects) {
            if (project.name.equals(projectName)) {
                return true;
            }
        }
        return false;
    }

    public void displayProgrammersOnProject(String projectName) {
        for (Project project : projects) {
            if (project.name.equals(projectName)) {
                project.displayProgrammers();
            }
        }
    }

    public Project getProject(String projectName) {
        for (Project project : projects) {
            if (project.name.equals(projectName)) {
                return project;
            }
        }
        System.out.println("Project not found");
        return null;
    }

    public void displayProjectStatus(String projectName) {
        for (Project project : projects) {
            if (project.name.equals(projectName)) {
                project.displayStatus();
            }
        }
    }

    public void completeTask(String projectName) {
        for (Project project : projects) {
            if (project.name.equals(projectName)) {
                System.out.println("DDDDDD");
                project.completeTask();
            }
        }
    }
    public void displayInfo() {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Name: " + getName());
        System.out.println("Country: " + country);
        System.out.println("City: " + city);
        System.out.println("-------------------");
    }
}
