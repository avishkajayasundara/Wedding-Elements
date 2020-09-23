package com.weddingplanner.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value="/loginx", method= RequestMethod.GET)
    public String getLogin(){
        return "login.jsp";
    }
}
