package com.example.taskmanager.Controller;


import com.example.taskmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/Login")
    public String login(Model model){
        return "User/Login";
    }


    @GetMapping("/")
}
