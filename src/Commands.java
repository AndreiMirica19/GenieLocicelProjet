import java.util.ArrayList;

public class Commands {
    private ArrayList<String> mainMenuCommands = new ArrayList<String>();
    private ArrayList<String> loginCommands = new ArrayList<String>();
    private ArrayList<String> adminCommands = new ArrayList<String>();
    private ArrayList<String> adminModdifyCommands = new ArrayList<String>();

    public Commands() {
        addAdminCommands();
        addLoginCommands();
        addMainMenuCommands();
        addAdminModifyCommands();
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

    public ArrayList<String> getMainMenuCommands() {
        return mainMenuCommands;
    }

    public ArrayList<String> getLoginCommands() {
        return loginCommands;
    }

    public ArrayList<String> getAdminCommands() {
        return adminCommands;
    }

    public ArrayList<String> getAdminModdifyCommands() {
        return adminModdifyCommands;
    }
}
