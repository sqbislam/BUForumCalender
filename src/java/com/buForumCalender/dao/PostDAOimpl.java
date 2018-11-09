/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.dao;

import com.buForumCalender.entity.Posts;
import com.buForumCalender.entity.Student;
import java.util.List;
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
    StudentDAO studentDAO;

    @Autowired
    private SessionFactory sessionfactory;

    @Override
    @Transactional
    public void savePost(Posts tempPost) {

        //get current session
        //get username of current student and find Student object accordingly
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Student student = studentDAO.getStudentByUsername(currentPrincipalName);

        //atttach timestamp to post object
        tempPost.attachTime();
        
        //get current session
        Session currentSession = sessionfactory.getCurrentSession();
        student.addPost(tempPost);
        
        //save the post as an object
        currentSession.save(tempPost);

    }

    @Override
    @Transactional
    public List<Posts> getAllPosts() {

        //get current session
        Session current = sessionfactory.getCurrentSession();

        //create query
        Query<Posts> query = current.createQuery("from Posts p ORDER BY p.timestamp DESC", Posts.class);

        //get resutls
        List<Posts> posts = query.getResultList();

        return posts;
    }
    
    
    @Override
    @Transactional
    public List<Posts> getPosts(String tag) {
                //get current session
        Session current = sessionfactory.getCurrentSession();

        //create query
        Query<Posts> query = current.createQuery("from Posts p WHERE tag LIKE '%"+tag+"%' ORDER BY p.timestamp DESC", Posts.class);

        //get resutls
        List<Posts> posts = query.getResultList();

        return posts;
    }

    
}
