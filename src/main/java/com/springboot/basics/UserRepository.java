package com.springboot.basics;

import com.springboot.basics.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name, String city);

    /*              JPQL                 */

    @Query("select u from User u")
    public List<User> getAllUsers();

    @Query("select u from User u WHERE  u.name= :n")
    public List<User> getUserByName(@Param("n") String name);

    @Query("select u from User u WHERE  u.name= :n and u.city=:c")
    public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

    /*          Native Query            */

    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();

}
