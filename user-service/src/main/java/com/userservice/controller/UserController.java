package com.userservice.controller;

import com.userservice.entity.Contact;
import com.userservice.entity.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        User user=  this.userService.getUser(userId);
        if(user!=null){
            List<Contact> contacts=new ArrayList<>();
            List Contact = this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
            if(Contact!=null){
                user.setContacts(Contact);
            }
            else{
                user.setContacts(contacts);
            }
        }
        return user;
    }




}
