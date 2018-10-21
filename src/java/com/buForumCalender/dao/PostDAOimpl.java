/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.dao;

import com.buForumCalender.entity.Posts;
import com.buForumCalender.entity.Student;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hpavilion-au171TX
 */

@Repository
public class PostDAOimpl implements PostDAO {
    
    @Autowired
    private SessionFactory sessionfactory;
        
    @Override
    @Transactional
    public void savePost(Posts temp) {
         //get current session
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         String currentPrincipalName = authentication.getName();
//         Student student = studentDAO.getStudentByUsername(currentPrincipalName);
        
       Session current = sessionfactory.getCurrentSession();
       Student student = current.get(Student.class, 1);
       student.addPost(temp);
       current.save(temp);
    }
    
}
