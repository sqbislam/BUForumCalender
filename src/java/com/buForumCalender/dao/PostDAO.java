/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.dao;

import com.buForumCalender.entity.Comments;
import com.buForumCalender.entity.Posts;
import java.util.List;

/**
 *
 * @author hpavilion-au171TX
 */

public interface PostDAO {

    public List<Posts> getAllPosts();
    public List<Posts> getPosts(String tag);
    public void savePost(Posts temp, String user);

    public void deletePost(int id);

    public void updatePost(Posts tempPost);

    public Posts getPostByID(int id);

    public void saveComment(Comments tempComment, int postID);

    public List<Posts> getGeneralPosts();

    public void deleteComment(int id);

    public void showMore();
}
