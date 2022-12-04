import java.util.ArrayList;

public class Commands {
    private ArrayList<String> mainMenuCommands = new ArrayList<String>();
    private ArrayList<String> loginCommands = new ArrayList<String>();
    private ArrayList<String> adminCommands = new ArrayList<String>();
    private ArrayList<String> adminModdifyCommands = new ArrayList<String>();
    private ArrayList<String> modifyProgrammerComands = new ArrayList<>();
    private ArrayList<String> modifyCompanyCommands = new ArrayList<>();
    private ArrayList<String> companyMenuCommands = new ArrayList<>();
    private ArrayList<String> projectMenuCommands = new ArrayList<>();
    private ArrayList<String> modifyProjectCommands = new ArrayList<>();
    private ArrayList<String> programmerMenuCommands = new ArrayList<>();

    public Commands() {
        addAdminCommands();
        addLoginCommands();
        addMainMenuCommands();
        addAdminModifyCommands();
        addModifyProgrammerCommands();
        addModifyCompanyCommands();
        addCompanyMenuCommands();
        addProjectMenuCommands();
        addModifyProjectCommands();
        addProgrammerMenuCommands();
    }

    private void addMainMenuCommands() {
        mainMenuCommands.add("Type login to enter your account");
        mainMenuCommands.add("Type quit to quit");
    }

    private void addLoginCommands() {
        loginCommands.add("Type login to enter email and password");
        loginCommands.add("Type back to go back to the main menu");
        loginCommands.add("Type quit to quit");
    }

    private void addAdminCommands() {
        adminCommands.add("Type add to add a programmer");
        adminCommands.add("Type list to see the list of programmers");
        adminCommands.add("Type create to create an account");
        adminCommands.add("Type modify to go to modify menu");
        adminCommands.add("Type logout to logout");
        adminCommands.add("Type quit to quit");
    }

    private void addAdminModifyCommands() {
        adminModdifyCommands.add("Type modify to modify the details of an account");
        adminModdifyCommands.add("Type password to reset password");
        adminModdifyCommands.add("Type delete to delete an account");
        adminModdifyCommands.add("Type back to go back");
    }

    private void addModifyProgrammerCommands() {
        modifyProgrammerComands.add("Type name to change name");
        modifyProgrammerComands.add("Type country to change country");
        modifyProgrammerComands.add("Type city to change city");
        modifyProgrammerComands.add("Type schedule to change schedule");
        modifyProgrammerComands.add("Type back to go back");

    }

    private void addModifyCompanyCommands() {
        modifyCompanyCommands.add("Type name to change name");
        modifyCompanyCommands.add("Type country to change country");
        modifyCompanyCommands.add("Type city to change city");
    }

    private void addCompanyMenuCommands() {
        companyMenuCommands.add("Type project to see/edit details about a project");
        companyMenuCommands.add("Type add to add a project");
        companyMenuCommands.add("Type list to display the list of projects");
        companyMenuCommands.add("Type delete to delete a project");
        companyMenuCommands.add("Type logout to logout");
        companyMenuCommands.add("Type quit to quit");
    }

    private void addProjectMenuCommands() {
        projectMenuCommands.add("Type modify to modify the project");
        projectMenuCommands.add("Type display to display the programmers");
        projectMenuCommands.add("Type status to view the status of a project");
        projectMenuCommands.add("Type back to go back");
    }

    private void addModifyProjectCommands() {
        modifyProjectCommands.add("Type name to change name");
        modifyProjectCommands.add("Type budget to change budget");
        modifyProjectCommands.add("Type deadline to change deadline");
        modifyProjectCommands.add("Type back to go back");
    }

    private void addProgrammerMenuCommands() {
        programmerMenuCommands.add("Type status to view the status of the project");
        programmerMenuCommands.add("Type task to execute a task");
        programmerMenuCommands.add("Type add to add new skills");
        programmerMenuCommands.add("Type list to display the list of skills");
        programmerMenuCommands.add("Type logout to logout");
        programmerMenuCommands.add("Type quit to quit");
    }

    public ArrayList<String> getProjectMenuCommands() {
        return projectMenuCommands;
    }

    public ArrayList<String> getMainMenuCommands() {
        return mainMenuCommands;
    }

    public ArrayList<String> getLoginCommands() {
        return loginCommands;
    }

    public ArrayList<String> getAdminCommands() {
        return adminCommands;
    }

    public ArrayList<String> getProgrammerMenuCommands() {
        return programmerMenuCommands;
    }

    public ArrayList<String> getAdminModdifyCommands() {
        return adminModdifyCommands;
    }

    public ArrayList<String> getModifyProgrammerComands() {
        return modifyProgrammerComands;
    }

    public ArrayList<String> getModifyCompanyCommands() {
        return modifyCompanyCommands;
    }

    public ArrayList<String> getCompanyMenuCommands() {
        return companyMenuCommands;
    }
}
