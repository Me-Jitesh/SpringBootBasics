package com.springboot.basics;

import com.springboot.basics.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name, String city);
}
