
package com.buForumCalender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/showMyLogin")
    public String showLogin() {
        return "login";
    }

}
