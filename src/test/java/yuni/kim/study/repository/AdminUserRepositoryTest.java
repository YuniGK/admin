package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.AdminUser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AdminUserRepositoryTest extends StudyApplicationTests {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create(){

        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("adminUser02");
        adminUser.setPassword("adminUser02");
        adminUser.setStatus("registered");
        adminUser.setRole("partner");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        assertNotNull(newAdminUser);

    }

}