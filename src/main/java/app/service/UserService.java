package app.service;

import app.entity.Users;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List <Users> getGroupUsersById(int id);

    Optional<Users> getUserById(int id);

    Object getExternalUserGroupByID(int id);

    Object getExternalUserByID(int id);

    HttpStatus saveUser(Users users);

    HttpStatus removeUserById(int id);









}
