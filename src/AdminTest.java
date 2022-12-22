import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {


    @Test
    void getName() {
        Admin admin = new Admin();
        admin.setName("admin");
        assertEquals("admin", admin.getName());
    }

    @Test
    void setName() {
        Admin admin = new Admin();
        admin.setName("admin3");
        assertEquals("admin3", admin.getName());
    }

    @Test
    void getPassword() {
        Admin admin = new Admin();
        admin.setPassword("admin");
        assertEquals("admin", admin.getPassword());
    }

    @Test
    void setPassword() {
        Admin admin = new Admin();
        admin.setPassword("admin3");
        assertEquals("admin3", admin.getPassword());
    }


    @Test
    void addProgrammer() {
        Admin admin = new Admin();
        Programmer programmer = new Programmer();
        programmer.setName("programmer");
        programmer.setPassword("programmer");
        Schedule schedule = new Schedule();
        schedule.setStartTime("10:00");
        schedule.setEndTime("11:00");
        schedule.setTimezone("EST");
        programmer.setSchedule(schedule);
        programmer.addSkill("java");
        admin.addProgrammer(programmer);
        assertTrue( Accounts.getInstance().getProgrammers().contains(programmer));
    }

    @Test
    void addCompany() {
        Admin admin = new Admin();
        Company company = new Company();
        company.setName("company");
        company.setPassword("company");
        admin.addCompany(company);
        assertEquals(1, Accounts.getInstance().getCompanies().size());
    }

    @Test
    void addAdmin() {
        Admin admin = new Admin();
        Admin admin2 = new Admin();
        admin2.setName("admin2");
        admin2.setPassword("admin2");
        admin.addAdmin(admin2);
        assertEquals("admin2", Accounts.getInstance().getAdmins().get(0).getName());
    }

    @Test
    void modifyAccount() {
        Admin admin = new Admin();
        Programmer programmer = new Programmer();
        programmer.setName("programmer");
        programmer.setPassword("programmer");
        admin.addProgrammer(programmer);
        programmer.setName("programmer2");
        programmer.setPassword("programmer2");
        admin.modifyAccount("programmer");
        assertEquals("programmer2", Accounts.getInstance().getProgrammers().get(0).getName());
    }
}