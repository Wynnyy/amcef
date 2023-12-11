package app.controllers;

import app.entity.Users;
import app.repositories.UserRepository;
import app.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class UsersController {

    private final UserServiceImpl userService;
    private final UserRepository userRepository;
    @Autowired
    public UsersController(UserServiceImpl userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @GetMapping("/posts/{userId}")
    public Object getUserByID(@PathVariable("userId") int id) {
        Optional <Users> usersList =  userService.getUserById(id);
        if(usersList.isEmpty()){
            userService.saveUser(userService.getExternalUserByID(id));
            return userService.getExternalUserByID(id);
        }
        log.info("\nResult getUserByID from Internal Database : \n{} ", usersList);
        return usersList;
    }

    @CrossOrigin
    @GetMapping("/posts/group/{userGroupId}")
    public Object getUserGroupByID(@PathVariable("userGroupId") int id) {
        List<Users> usersList =  userService.getGroupUsersById(id);
        if(!usersList.isEmpty()){
           log.info("\nResult getUserGroupByID from Internal Database : \n{} ", usersList);
           return usersList;
        }
        return userService.getExternalUserGroupByID(id);
    }

    @CrossOrigin
    @PostMapping("/saveUser")
    public HttpStatus saveUser(@Valid @RequestBody Users users){
        if(userService.getExternalUserGroupByID(users.getUserId()) == HttpStatus.NOT_FOUND){
            return HttpStatus.BAD_REQUEST;
        }
        log.info("User is saved with data : {} ", users);
        return  userService.saveUser(users);
    }

    @CrossOrigin
    @DeleteMapping("/removeUser/{userId}")
    public HttpStatus removeUser(@PathVariable("userId") int id){
        return userService.removeUserById(id);
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public HttpStatus updateUser(@RequestBody Users newUser,@PathVariable int id) throws Exception {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User doesn't exist with id : " + id));

        user.setUserId(user.getUserId()); //id can't be changes by update button
        user.setTitle(newUser.getTitle());
        user.setBody(newUser.getBody());
        userRepository.save(user);

        return HttpStatus.OK;
    }
















}
