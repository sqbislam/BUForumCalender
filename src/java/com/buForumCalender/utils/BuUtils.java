/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buForumCalender.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author hpavilion-au171TX
 */

public class BuUtils {
    
    
    public Timestamp postWithTimestamp(){
    
    Date date= new Date();
 
    long time = date.getTime();
     
    Timestamp ts = new Timestamp(time);
    
    return ts;
    }
}
