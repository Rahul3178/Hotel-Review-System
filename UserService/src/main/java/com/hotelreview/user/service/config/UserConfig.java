package com.hotelreview.user.service.config;

import com.hotelreview.user.service.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig
{
    @Bean
    public ModelMapper modelMapper()
    {
        return  new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public Logger logger()
    {
        return LoggerFactory.getLogger(UserServiceImpl.class);
    }
}
