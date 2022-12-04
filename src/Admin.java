public class Admin extends Account {

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
}
