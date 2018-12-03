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
import com.buForumCalender.entity.Comments;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    private Model theModel;
    
    private int count = 5;
    
    private String authority;
    
    @RequestMapping("/")
    public String home(){
    return "homepageMain";
    }

    @RequestMapping("/student")
    public String homeStudent(Model theModel, 
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "edit", required = false) String id) 
    
         {
        
        this.theModel = theModel;
        
        //Get current username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        authority = userDetails.getAuthorities().toString();
        

        //if tag not specified make it General
        List<Posts> postList;
        System.out.println("LOG: "+ tag);
        if (tag==null || tag.trim().equalsIgnoreCase("")) {
             postList= postDAO.getAllPosts();
        }
        else{
            postList= postDAO.getPosts(tag);
        }
        
        //add tag list
        Map< String, String > tags = getTags();
        
        List<Student> list = studentDAO.getStudents();
        
        //Adding student list to page model
        theModel.addAttribute("students", list);
        
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
        
        //add user authority
        theModel.addAttribute("auth", authority);
        
        if(id!=null){
        Posts temp = postDAO.getPostByID(Integer.valueOf(id));
        theModel.addAttribute("temp", temp);
        }
        
        return "homepage";
    }

    @RequestMapping("/teacher/edit")
    public String editCalender() {
        return "calenderEdit";
    }
    
    @GetMapping("/student/deletePost")
    public String deletePost(@RequestParam(value = "postID") int id){
        
        postDAO.deletePost(id);
        return "redirect:/student?showMore=true";
    }

    @RequestMapping("/access-denied")
    public String accDenied() {
        return "access-denied";
    }

    @PostMapping("/student/savePost")
    public String savePost(@ModelAttribute("posts") Posts tempPost) {
        //checking if post is empty
        if (!"".equals(tempPost.getContent().trim())) {
            postDAO.savePost(tempPost,authority);
        }

        return "redirect:/student";

    }
    
    //////////////////////////////////
    
    @PostMapping("/student/test")
    public String saveComment(@ModelAttribute("tempComment") Comments tempComment, @RequestParam(value = "postID") int id ) {
        
        
        //checking if post is empty
        if (!"".equals(tempComment.getContent().trim())) {
            postDAO.saveComment(tempComment, id);
        }

        return "redirect:/student";

    }
    
    /////////////////////////////////
    
    @PostMapping("/student/editPost")
      public String editPost(@ModelAttribute("temp") Posts tempPost) {
        //checking if post is empty
        if (!"".equals(tempPost.getContent().trim())) {
            postDAO.savePost(tempPost,authority);
        }

        return "redirect:/student";
        

    }
      
    @GetMapping("/student/deleteComment")
    public String deleteComment(@RequestParam(value="commentID") int id){
        
        postDAO.deleteComment(id);
        
        return "redirect:/student";
    }
    
    @RequestMapping("student/showMore")
    public String showMore(@RequestParam(value = "flag") String flag){
            
            if(flag.equalsIgnoreCase("true"))
                postDAO.showMore(flag);
            else
                postDAO.showMore(flag);
        
        
        return "redirect:/student#anchor";        
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
    
    

    @RequestMapping("/calendar")
    public String showCalender(){
        return "calendar";
    }
//    
//   @GetMapping(value = "/events",produces = MediaType.APPLICATION_JSON_VALUE)
//   @ResponseBody
//   public JSONObject data(@RequestBody String load) 
//        {
//            org.json.JSONObject obj = new org.json.JSONObject();
//            obj.put("Status", "Success");
//            obj.put("Details","DB updated");
//            return obj;
//         }
}
