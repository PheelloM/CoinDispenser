package com.example.demo.repository;

import com.example.demo.model.UserObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class dispenserRepositoryTest {

    private final int UUID_LENGTH = 32;
    @Autowired
    private dispenserRepository repository;

    @Autowired
    private UserObject newUserObject;

    @Test
    public void testSaveNewProduct() {

        newUserObject.setNumber(10);
        newUserObject.setDescription("Number description");
        newUserObject.setType("Double");

        UserObject savedUserObject = repository.save(newUserObject);
        System.out.println("savedUserObject ID: " + savedUserObject.getId());
        System.out.println("ID Length: " + savedUserObject.getId().length());

        //Assertions
        Assertions.assertNotNull(savedUserObject);
        Assertions.assertEquals(UUID_LENGTH, savedUserObject.getId().length());

    }
}