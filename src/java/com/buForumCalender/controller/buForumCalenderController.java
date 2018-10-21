/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.controller;

import com.buForumCalender.dao.StudentDAO;
import com.buForumCalender.entity.Posts;
import com.buForumCalender.entity.Student;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.buForumCalender.dao.PostDAO;

/**
 *
 * @author hpavilion-au171TX
 */

@Controller
public class buForumCalenderController {
     
    @Autowired
    private StudentDAO studentDAO;
    
     @Autowired
     private PostDAO postDAO;
     
    @RequestMapping("/")
    public String home(Model theModel){
    
    List<Student> list = studentDAO.getStudents();
    theModel.addAttribute("students", list);
    theModel.addAttribute("posts", new Posts());
    
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
    
    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("posts") Posts tempPost)
    {    
        
         postDAO.savePost(tempPost);
      
         return "redirect:/";

    }

    
}
