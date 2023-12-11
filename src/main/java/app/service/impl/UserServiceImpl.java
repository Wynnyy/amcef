package app.service.impl;

import app.entity.Users;
import app.repositories.UserRepository;
import app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getGroupUsersById(int id) {
        return userRepository.findAllUsersByGroupId(id);
    }

    @Override
    public Optional<Users> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public HttpStatus saveUser(Users users) {
        userRepository.save(users);

        return HttpStatus.CREATED;
    }

    @Override
    public HttpStatus removeUserById(int id) {
        if(userRepository.existsById(id)){
           userRepository.deleteById(id);
        }else {
           log.error("User doesn't exists");
           return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public Object getExternalUserGroupByID(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts?userId=" + id  ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);
        Object[] objects = responseEntity.getBody();

        if(objects.length == 0 || objects == null){
            log.info("Result getExternalUserGroupByID doesn't exist with id : {}",id);
            return HttpStatus.NOT_FOUND;
        }
        log.info("\nResult getExternalUserGroupByID from External Databes jsonplaceholder.typicode.com  : \n{} ", objects);
        return objects;
    }

    @Override
    public Users getExternalUserByID(int id) {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Users users = restTemplate.getForObject(uri, Users.class);
        log.info("\nResult getExternalUserByID from External Databes jsonplaceholder.typicode.com : \n{} ", users);
        return users;
    }


}



