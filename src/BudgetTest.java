import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {


    @Test
    void getSalaireBudge() {
        Budget budget = new Budget();
        budget.setSalaireBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setPersonnelDevelopmentBudget("3000");
        assertEquals("1000", budget.getSalaireBudget());
    }

    @Test
    void setSalaireBudget() {
        Budget budget = new Budget();
        budget.setSalaireBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setPersonnelDevelopmentBudget("3000");
        budget.setSalaireBudget("10000");
        assertEquals("10000", budget.getSalaireBudget());
    }

    @Test
    void getEquipmentBudget() {
        Budget budget = new Budget();
        budget.setSalaireBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setPersonnelDevelopmentBudget("3000");
        assertEquals("2000", budget.getEquipmentBudget());
    }

    @Test
    void setEquipmentBudget() {
        Budget budget = new Budget();
        budget.setSalaireBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setPersonnelDevelopmentBudget("3000");
        budget.setEquipmentBudget("20000");
        assertEquals("20000", budget.getEquipmentBudget());
    }

    @Test
    void getPersonnelDevelopmentBudget() {
        Budget budget = new Budget();
        budget.setSalaireBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setPersonnelDevelopmentBudget("3000");
        assertEquals("3000", budget.getPersonnelDevelopmentBudget());
    }

    @Test
    void setPersonnelDevelopmentBudget() {
        Budget budget = new Budget();
        budget.setSalaireBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setPersonnelDevelopmentBudget("3000");
        budget.setPersonnelDevelopmentBudget("30000");
        assertEquals("30000", budget.getPersonnelDevelopmentBudget());
    }
}