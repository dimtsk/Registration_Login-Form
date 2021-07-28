
package com.dimtsk.demo.controller;

import com.dimtsk.demo.models.User;
import com.dimtsk.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/app")
public class UserController {
    
    public static final String DEFAULT_ROLE= "ROLE_USER";
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @GetMapping
    public String mainPage(){
        return "index";
    }
    
    @GetMapping("/register")
    public String registerForm(ModelMap mm){
        mm.addAttribute("user", new User());
        return "registerform";
    }
    
    @PostMapping("/process/register")
    public String registrationNewUser(User user){
        user.setRole(DEFAULT_ROLE);
        String encryptPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptPassword);
        userRepository.save(user);
        
        return "index";
    }
    
    @GetMapping("/list")
    public String listOfAllUsers(ModelMap mm){
        List<User> userList= userRepository.findAll();
        mm.addAttribute("list", userList);
        return "listtable";
    }
    
}
