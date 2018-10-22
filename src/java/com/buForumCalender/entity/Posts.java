/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.entity;

import buForumCalender.utils.BuUtils;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author hpavilion-au171TX
 */
@Entity
@Table(name="posts")

public class Posts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column
    private String Content;
    
    @Column(insertable = false, updatable = false)
    private int Author_id;
    
    @Basic
    @Column(name="timestamp")
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    
   
    
    
    @ManyToOne(cascade={CascadeType.MERGE,
                                            CascadeType.REFRESH,
                                            CascadeType.PERSIST,
                                            CascadeType.DETACH})
    @JoinColumn(name="author_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public int getAuthor_id() {
        return Author_id;
    }

    public void setAuthor_id(int Author_id) {
        this.Author_id = Author_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void attachTime() {
       BuUtils utils = new BuUtils();
       Timestamp temp = utils.postWithTimestamp();
       
    }
    
    
    }

    
    

