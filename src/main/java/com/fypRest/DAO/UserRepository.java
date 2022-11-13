package com.fypRest.DAO;

import com.fypRest.enitity.Donner;
import com.fypRest.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("select u from User u where u.user_name = :username")
    User findByUsername(String username);

    @Query("select u from User u where u.user_name = :username")
    User getUserByUserName(String username);
}
