import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {


    @Test
    void getSalaryBudget() {
        Budget budget = new Budget();
        budget.setSalaryBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setStaffDevelopmentBudget("3000");
        assertEquals("1000", budget.getSalaryBudget());
    }

    @Test
    void setSalaryBudget() {
        Budget budget = new Budget();
        budget.setSalaryBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setStaffDevelopmentBudget("3000");
        budget.setSalaryBudget("10000");
        assertEquals("10000", budget.getSalaryBudget());
    }

    @Test
    void getEquipmentBudget() {
        Budget budget = new Budget();
        budget.setSalaryBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setStaffDevelopmentBudget("3000");
        assertEquals("2000", budget.getEquipmentBudget());
    }

    @Test
    void setEquipmentBudget() {
        Budget budget = new Budget();
        budget.setSalaryBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setStaffDevelopmentBudget("3000");
        budget.setEquipmentBudget("20000");
        assertEquals("20000", budget.getEquipmentBudget());
    }

    @Test
    void getStaffDevelopmentBudget() {
        Budget budget = new Budget();
        budget.setSalaryBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setStaffDevelopmentBudget("3000");
        assertEquals("3000", budget.getStaffDevelopmentBudget());
    }

    @Test
    void setStaffDevelopmentBudget() {
        Budget budget = new Budget();
        budget.setSalaryBudget("1000");
        budget.setEquipmentBudget("2000");
        budget.setStaffDevelopmentBudget("3000");
        budget.setStaffDevelopmentBudget("30000");
        assertEquals("30000", budget.getStaffDevelopmentBudget());
    }
}