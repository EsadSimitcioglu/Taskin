package com.example.Taskin.Repository;

import com.example.Taskin.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query("select u from Users u where u.userName = ?1")
    Users getUserByUserName(String username);


}
