package com.fypRest.service;

import org.springframework.stereotype.Service;

@Service
public class StringService
{
    public String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
