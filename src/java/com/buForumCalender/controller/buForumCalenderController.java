package com.buForumCalender.controller;

import com.buForumCalender.dao.StudentDAO;
import com.buForumCalender.entity.Posts;
import com.buForumCalender.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.buForumCalender.dao.PostDAO;
import java.util.logging.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Saqib Islam
 */
@Controller
public class buForumCalenderController {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private PostDAO postDAO;

    @RequestMapping("/")
    public String home(Model theModel, @RequestParam(value = "tag", required = false) String tag) {
        //Get current username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();



        //if tag not specified make it General
        List<Posts> postList;
        System.out.println("LOG: "+ tag);
        if (tag==null || tag.trim().equalsIgnoreCase("")) {
             postList= postDAO.getAllPosts();
        }
        else{
            postList= postDAO.getPosts(tag);
        }
        
        List<Student> list = studentDAO.getStudents();
        //Adding student list to page model
        theModel.addAttribute("students", list);
        //Adding new Post object to page model 
        theModel.addAttribute("posts", new Posts());
        //Adding all the posts list to page model
        theModel.addAttribute("allPosts", postList);
        //Adding username
        theModel.addAttribute("username", name);
        
        return "homepage";
    }

    @RequestMapping("/edit")
    public String editCalender() {
        return "calenderEdit";
    }

    @RequestMapping("/access-denied")
    public String accDenied() {
        return "access-denied";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("posts") Posts tempPost) {
        //checking if post is empty
        if (!"".equals(tempPost.getContent().trim())) {
            postDAO.savePost(tempPost);
        }

        return "redirect:/";

    }

}
