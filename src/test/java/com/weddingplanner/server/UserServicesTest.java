package com.weddingplanner.server;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Customer;
import com.weddingplanner.server.services.UserService;
import com.weddingplanner.server.services.crudoperations.BusinessOwnerRepo;
import com.weddingplanner.server.services.crudoperations.CustomerRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServicesTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BusinessOwnerRepo businessOwnerRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void testAddBusinessOwner(){
        BusinessOwner businessOwner = new BusinessOwner("test@gmail.com","aaaaaa","TestAddress",
                "ACIVE","0771234567","BUSINESS_OWNER","test","test","test","Sri Lanka");
        entityManager.persist(businessOwner);
        entityManager.flush();
        Assert.assertEquals(true,businessOwnerRepo.existsById("test@gmail.com"));
    }

    @Test
    public void testListBusinessOwners(){
        entityManager.persist(new BusinessOwner("test@gmail.com","aaaaaa","TestAddress",
                "ACIVE","0771234567","BUSINESS_OWNER","test","test","test","Sri Lanka"));
        entityManager.persist(new BusinessOwner("test2@gmail.com","bbbbbb","Test2Address",
                "ACIVE","0771234567","BUSINESS_OWNER","test2","test2","test2","Sri Lanka"));
        entityManager.flush();
        List<BusinessOwner> result = new ArrayList<BusinessOwner>();
        Iterable iterable = businessOwnerRepo.findAll();
        for (Object str : iterable) {
            result.add((BusinessOwner) str);
        }
        Assert.assertEquals(2,result.size());
    }

    @Test
    public void testGetBusinessOwner(){
        BusinessOwner businessOwner = new BusinessOwner("test@gmail.com","aaaaaa","TestAddress",
                "ACIVE","0771234567","BUSINESS_OWNER","test","test","test","Sri Lanka");
        entityManager.persist(businessOwner);
        entityManager.flush();
        BusinessOwner found = businessOwnerRepo.findById("test@gmail.com").get();
        assertThat(found.equals(businessOwner));

    }
    @Test
    public void testRemoveBusinessOwner(){
        BusinessOwner businessOwner = new BusinessOwner("test@gmail.com","aaaaaa","TestAddress",
                "ACIVE","0771234567","BUSINESS_OWNER","test","test","test","Sri Lanka");
        entityManager.persist(businessOwner);
        entityManager.flush();
        businessOwnerRepo.deleteById("test@gmail.com");
        Assert.assertEquals(false,businessOwnerRepo.existsById("test@gmail.com"));
    }

    @Test
    public void testUpdateBusinessProfile() {
        BusinessOwner businessOwner = new BusinessOwner("test@gmail.com","aaaaaa","TestAddress",
                "ACIVE","0771234567","BUSINESS_OWNER","test","test","test","Sri Lanka");
        entityManager.persist(businessOwner);
        entityManager.flush();
        businessOwnerRepo.updateProfileDetails("changedName","changedAddress","077777777777","testChanged","test@gmail.com");
        businessOwner = businessOwnerRepo.findById("test@gmail.com").get();
        Assert.assertEquals("changedName",businessOwner.getName());
        Assert.assertEquals("changedAddress",businessOwner.getAddress());
        Assert.assertEquals("077777777777",businessOwner.getContactNo());
        Assert.assertEquals("testChanged",businessOwner.getDescription());

    }
    @Test(expected = Exception.class)
    public void testGetBusinessOwnerWithBlankId(){
        Assert.assertEquals("test",businessOwnerRepo.findById("").get().getName());
    }
    @Test
    public void testAddCustomer(){
        Customer customer = new Customer("test@gmail.com","aaaaaa","testAddress","0777777777","CUSTOMER"
        ,"ACTIVE","test","test","12/03/1997","Male");
        customerRepo.save(customer);
        Assert.assertEquals(true,customerRepo.existsById("test@gmail.com"));
    }
    @Test
    public void testRemoveCustomer(){
        Customer customer = new Customer("test@gmail.com","aaaaaa","testAddress","0777777777","CUSTOMER"
                ,"ACTIVE","test","test","12/03/1997","Male");
        entityManager.persist(customer);
        entityManager.flush();
        customerRepo.deleteById("test@gmail.com");
        Assert.assertEquals(false,customerRepo.existsById("test@gmail.com"));
    }
    @Test
    public void testListCustomers(){
        entityManager.persist(new Customer("test@gmail.com","aaaaaa","testAddress","0777777777","CUSTOMER"
                ,"ACTIVE","test","test","12/03/1997","Male"));
        entityManager.persist(new Customer("test2@gmail.com","aaaaaa","testAddress","0777777777","CUSTOMER"
                ,"ACTIVE","test","test","12/03/1997","Male"));
        List<Customer> result = new ArrayList<Customer>();
        Iterable iterable = customerRepo.findAll();
        for (Object str : iterable) {
            result.add((Customer) str);
        }
        Assert.assertEquals(2,result.size());
    }
    @Test
    public void testGetCustomer(){
        Customer customer = new Customer("test@gmail.com","aaaaaa","testAddress","0777777777","CUSTOMER"
                ,"ACTIVE","test","test","12/03/1997","Male");
        entityManager.persist(customer);
        entityManager.flush();
        Customer foundCustomer = customerRepo.findById("test@gmail.com").get();
        assertThat(foundCustomer.equals(customer));
    }
    @Test(expected = NoSuchElementException.class)
    public void findNonExistantUser(){
        Assert.assertEquals("test@test.com",customerRepo.findById("test@test.com").get().getEmail());
    }


}
