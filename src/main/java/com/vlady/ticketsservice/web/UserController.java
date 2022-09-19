package com.vlady.ticketsservice.web;

import com.vlady.ticketsservice.models.User;
import com.vlady.ticketsservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showUsers(){
        return userService.showUsers();
    }

    @GetMapping("/users{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/user{id}")
    public User updateUser(@PathVariable int id){
        return userService.updateUser(id);

    }

    @PatchMapping("/user{id}")
    public User markDeleteUser(@PathVariable int id){
        return markDeleteUser(id);

    }

}
