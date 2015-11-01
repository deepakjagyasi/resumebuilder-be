package com.rb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by l062950 on 22/10/2015.
 */
@Controller
public class ServiceController {

    @RequestMapping(value = {
           "/", "/version", "/public/version",
    }, method = RequestMethod.GET, produces = "text/plain") @ResponseBody
    public String showVersion()
    {
        System.out.print("I reached Service layer############################");
        return "1.0";
    }

}
