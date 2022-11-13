package com.fypRest.service;

import com.fypRest.DAO.ChannelRepository;
import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.Channel;
import com.fypRest.enitity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelService
{
    @Autowired
    ChannelRepository repository;

    @Autowired
    UserService userService;

    public ChannelService()
    {
    }

    public String saveIfDontExist(String name){
        boolean exist = repository.existsByName(name);
        if(exist){
            return "Already Exists";
        } else {
            Channel channel = new Channel(name);
            System.out.println(repository.save(channel));
            return "Channel was not exist, saved successfully";
        }
    }

    public List<Channel> getChannelList(String search){
        List<Channel> list = repository.findAll();
        if(list.size() == 0){
            return null;
        } else{
            list = list.stream()
                    .filter(c -> c.getName().contains(search))
                    .collect(Collectors.toList());
            System.out.println(list);
        }
        return list;
    }

    public List<User> getUserByConversation(){
        List<Channel> channels = this.getChannelList("admin");
        List<User> users = new ArrayList<>();
        if(channels.size() == 0) {
            return null;
        } else {
            for (Channel ch: channels) {
                String username = ch.getName().replace("-admin", "");
                User user = userService.getUserByUsername(username);
                users.add(user);
            }
            return users;
        }
    }
}
