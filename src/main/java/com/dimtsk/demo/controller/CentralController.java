
package com.dimtsk.demo.controller;

import com.dimtsk.demo.models.User;
import com.dimtsk.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class CentralController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public String hello(){
        return "Welcome ADMIN";
    }
    
    @GetMapping("/list")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
}
