import java.util.ArrayList;

public class Commands {
    private ArrayList<String> mainMenuCommands = new ArrayList<String>();
    private ArrayList<String> loginCommands = new ArrayList<String>();
    private ArrayList<String> adminCommands = new ArrayList<String>();
    private ArrayList<String> modifierAdminCommands = new ArrayList<String>();
    private ArrayList<String> modifierProgrammerComands = new ArrayList<>();
    private ArrayList<String> modifierCompanyCommands = new ArrayList<>();
    private ArrayList<String> menuDeEntrepriseCommands = new ArrayList<>();
    private ArrayList<String> menuDuProjetCommands = new ArrayList<>();
    private ArrayList<String> modifierProjectCommands = new ArrayList<>();
    private ArrayList<String> menuDeProgrammeurCommands = new ArrayList<>();


    public Commands() {
        ajouterAdminCommands();
        ajouterLoginCommands();
        ajouterMainMenuCommands();
        ajouterModifierAdminCommands();
        ajouterModifierProgrammerComands();
        ajouterModifierCompanyCommands();
        ajouterMenuDeEntrepriseCommands();
        ajouterMenuDuProjetCommands();
        ajouterModifierProjectCommands();
        ajouterMenuDeProgrammeurCommands();
    }

    private void ajouterMainMenuCommands() {
        mainMenuCommands.add("Type login to enter your account");
        mainMenuCommands.add("Type quit to quit");
    }

    private void ajouterLoginCommands() {
        loginCommands.add("Type login to enter email and password");
        loginCommands.add("Type back to go back to the main menu");
        loginCommands.add("Type quit to quit");
    }

    private void ajouterAdminCommands() {
        adminCommands.add("Type add to add a programmer");
        adminCommands.add("Type list to see the list of programmers");
        adminCommands.add("Type create to create an account");
        adminCommands.add("Type modify to go to modify menu");
        adminCommands.add("Type logout to logout");
        adminCommands.add("Type quit to quit");
    }

    private void ajouterModifierAdminCommands() {
        modifierAdminCommands.add("Type modify to modify the details of an account");
        modifierAdminCommands.add("Type password to reset password");
        modifierAdminCommands.add("Type delete to delete an account");
        modifierAdminCommands.add("Type back to go back");
    }

    private void ajouterModifierProgrammerComands() {
        modifierProgrammerComands.add("Type name to change name");
        modifierProgrammerComands.add("Type country to change country");
        modifierProgrammerComands.add("Type city to change city");
        modifierProgrammerComands.add("Type schedule to change schedule");
        modifierProgrammerComands.add("Type back to go back");

    }

    private void ajouterModifierCompanyCommands() {
        modifierCompanyCommands.add("Type name to change name");
        modifierCompanyCommands.add("Type country to change country");
        modifierCompanyCommands.add("Type city to change city");
    }

    private void ajouterMenuDeEntrepriseCommands() {
        menuDeEntrepriseCommands.add("Type project to see/edit details about a project");
        menuDeEntrepriseCommands.add("Type add to add a project");
        menuDeEntrepriseCommands.add("Type list to display the list of projects");
        menuDeEntrepriseCommands.add("Type delete to delete a project");
        menuDeEntrepriseCommands.add("Type logout to logout");
        menuDeEntrepriseCommands.add("Type quit to quit");
    }

    private void ajouterMenuDuProjetCommands() {
        menuDuProjetCommands.add("Type modify to modify the project");
        menuDuProjetCommands.add("Type display to display the programmers");
        menuDuProjetCommands.add("Type status to view the status of a project");
        menuDuProjetCommands.add("Type back to go back");
    }

    private void ajouterModifierProjectCommands() {
        modifierProjectCommands.add("Type name to change name");
        modifierProjectCommands.add("Type budget to change budget");
        modifierProjectCommands.add("Type deadline to change deadline");
        modifierProjectCommands.add("Type back to go back");
    }

    private void ajouterMenuDeProgrammeurCommands() {
        menuDeProgrammeurCommands.add("Type status to view the status of the project");
        menuDeProgrammeurCommands.add("Type task to execute a task");
        menuDeProgrammeurCommands.add("Type add to add new skills");
        menuDeProgrammeurCommands.add("Type list to display the list of skills");
        menuDeProgrammeurCommands.add("Type logout to logout");
        menuDeProgrammeurCommands.add("Type quit to quit");
    }

    public ArrayList<String> getMenuDuProjetCommands() {
        return menuDuProjetCommands;
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

    public ArrayList<String> getMenuDeProgrammeurCommands() {
        return menuDeProgrammeurCommands;
    }

    public ArrayList<String> getModifierAdminCommands() {
        return modifierAdminCommands;
    }

    public ArrayList<String> getModifierProgrammerComands() {
        return modifierProgrammerComands;
    }

    public ArrayList<String> getModifierCompanyCommands() {
        return modifierCompanyCommands;
    }

    public ArrayList<String> getMenuDeEntrepriseCommands() {
        return menuDeEntrepriseCommands;
    }

    public ArrayList<String> getModifierProjectCommands() {
        return modifierProjectCommands;
    }
}
