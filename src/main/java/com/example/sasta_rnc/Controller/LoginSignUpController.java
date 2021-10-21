package com.example.sasta_rnc.Controller;

import com.example.sasta_rnc.Models.User;
import com.example.sasta_rnc.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginSignUpController {
    private UserService userService;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public LoginSignUpController(UserService userService, ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    // path variable to access parts of url
    @PostMapping("/register")//Request parameter for accessing the post request
    public String register(@ModelAttribute("user") User user, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){

        userService.save(user);
        return "homepage";
    }
    @RequestMapping("/error")
    public String errorPage(){
        return  "error";
    }
}
