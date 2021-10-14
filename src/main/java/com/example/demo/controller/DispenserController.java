package com.example.demo.controller;

import com.example.demo.model.UserObject;
import com.example.demo.service.DispenserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Data
public class DispenserController {
    @Autowired
    private DispenserService dispenserService;

    //Not used but gets the list of change based on entered inputs
    @GetMapping("/dispence")
    public List<UserObject> getDispence(@RequestParam("input") int input, @RequestParam("subtraction") int subtraction) throws Exception{
        return dispenserService.dispence(input, subtraction);
    }

    //Method used for calling the view with the displayed list of change results once the calculations is done
    //Mapped with the view page.
    @GetMapping("/view")
    public ModelAndView getDispenceView(@ModelAttribute String value, Model model) throws Exception{
        List dispence = dispenserService.dispence(67, 0);
        int defaultValue = 0;
        Map<String, Object> dispenceMap = new HashMap<>();
        dispenceMap.put("change", dispence);
        dispenceMap.put("value", defaultValue);
        //new ModelAndView("view", dispenceMap);
        return new ModelAndView("view", dispenceMap);
    }

    //This is called on the landing page (index) to enter your input for calculations
    //Mapped with the index page
    @RequestMapping("/")
    public ModelAndView index(Model model) {
        Map<String, Object> dispenceMap = new HashMap<>();
        dispenceMap.put("value", 0);
        model.addAttribute("value", "3");
        return new ModelAndView("index", dispenceMap);
    }

   @PostMapping("/userObject")
    private void saveUserObject(@RequestBody UserObject denom)
    {
      dispenserService.saveOrUpdate(denom);
    }
}
