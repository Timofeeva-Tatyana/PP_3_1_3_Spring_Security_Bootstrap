package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.User;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.service.RoleService;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.service.UserService;


@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String userHomePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user_panel";
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        User thisUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("newUser", new User());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("thisUser", thisUser);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin_panel";
    }

    @PostMapping("/admin/create")
    public String createUser(@ModelAttribute("newUser") User user,
                             @RequestParam(value = "rolesId", required = false) Long[] rolesId) {
        if (rolesId == null) {
            user.addRole(roleService.findRoleByName("USER"));
        } else {
            for (Long roleId : rolesId) {
               user.addRole(roleService.findRoleById(roleId));
            }
        }
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update")
    public String updateUser(@ModelAttribute("newUser") User user,
                             @RequestParam(value = "rolesId", required = false) Long[] rolesId) {
        if (rolesId == null) {
            user.addRole(roleService.findRoleByName("USER"));
        } else {
            for (Long roleId : rolesId) {
                user.addRole(roleService.findRoleById(roleId));
            }
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
