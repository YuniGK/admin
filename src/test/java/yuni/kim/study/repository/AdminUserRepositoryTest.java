package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.AdminUser;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class AdminUserRepositoryTest extends StudyApplicationTests {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create(){

        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("adminUser01");
        adminUser.setPassword("adminUser01");
        adminUser.setStatus("registered");
        adminUser.setRole("partner");
        adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("AdminServer");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        assertNotNull(newAdminUser);

    }

}