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
        currentSession.saveOrUpdate(tempPost);

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
    
    
    @Override
    @Transactional
    public void deletePost(int id) {
              //get current session
        Session current = sessionfactory.getCurrentSession();
        
        Query query = current.createSQLQuery("delete from Posts where id=:postID");
        query.setParameter("postID", id);
        query.executeUpdate();
        
    }

    @Override
    @Transactional
    public void updatePost(Posts tempPost) {
         
        tempPost.attachTime();
        
           //get current session
        Session current = sessionfactory.getCurrentSession();
        //save the post as an object
        current.saveOrUpdate(tempPost);

    }

    @Override
    @Transactional
    public Posts getPostByID(int id) {
        Session current = sessionfactory.getCurrentSession();
        
        Query<Posts> query = current.createQuery("from Posts where id="+id);
        
        Posts temp = query.getSingleResult();
        return temp;
    }

    
}
