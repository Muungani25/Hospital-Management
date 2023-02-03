package com.hms.system.hms.service;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;

public class Utils {
    public static String generateRandomId(int length){
        String randomString = RandomStringUtils.random(length, true, true).toUpperCase();
        int date = LocalDateTime.now().getMinute() + LocalDateTime.now().getSecond();
        return randomString + date;
    }
}
