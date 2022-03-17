package pte.mik.habitstatsserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pte.mik.habitstatsserver.dto.UserDto;
import pte.mik.habitstatsserver.entity.User;
import pte.mik.habitstatsserver.service.UserService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> listAllUser(){
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @PutMapping
    public void createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody UserDto userDto){
        userService.deleteUser(userDto);
    }
}
