import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammerTest {

    @Test
    void setName() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        programmer.setName("Programmer");
        programmer.setName("DDD");
        assertEquals("DDD", programmer.getName());
    }

    @Test
    void setPassword() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        programmer.setPassword("Password");
        programmer.setPassword("DDD");
        assertEquals("DDD", programmer.getPassword());
    }

    @Test
    void setProject() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        Project project = new Project();
        project.setName("Project");
        programmer.setProject(project);
        assertEquals("Project", programmer.getProject().getName());
    }

    @Test
    void setCompanyName() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        programmer.setCompanyName("Company");
        programmer.setCompanyName("DDD");
        assertEquals("DDD", programmer.getCompanyName());
    }

    @Test
    void assignProject() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        Project project = new Project();
        project.setName("Project");
        programmer.assignProject(project);
        assertEquals("Project", programmer.getProject().getName());
    }

    @Test
    void isAssigned() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        Project project = new Project();
        project.setName("Project");
        programmer.assignProject(project);
        assertTrue(programmer.isAssigned());
    }

    @Test
    void addSkill() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer");
        programmer.addSkill("Skill");
        assertTrue(programmer.getSkills().contains("Skill"));
    }

    //complex test
    @Test
    void completeTask() {
        Programmer programmer = new Programmer();
        programmer.setName("Programmer2");
        programmer.addSkill("java");
        Schedule schedule = new Schedule();
        schedule.setStartTime("10:00");
        schedule.setEndTime("11:00");
        schedule.setTimezone("EST");
        programmer.setSchedule(schedule);
        Accounts.getInstance().addProgrammer(programmer);

        Project project = new Project();
        project.setName("Project");
        project.addSkill("java");
        project.setSchedule(schedule);

        Company company = new Company();
        company.setName("Company2");
        company.addProject(project);
        Accounts.getInstance().addCompany(company);
        programmer.assignProject(project);
        programmer.setCompanyName(company.getName());
        programmer.completeTask();

        assertEquals(1, programmer.getProject().getCompletedTasks());

        for (int i = 0; i < 10; i++) {
            programmer.completeTask();
        }

        assertEquals(11, programmer.getProject().getCompletedTasks());
    }
}