package com.example.Taskin.Repository;

import com.example.Taskin.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("select u from User u where u.userName = ?1")
    User getUserByUserName(String username);


}
