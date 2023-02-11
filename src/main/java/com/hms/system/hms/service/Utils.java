package com.hms.system.hms.service;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Utils {
    public static String generateRandomId(int length){
        String randomString = RandomStringUtils.random(length, true, true).toUpperCase();
        int date = LocalDateTime.now().getMinute() + LocalDateTime.now().getSecond();
        return randomString + date;
    }


    private static AtomicLong idCounter= new AtomicLong();

    public static String generateConversationId(){
        return String.valueOf(idCounter);
    }
}
