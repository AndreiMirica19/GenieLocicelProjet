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

    /**
     * Complex test
     * 1. Create a programmer
     * 2.call modifyAccount(which returns an account)
     * 3. cast the account to a programmer
     * 4. change the name of the programmer
     * 5. check if the name was changed
     * 6. check if the programmer is in the list of programmers
     * 7. create a company
     * 8. call modifyAccount
     * 9. cast the account to a company
     * 10. change the name of the company
     * 11. check if the name was changed
     * 12. check if the company is in the list of companies
     * 13. create an admin
     * 14. call modifyAccount
     * 15. cast the account to an admin
     * 16. change the name of the admin
     * 17. check if the name was changed
     * 18. call modifyAccount
     * 19. cast the account to a programmer
     * 20. change the password of the programmer
     * 21. check if the password was changed
     * 22. check if the programmer is in the list of programmers
     * 23. create a company
     * 24. call modifyAccount
     * 25. cast the account to a company
     * 26. change the password of the company
     * 27. check if the password was changed
     * 28. check if the company is in the list of companies
     * 29. create an admin
     * 30. call modifyAccount
     * 31. cast the account to an admin
     * 32. change the password of the admin
     * 33. check if the password was changed
     */
    @Test
    void modifyAccount() {
        Admin admin = new Admin();

        Programmer programmer = new Programmer();
        programmer.setName("programmer");
        programmer.setPassword("programmer");
        Schedule schedule = new Schedule();
        schedule.setStartTime("10:00");
        schedule.setEndTime("11:00");
        schedule.setTimezone("EST");
        programmer.setSchedule(schedule);

        Accounts.getInstance().addProgrammer(programmer);
        programmer = (Programmer) Accounts.getInstance().modifyAccount("programmer");
        assertTrue(Accounts.getInstance().getProgrammers().isEmpty());
        programmer.setName("programmer2");
        Accounts.getInstance().addProgrammer(programmer);
        assertEquals("programmer2", Accounts.getInstance().getProgrammers().get(0).getName());

        Company company = new Company();
        company.setName("company");
        company.setPassword("company");
        Accounts.getInstance().addCompany(company);
        company = (Company) Accounts.getInstance().modifyAccount("company");
        assertTrue(Accounts.getInstance().getCompanies().isEmpty());
        company.setName("company2");
        Accounts.getInstance().addCompany(company);
        assertEquals("company2", Accounts.getInstance().getCompanies().get(0).getName());

        Admin admin2 = new Admin();
        admin2.setName("admin2");
        admin2.setPassword("admin2");
        Accounts.getInstance().addAdmin(admin2);
        admin2 = (Admin) Accounts.getInstance().modifyAccount("admin2");
        assertFalse(Accounts.getInstance().getAdmins().contains(admin2));
        admin2.setName("admin3");
        Accounts.getInstance().addAdmin(admin2);
        assertTrue(Accounts.getInstance().getAdmins().contains(admin2));

        programmer = (Programmer) Accounts.getInstance().modifyAccount("programmer2");
        programmer.setPassword("d");
        Accounts.getInstance().addProgrammer(programmer);
        assertEquals("d", Accounts.getInstance().getProgrammers().get(0).getPassword());

        company = (Company) Accounts.getInstance().modifyAccount("company2");
        company.setPassword("d");
        Accounts.getInstance().addCompany(company);
        assertEquals("d", Accounts.getInstance().getCompanies().get(0).getPassword());

        admin2 = (Admin) Accounts.getInstance().modifyAccount("admin3");
        admin2.setPassword("d");
        Accounts.getInstance().addAdmin(admin2);
        assertEquals("d", Accounts.getInstance().getAdmins().get(0).getPassword());
    }

    /**
     * Complex test
     * 1. Create 2 programmers
     * 2. Delete one of them
     * 3. Check if the  right programmer was deleted
     * 4. Create 2 companies
     * 5. Delete one of them
     * 6. Check if the right company was deleted
     * 7. Create 2 admins
     * 8. Delete one of them
     * 9. Check if the right admin was deleted
     */
    @Test
    void deleteAccount() {
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("admin");
        Accounts.getInstance().addAdmin(admin);

        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        programmer.addSkill("java");
        Schedule schedule = new Schedule();
        schedule.setStartTime("10:00");
        schedule.setEndTime("11:00");
        schedule.setTimezone("EST");
        programmer.setSchedule(schedule);
        admin.addProgrammer(programmer);

        Programmer programmer2 = new Programmer();
        programmer2.setName("Programmer2");
        programmer2.addSkill("java");
        programmer2.setSchedule(schedule);
        admin.addProgrammer(programmer);
        admin.deleteAccount("Programmer2");
        assertTrue(Accounts.getInstance().getProgrammers().contains(programmer));
        assertFalse(Accounts.getInstance().getProgrammers().contains(programmer2));

        Admin admin2 = new Admin();
        admin2.setName("admin2");
        admin2.setPassword("admin2");
        admin.addAdmin(admin2);
        admin.deleteAccount("admin2");
        assertFalse(Accounts.getInstance().getAdmins().contains(admin2));
        assertTrue(Accounts.getInstance().getAdmins().contains(admin));

        Company company = new Company();
        company.setName("company");
        admin.addCompany(company);

        Company company2 = new Company();
        company2.setName("company2");
        admin.addCompany(company2);

        admin.deleteAccount("company2");
        assertTrue(Accounts.getInstance().getCompanies().contains(company));
        assertFalse(Accounts.getInstance().getCompanies().contains(company2));
    }
}