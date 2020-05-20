package com.example.iitu.pizza.controller;

import com.example.iitu.pizza.entity.User;
import com.example.iitu.pizza.entity.UserRole;
import com.example.iitu.pizza.exception.NoRoleException;
import com.example.iitu.pizza.exception.UserNotFoundException;
import com.example.iitu.pizza.repository.RoleRepository;
import com.example.iitu.pizza.repository.UserRepository;
import com.example.iitu.pizza.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
@Api(value = "User Controller class", description = "This class allows to interact with User object")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/role/{role}")
    public List<User> getAllUserByRole(@PathVariable String role){
        return userRepository.findAllByUserRoleContains(role);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @PostMapping("")
    public String createUser(User user, Map<String, Object> model) throws NoRoleException{


        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserRole userRole = roleRepository.findById((long) 2).get();

        user.addUserRole(userRole);

        userService.createUser(user);

        return "redirect:/login";
    }

    //===========================================
    @GetMapping("/create")
    public String createUserByUsernamePassword() throws NoRoleException {
        return "registration";
    }
    //===========================================

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
