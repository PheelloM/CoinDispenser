package com.example.demo.service;

import com.example.demo.model.UserObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DispenserServiceTest {

    @Autowired
    private DispenserService dispenserService;

    @Test
    void dispence() {
        int number1, number2, number3;
        int counter=0;
        try {
            List<UserObject> userObjects = dispenserService.dispence(67, 0);
            for(UserObject userObject : userObjects){
                System.out.println(userObject.getNumber());
                switch(counter){
                    case 0:
                        Assertions.assertEquals(6,userObject.getNumber());
                        break;
                    case 1:
                        Assertions.assertEquals(1,userObject.getNumber());
                        break;
                    case 2:
                        Assertions.assertEquals(1,userObject.getNumber());

                }
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}