/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.dao;

import com.buForumCalender.entity.Student;
import java.util.List;

/**
 *
 * @author hpavilion-au171TX
 */


public interface StudentDAO {
    
    //method for getting all the students 
    public List<Student> getStudents();

    //method for getting student obj by username
    public Student getStudentByUsername(String name);
    
    
    
    
    
    
}
