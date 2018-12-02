/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.controller;

import com.buForumCalender.dao.PostDAO;
import com.buForumCalender.dao.StudentDAO;
import com.buForumCalender.entity.Comments;
import com.buForumCalender.entity.Posts;
import com.buForumCalender.entity.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hpavilion-au171TX
 */

@Controller
public class FacultyController {
   

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private PostDAO postDAO;
    
    private Model theModel;
    
    private int count = 5;
    
    String authority;
    String name;
    
    @RequestMapping("/teacher")
    public String homeTeacher(Model theModel, 
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "edit", required = false) String id,
            @RequestParam(value = "showMore", required = false) String showMore) {
        
        this.theModel = theModel;
        
        //Get current username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        name = auth.getName();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        authority = "[ROLE_TEACHER]";
        
        //if tag not specified make it General
        List<Posts> postList;
        System.out.println("LOG: "+ tag);
        if (tag==null || tag.trim().equalsIgnoreCase("")) {
             postList= postDAO.getGeneralPosts();
        }
        else{
            postList= postDAO.getPosts(tag);
        }
        
        //add tag list
        Map< String, String > tags = getTags();
        
        //Adding new Post object to page model 
        theModel.addAttribute("posts", new Posts());
        
        //Adding new Comments object to page model 
        theModel.addAttribute("tempComment", new Comments());
        
        //Adding all the posts list to page model
        theModel.addAttribute("allPosts", postList);
        
        //Adding username
        theModel.addAttribute("username", name);
        
        //Add tags
        theModel.addAttribute("taglist", tags);
        
        theModel.addAttribute("auth", authority);
        
        if(showMore != null){
        count = count + 5;
        }else{
        count = 5;}
        //Add count
        theModel.addAttribute("count", count);
        
        if(id!=null){
        Posts temp = postDAO.getPostByID(Integer.valueOf(id));
        theModel.addAttribute("temp", temp);
        }
        
        return "homepage_faculty";
    }
    
    
    @PostMapping("/teacher/savePost")
    public String savePost(@ModelAttribute("posts") Posts tempPost) {
        //checking if post is empty
        if (!"".equals(tempPost.getContent().trim())) {
            postDAO.savePost(tempPost,authority);
        }

        return "redirect:/teacher";

    }
    
     @GetMapping("/teacher/deletePost")
    public String deletePost(@RequestParam(value = "postID") int id){
        Posts post = postDAO.getPostByID(id);
        
        String tempn = post.getStudent().getUsername();
        
        if(name.equalsIgnoreCase(tempn)){
        postDAO.deletePost(id);
        }
        
        
        return "redirect:/teacher?showMore=true";
    }
          
    
   @PostMapping("/teacher/test")
    public String saveComment(@ModelAttribute("tempComment") Comments tempComment, @RequestParam(value = "postID") int id ) {
        
        
        //checking if post is empty
        if (!"".equals(tempComment.getContent().trim())) {
            postDAO.saveComment(tempComment, id);
        }

        return "redirect:/teacher";

    }
    
    @GetMapping("/teacher/deleteComment")
    public String deleteComment(@RequestParam(value="commentID") int id){
        
        postDAO.deleteComment(id);
        
        return "redirect:/teacher";
    }
    
    @RequestMapping("teacher/showMore")
    public String showMore(@RequestParam(value = "flag") String flag){
        
            if(flag.equalsIgnoreCase("true"))
                postDAO.showMore(flag);
            else
                postDAO.showMore(flag);

        
        return "redirect:/teacher";        
    }
      
    private Map<String, String> getTags() {
       Map< String, String > tags = new HashMap<String, String>();
        tags.put("cse320", "Cse320");
        tags.put("cse310", "Cse310");
        tags.put("cse230", "Cse230");
        tags.put("cse110", "Cse110");
        tags.put("cse111", "Cse111");
        tags.put("cse260", "Cse260");
        tags.put("cse422", "Cse422");
        tags.put("cse250", "Cse250");
        tags.put("cse251", "Cse251");
        return tags;
    }
    
}
