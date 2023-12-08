package app.service;

import app.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List <Users> getGroupUsersById(int id);

    List <Users> getUserById(int id);





}
