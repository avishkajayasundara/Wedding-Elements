package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
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
    @GetMapping("/error")
    public ModelAndView handleError(ModelMap model){
        ModelAndView modelAndView = new ModelAndView();
        try{
           if(model.equals(null)){
               modelAndView.addObject("code",500);
               modelAndView.addObject("message","Something Went Wrong");
           }else{
               String errorType = (String)model.getAttribute("errorType");
               if(errorType.equals("ClientException")){
                   ClientException exception = (ClientException) model.getAttribute("error");
                   modelAndView.addObject("code",exception.getCode());
                   modelAndView.addObject("message",exception.getMessage());
               }else{
                   ServerException exception = (ServerException) model.getAttribute("error");
                   modelAndView.addObject("code",exception.getCode());
                   modelAndView.addObject("message",exception.getMessage());
               }
           }
           modelAndView.setViewName("error.jsp");
       }catch (Exception e){
           modelAndView.addObject("code",500);
           modelAndView.addObject("message","Something Went Wrong");
            return modelAndView;
        }
        return modelAndView;
    }
}
