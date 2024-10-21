package com.organization.mvcproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   
	@RequestMapping(value="/hello")
    public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
        ModelAndView ret = new ModelAndView("home");
        // Adds an object to be used in home.jsp
        ret.addObject("name", testingMethod());
        
        //logs to console 
        practiceLoop();
        
        return ret;
    }
   
	
	private String testingMethod() {
        return "testing Method";
    }
    private String practiceLoop() {
        String testString = "";
        for(int i=0; i<=10; i++) {
            System.out.println("i: "+i);
            testString += i;
            System.out.println("testString: " + testString);
        }
        return testString;
    }
}