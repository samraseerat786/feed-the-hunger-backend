package com.fypRest.Controller;

import com.fypRest.DAO.ChannelRepository;
import com.fypRest.enitity.Channel;
import com.fypRest.enitity.User;
import com.fypRest.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*") //allowedHeaders = "*"
@RequestMapping("/channels")
public class ChannelController
{
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ChannelService service;

    @GetMapping("/list/{search}")
    public List<Channel> getAllChannels(@PathVariable String search)
    {
        return service.getChannelList(search);
    }

    @GetMapping("/conversation-user-list")
    public List<User> getUserByConversation() {
        List<User> users = service.getUserByConversation();
        return users;
    }
    @PostMapping("/exist-or-not/{name}")
    public String getChannels(@PathVariable String name){
        return service.saveIfDontExist(name);
    }
}
