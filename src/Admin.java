public class Admin extends Account {

    private Accounts accounts = Accounts.getInstance();

    public Admin() {
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getPassword() {
       return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("-------------------");
        System.out.println("Name: " + getName());
        System.out.println("-------------------");
    }

    public void addProgrammer(Programmer programmer) {
        accounts.addProgrammer(programmer);
    }

    public void addCompany(Company company) {
        accounts.addCompany(company);
    }

    public void addAdmin(Admin admin) {
        accounts.addAdmin(admin);
    }

    public void deleteAccount(String name) {
        accounts.deleteAccount(name);
    }

    public Account modifyAccount(String name) {
        return accounts.modifyAccount(name);
    }

    public void displayProgrammers() {
        accounts.displayProgrammers();
    }


}
