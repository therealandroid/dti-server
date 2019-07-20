package com.dti.codechallenge.server.repository;


import com.dti.codechallenge.server.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}
