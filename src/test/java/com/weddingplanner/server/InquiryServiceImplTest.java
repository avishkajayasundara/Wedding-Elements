package com.weddingplanner.server;

import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Inquiry;
import com.weddingplanner.server.services.crudoperations.InquiryRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * InquiryServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 29, 2020</pre>
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class InquiryServiceImplTest {

    @Autowired
    InquiryRepo inquiryRepo;

    @Autowired
    TestEntityManager entityManager;

    Inquiry inquiry;
    List<Inquiry> inquiryList;

    @Before
    public void before() throws Exception {
        inquiryList = new ArrayList<>();
        inquiry = new Inquiry(UUID.randomUUID().toString(), "test", "test@gmail.com", "0770323035", "test"
                , "test");
        inquiryList.add(inquiry);
        inquiryList.add(new Inquiry(UUID.randomUUID().toString(), "test", "test@gmail.com", "0770323035", "test"
                , "test"));

    }


    @Test
    public void testAddInquiry() throws Exception {
        inquiryRepo.save(inquiry);
        Assert.assertEquals(true, inquiryRepo.existsById(inquiry.getInquiryId()));
    }


    @Test
    public void testGetInquiry() throws Exception {
        entityManager.persist(inquiry);
        entityManager.flush();
        Inquiry found = inquiryRepo.findById(inquiry.getInquiryId()).get();
        assertThat(found.equals(inquiry));
    }


    @Test
    public void testListInquiries() throws Exception {
        entityManager.persist(inquiry);
        entityManager.persist(inquiryList.get(1));
        List<Inquiry> result = new ArrayList<Inquiry>();
        Iterable iterable = inquiryRepo.findAll();
        for (Object str : iterable) {
            result.add((Inquiry) str);
        }
        Assert.assertEquals(2,result.size());
    }


    @Test
    public void testRemoveInquiry() throws Exception {
        entityManager.persist(inquiry);
        entityManager.flush();
        inquiryRepo.deleteById(inquiry.getInquiryId());
        Assert.assertEquals(false, inquiryRepo.existsById(inquiry.getInquiryId()));

    }


} 
