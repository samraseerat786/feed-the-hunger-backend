package com.fypRest.service;

import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public void save(User user)
    {
        try
        {
            userRepository.save(user);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId)
    {
        userRepository.deleteById(userId);
    }

    public User getById(int userId)
    {
        User user = userRepository.getOne(userId);
        return user;
    }

    public User getUserByUsername(String username)
    {
        return userRepository.getUserByUserName(username);
    }
}
