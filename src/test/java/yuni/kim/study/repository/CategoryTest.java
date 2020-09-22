package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.Category;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class CategoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = new Category();

        category.setType("COMPUTER");
        category.setTitle("컴퓨터");
        category.setCreatedAt(LocalDateTime.now());
        category.setCreatedBy("AdminServer");

        Category newCategory = categoryRepository.save(category);

        assertNotNull(newCategory);

        assertEquals(newCategory.getTitle(), category.getTitle());
        assertEquals(newCategory.getType(), category.getType());
    }

    @Test
    public void read(){
        String type = "COMPUTER";

        //Optional<Category> category = categoryRepository.findById(1L);
        Optional<Category> category = categoryRepository.findByType(type);

        category.ifPresent(c -> {
            assertEquals(c.getType(), type);
        });

    }

}