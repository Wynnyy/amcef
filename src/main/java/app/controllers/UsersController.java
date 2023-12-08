package app.controllers;

import app.entity.Users;
import app.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UsersController {

    private UserServiceImpl userService;
    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/posts/{userId}")
    public Object getUserByID(@PathVariable("userId") int id) {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Users users = restTemplate.getForObject(uri, Users.class);
        log.info("Result getUserByID : {} ", users);
        return users;
    }

    @GetMapping("/posts/group/{userGroupId}")
    public Object getUserGroupByID(@PathVariable("userGroupId") int id) {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + id + "/comments" ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(uri, Object[].class);
        Object[] objects = responseEntity.getBody();
        log.info("Result getUserGroupByID : {} ", objects);
        return objects;
    }












}
