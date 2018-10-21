/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.controller;

import com.buForumCalender.dao.StudentDAO;
import com.buForumCalender.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hpavilion-au171TX
 */

@Controller
public class StudentController {
   
    @Autowired
    private StudentDAO studentDAO;
    
    @RequestMapping("/listStudents")
    public String listStudents(Model theModel){
    List<Student> list = studentDAO.getStudents();
    
    theModel.addAttribute("students", list);
    
    
    return "list";
    }
    
}
