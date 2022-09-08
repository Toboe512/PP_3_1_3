package ru.toboe512.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.toboe512.models.User;
import ru.toboe512.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(@AuthenticationPrincipal User authenticationUser, Model model) {
        model.addAttribute("auth_user", authenticationUser);
        model.addAttribute("users", userService.listUsers());
        return "user";
    }
}
