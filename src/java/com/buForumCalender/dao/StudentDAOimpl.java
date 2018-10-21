/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.dao;

import com.buForumCalender.entity.Student;
import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hpavilion-au171TX
 */

@Repository
public class StudentDAOimpl implements StudentDAO {

    //need to inject Session Factory
    
    @Autowired
    private SessionFactory sessionfactory;
        
    @Override
    @Transactional
    public List<Student> getStudents() {
       
       //get current session
       Session current = sessionfactory.getCurrentSession();
       
       //create query
       Query<Student> query = current.createQuery("from Student", Student.class);
       
       //get resutls
       List<Student> students = query.getResultList();
       
       return students;
       
    }
    
    
}
