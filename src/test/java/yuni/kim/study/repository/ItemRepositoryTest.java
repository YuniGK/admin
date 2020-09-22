package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.Item;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();

        item.setStatus("unregistered");
        item.setName("노트북");
        item.setTitle("노트북 a100");
        item.setContent("2019년형 노트북");
        item.setPrice(100000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("partner01");
        item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);

        //내용이 추가되었다면, notNull이다.
        assertNotNull(newItem);
    }

}