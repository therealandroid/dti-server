package com.dti.codechallenge.server.repository;


import com.dti.codechallenge.server.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    User getUser(String username, String password);
}
