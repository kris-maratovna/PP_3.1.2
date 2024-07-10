package ru.semennikova.PP_312.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import ru.semennikova.PP_312.model.User;
import ru.semennikova.PP_312.service.UserService;

import java.util.Optional;


@Controller
@RequestMapping("/")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAll (Model model) {
        model.addAttribute("users", userService.showAll());
        return "index";
    }

    @GetMapping("/addUser")
    public String addUser (Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping()
    public String create (@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        Optional<User> userById = userService.findById(id);
        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "editUser";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        userService.edit(user);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
