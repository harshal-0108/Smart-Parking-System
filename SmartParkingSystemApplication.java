package com.smartparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.smartparking")
public class SmartParkingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartParkingSystemApplication.class, args);
    }
}