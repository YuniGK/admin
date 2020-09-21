package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.Item;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();

        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성");

        Item newItem = itemRepository.save(item);

        //내용이 추가되었다면, notNull이다.
        assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        assertTrue(item.isPresent());
    }

}