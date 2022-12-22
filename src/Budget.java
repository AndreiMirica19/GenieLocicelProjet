public class Budget {
    String salaireBudget;
    String equipmentBudget;
    String personnelDevelopmentBudget;

    public Budget() {
    }

    public String getSalaireBudget() {
        return salaireBudget;
    }

    public void setSalaireBudget(String salaireBudget) {
        this.salaireBudget = salaireBudget;
    }

    public String getEquipmentBudget() {
        return equipmentBudget;
    }

    public void setEquipmentBudget(String equipmentBudget) {
        this.equipmentBudget = equipmentBudget;
    }

    public String getPersonnelDevelopmentBudget() {
        return personnelDevelopmentBudget;
    }

    public void setPersonnelDevelopmentBudget(String personnelDevelopmentBudget) {
        this.personnelDevelopmentBudget = personnelDevelopmentBudget;
    }

    public void displayInfo() {
        System.out.println("Salary budget: " + salaireBudget);
        System.out.println("Equipment budget: " + equipmentBudget);
        System.out.println("Staff development budget: " + personnelDevelopmentBudget);
        System.out.println("Total budget: " + (Integer.parseInt(salaireBudget) + Integer.parseInt(equipmentBudget) + Integer.parseInt(personnelDevelopmentBudget)));
    }
}
