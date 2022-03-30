/*
package pte.mik.habitstatsserver.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.dto.UserDto;
import pte.mik.habitstatsserver.entity.User;
import pte.mik.habitstatsserver.service.UserService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listAllUser(){
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @PutMapping
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestBody Integer id){
        userService.deleteUser(id);
    }
}
*/
