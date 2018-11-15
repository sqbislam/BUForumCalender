/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.entity;

import com.buForumCalender.utils.BuUtils;
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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    
    @Column(name="content")
    private String Content;
    
  
    
    @Basic
    @Column(name="timestamp")
    private Timestamp timestamp;

    @Column(name="tag")
    private String tag;
    
    
    @ManyToOne(cascade={CascadeType.MERGE,
                                            CascadeType.REFRESH,
                                            CascadeType.PERSIST,
                                            CascadeType.DETACH})
    @JoinColumn(name="author_id")
    private Student student;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="posts", fetch=FetchType.EAGER)
    private List<Comments> comments;

    public Posts(String Content, String  tag, Student student) {
        this.Content = Content;
        this.tag = tag;
        this.student = student;
    }

    public Posts() {
    }

    
    
    
    
    
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
 
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
    
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void addComment(Comments temp){
    if(comments == null){
        comments = new ArrayList<>();
    }
    comments.add(temp);
    
    temp.setPosts(this);
    }
    
    
    @Override
    public String toString() {
        return id+" "+Content;
    }
    
    
    }

    
    

