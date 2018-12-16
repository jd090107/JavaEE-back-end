package com.tongji.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/")
public class CookieController {
    @RequestMapping(value = "/setCookies", method = RequestMethod.GET)
    public boolean SetCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("userAccount", "account");
        response.addCookie(cookie);
        return true;
    }

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public  String getCookies(HttpServletRequest request) {
        Cookie[] cookies =  request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("userAccount")) {
                    return cookie.getValue();
                }
            }
        }
        return  null;
    }
}