package app.repositories;

import app.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query(value = "SELECT * FROM Users WHERE USER_ID = :userID",nativeQuery = true)
    List<Users> findAllUsersByGroupId(@Param("userID") int id);


}
