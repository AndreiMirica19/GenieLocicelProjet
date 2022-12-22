import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {


    @Test
    void setName() {
        Company company = new Company();
        company.setName("Company");
        company.setName("Company");
        company.setName("DDD");
        assertEquals("DDD", company.getName());
    }


    @Test
    void setCountry() {
        Company company = new Company();
        company.setName("Company");
        company.setCountry("Country");
        company.setCountry("DDD");
        assertEquals("DDD", company.getCountry());
    }

    @Test
    void setCity() {
        Company company = new Company();
        company.setName("Company");
        company.setCity("City");
        company.setCity("DDD");
        assertEquals("DDD", company.getCity());
    }


    @Test
    void setPassword() {
        Company company = new Company();
        company.setName("Company");
        company.setPassword("Password");
        company.setPassword("DDD");
        assertEquals("DDD", company.getPassword());
    }

    @Test
    void addProject() {
        Company company = new Company();
        company.setName("Company");
        Project project = new Project();
        project.setName("Project");
        company.addProject(project);
        assertTrue(company.projectExist("Project"));
    }

    @Test
    void deleteProject() {
        Company company = new Company();
        company.setName("Company");
        Project project = new Project();
        project.setName("Project");
        company.addProject(project);
        company.deleteProject("Project");
        assertFalse(company.projectExist("Project"));
    }

    @Test
    void projectExist() {
        Company company = new Company();
        company.setName("Company");
        Project project = new Project();
        project.setName("Project");
        company.addProject(project);
        assertTrue(company.projectExist("Project"));
    }

    @Test
    void getProject() {
        Company company = new Company();
        company.setName("Company");
        Project project = new Project();
        project.setName("Project");
        company.addProject(project);
        assertEquals("Project", company.getProject("Project").getName());
    }

}