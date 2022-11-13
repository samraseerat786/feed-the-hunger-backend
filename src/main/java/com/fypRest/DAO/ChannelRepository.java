package com.fypRest.DAO;

import com.fypRest.enitity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Integer>
{
    Channel findByName(String name);
    boolean existsByName(String name);
}
