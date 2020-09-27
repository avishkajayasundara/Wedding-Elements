package com.weddingplanner.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.jsp");
        return mv;
    }
//    @GetMapping
//    public ModelAndView handleError(ModelMap model){
//
//    }
}
