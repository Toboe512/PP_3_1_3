package ru.toboe512.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.toboe512.models.User;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String index(@AuthenticationPrincipal User authenticationUser) {
        return "redirect:/user";
    }
}
