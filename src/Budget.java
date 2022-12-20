public class Budget {
    String salaryBudget;
    String equipmentBudget;
    String staffDevelopmentBudget;

    public Budget() {
    }

    public String getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(String salaryBudget) {
        this.salaryBudget = salaryBudget;
    }

    public String getEquipmentBudget() {
        return equipmentBudget;
    }

    public void setEquipmentBudget(String equipmentBudget) {
        this.equipmentBudget = equipmentBudget;
    }

    public String getStaffDevelopmentBudget() {
        return staffDevelopmentBudget;
    }

    public void setStaffDevelopmentBudget(String staffDevelopmentBudget) {
        this.staffDevelopmentBudget = staffDevelopmentBudget;
    }

    public void displayInfo() {
        System.out.println("Salary budget: " + salaryBudget);
        System.out.println("Equipment budget: " + equipmentBudget);
        System.out.println("Staff development budget: " + staffDevelopmentBudget);
        System.out.println("Total budget: " + (Integer.parseInt(salaryBudget) + Integer.parseInt(equipmentBudget) + Integer.parseInt(staffDevelopmentBudget)));
    }
}
