package yuni.kim.study.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import yuni.kim.study.StudyApplicationTests;
import yuni.kim.study.model.enitity.Partner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PartenrRepositoryTest extends StudyApplicationTests {

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = new Partner();

        partner.setName("partner01");
        partner.setStatus("registered");
        partner.setAddress("서울시 강남구");
        partner.setCallCenter("070-1234-5678");
        partner.setPartnerNumber("010-1234-5678");
        partner.setBusinessNumber("123456780123");
        partner.setCeoName("홍길동");
        partner.setRegisteredAt(LocalDateTime.now());
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("AdminServer");
        //partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);

        assertNotNull(newPartner);
    }

}