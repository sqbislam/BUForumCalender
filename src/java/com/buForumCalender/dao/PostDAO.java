/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.dao;

import com.buForumCalender.entity.Posts;
import java.util.List;

/**
 *
 * @author hpavilion-au171TX
 */

public interface PostDAO {

    public List<Posts> getAllPosts();
    public void savePost(Posts temp);
}
