package ru.toboe512.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.toboe512.models.User;
import ru.toboe512.service.RoleService;
import ru.toboe512.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getUsers(@AuthenticationPrincipal User authenticationUser,
                           @ModelAttribute("user_edit") User user,
                           Model model) {
        model.addAttribute("user", user);
        model.addAttribute("auth_user", authenticationUser);
        model.addAttribute("users", userService.listUsers());
        return "admin";
    }

    @PostMapping()
    public String create(@RequestParam(value = "roles_string", required = false) String[] roles,
                         @ModelAttribute("user_edit") User user) {
        userService.add(roleService.setRolesByStrings(roles, user));
        return "redirect:/admin";
    }

    @PatchMapping()
    public String edit(
            @RequestParam(value = "roles_string", required = false) String[] roles,
            @ModelAttribute("user_edit") User user) {
        userService.update(roleService.setRolesByStrings(roles, user));
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(userService.getUser(id));
        return "redirect:/admin";
    }
}
