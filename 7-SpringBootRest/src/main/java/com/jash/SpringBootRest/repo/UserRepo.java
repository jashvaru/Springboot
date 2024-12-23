package com.jash.SpringBootRest.repo;

import com.jash.SpringBootRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value = "select * from users where username = :username")
    Optional<User> findByUsername(String username);
}
