package com.weddingplanner.server;

import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.services.crudoperations.AdvertisementRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AdvertisementServicesTest {

    Advertisement advertisement;
    List<Advertisement> advertisements;

    @Autowired
    AdvertisementRepo advertisementRepo;

    @Autowired
    TestEntityManager entityManager;

    @Before
    public void before() throws Exception {
        advertisement = new Advertisement(UUID.randomUUID().toString(), "test", "test", "imageUrl",
                "test@gmail.com", new Date(), "cake", 45.0, 1, Float.parseFloat("10"));
        advertisements = new ArrayList<>();
        advertisements.add(advertisement);
        advertisements.add(new Advertisement(UUID.randomUUID().toString(), "test", "test", "imageUrl",
                "test@gmail.com", new Date(), "cake", 45.0, 1, Float.parseFloat("10")));
    }


    @Test
    public void testAdd() throws Exception {
        advertisementRepo.save(advertisement);
        Assert.assertEquals(true, advertisementRepo.existsById(advertisement.getAdvertisementId()));
    }


    @Test
    public void testRemoveById() throws Exception {
        entityManager.persist(advertisement);
        entityManager.flush();
        advertisementRepo.deleteById(advertisement.getAdvertisementId());
        Assert.assertEquals(false, advertisementRepo.existsById(advertisement.getAdvertisementId()));
    }


    @Test
    public void testRetrieveById() throws Exception {
        entityManager.persist(advertisement);
        entityManager.flush();
        Advertisement found = advertisementRepo.findById(advertisement.getAdvertisementId()).get();
        assertThat(found.equals(advertisement));
    }


    @Test
    public void testSearchAdvertisementsByUser() throws Exception {
        entityManager.persist(advertisement);
        entityManager.persist(advertisements.get(1));
        entityManager.flush();
        Assert.assertEquals(2,advertisementRepo.findByBusinessOwner("test@gmail.com").size());
     }


    @Test
    public void testListAdvertisements() throws Exception {
        entityManager.persist(advertisement);
        entityManager.persist(advertisements.get(1));
        entityManager.flush();
        List<Advertisement> result = new ArrayList<Advertisement>();
        Iterable iterable = advertisementRepo.findAll();
        for (Object str : iterable) {
            result.add((Advertisement) str);
        }
        Assert.assertEquals(2,result.size());

    }

} 
