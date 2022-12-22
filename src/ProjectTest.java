import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    /**
     * Complex text
     * 1. Add a company
     * 2.Add a project
     * 3. Add a programmer with the same skills and schedule as the project
     * 4. Add a programmer with different skills and same schedule as the project
     * 5. Add a programmer with some skills that are in project skills and some that are not
     * 6. Add a programmer with the same skills but different schedule as the project
     * 7. Add programmers to the project
     * 8. Check if the project contains only the right programmers.
     */
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

        Programmer programmer2 = new Programmer();
        programmer2.setName("Programmer2");
        programmer2.addSkill("swift");
        programmer2.addSkill("c++");
        programmer2.setSchedule(schedule);
        Accounts.getInstance().addProgrammer(programmer2);

        Programmer programmer3 = new Programmer();
        programmer3.setName("Programmer3");
        programmer3.addSkill("java");
        programmer3.addSkill("python");
        programmer3.setSchedule(schedule);
        Accounts.getInstance().addProgrammer(programmer3);

        Programmer programmer4 = new Programmer();
        programmer4.setName("Programmer4");
        programmer4.addSkill("java");
        programmer4.setSchedule(schedule);
        Accounts.getInstance().addProgrammer(programmer4);

        Schedule wrongSchedule = new Schedule();
        wrongSchedule.setTimezone("EET");
        wrongSchedule.setStartTime("10:00");
        wrongSchedule.setEndTime("12:00");

        Programmer programmer5 = new Programmer();
        programmer5.setName("Programmer5");
        programmer5.addSkill("java");
        programmer5.setSchedule(wrongSchedule);
        Accounts.getInstance().addProgrammer(programmer5);

        project.setNumberOfProgrammers(10);

        assertTrue(project.getProgrammers().contains(programmer));
        assertTrue(project.getProgrammers().contains(programmer3));
        assertFalse(project.getProgrammers().contains(programmer2));
        assertTrue(project.getProgrammers().contains(programmer4));
        assertFalse(project.getProgrammers().contains(programmer5));
    }
}