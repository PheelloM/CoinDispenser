package com.example.demo.service;

import com.example.demo.Denominations;
import com.example.demo.model.UserObject;
import com.example.demo.repository.dispenserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispenserService {
    @Autowired
    dispenserRepository dispenserRepo;

    //Dispence calculations and called in the controller
    public List dispence(int y, int subtraction) throws Exception {
        //Throw an exception if the input is less than 0
        if(y < 0)
            throw new Exception("Cannot give for value less than 0");
        //Subtract the input and return the change list
        y = y - subtraction;
        List<UserObject> denominators = returnedList(y);
        for(UserObject denom : denominators){
            saveOrUpdate(denom);
        }
        return denominators;
    }

    public void saveOrUpdate(UserObject denom)
    {
        System.out.println("Saving UserObject");

        UserObject userObject = dispenserRepo.save(denom);

        System.out.println("Saved ID : " + userObject.getId());
    }

    //Returned gets called from dispence for calculations
    private List returnedList(int y){
        List<UserObject> objList = new ArrayList<>();

        //We loop through the list
        //In the for loop we introduced x and divide y checking against denos.
        for(Denominations denos: Denominations.values()){
            //We introduce a variable and divide based on the denominations
            int x = (y / denos.getDenominations());
            //If greater than 0 we can add to the list
            if(x > 0){
                UserObject userObject = new UserObject();
                userObject.setNumber(x);
                userObject.setType(denos.name());
                userObject.setDescription(denos.getDescription());
                objList.add(userObject);
                y = y % denos.getDenominations();

            }
        }
        return objList;
    }
}
