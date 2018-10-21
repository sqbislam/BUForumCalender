/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hpavilion-au171TX
 */

@Controller
public class buForumCalenderController {
    
    @RequestMapping("/")
    public String home(){
        return "homepage";
    }
    
    @RequestMapping("/edit")
    public String editCalender(){
        return "calenderEdit";
    }
    
    @RequestMapping("/access-denied")
    public String accDenied(){
        return "access-denied";
    }
    
}
