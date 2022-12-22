import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    // complex test
    @Test
    void assignProgrammers() {
        Company company = new Company();
        company.setName("Company");

        Project project = new Project();
        project.setName("Project");
        Schedule schedule = new Schedule();
        schedule.setTimezone("EET");
        schedule.setStartTime("10:00");
        schedule.setEndTime("18:00");
        project.setSchedule(schedule);
        project.addSkill("java");
        project.addSkill("python");
        company.addProject(project);
        Accounts.getInstance().addCompany(company);

        Programmer programmer = new Programmer();
        programmer.setName("Programmer1");
        programmer.addSkill("java");
        programmer.addSkill("python");
        programmer.setSchedule(schedule);
        Accounts.getInstance().addProgrammer(programmer);
        project.setNumberOfProgrammers(10);
        assertTrue(project.getProgrammers().contains(programmer));

        Programmer programmer2 = new Programmer();
        programmer.setName("Programmer2");
        programmer.addSkill("swift");
        programmer.addSkill("c++");
        programmer.setSchedule(schedule);
        Accounts.getInstance().addProgrammer(programmer);
        assertFalse(project.getProgrammers().contains(programmer2));
    }
}