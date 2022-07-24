package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.User;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userHomePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user_panel";
    }
}
