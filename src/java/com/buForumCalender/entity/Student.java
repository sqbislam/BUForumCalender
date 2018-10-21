/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column
    private String name;
    
    @Column(name="username", insertable = false, updatable = false)
    private String username;
    
    @OneToOne
    @JoinColumn(name="username")
    private Users users;
    
    @OneToMany(mappedBy="student")
    private List<Posts> posts;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }


    public Users getUsers() {
        return users;
    }
    public void addPost(Posts temppost){
        if(posts==null){
            posts= new ArrayList<>();
        }
        posts.add(temppost);
        temppost.setStudent(this);
    }
    
}
