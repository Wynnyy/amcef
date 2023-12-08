package app.repositories;


import app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UsersRepository extends JpaRepository <Users,Integer> {


    List<Users> findById(int id);

    List<Users> findByGroupId(int id);

}
