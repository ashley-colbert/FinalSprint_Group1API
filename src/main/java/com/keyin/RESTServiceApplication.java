package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {
        "com.keyin.address",
        "com.keyin.agency",
        "com.keyin.contact",
        "com.keyin.email",
        "com.keyin.location",
        "com.keyin.phone",
        "com.keyin.rental",
        "com.keyin.vehicle"
})
public class RESTServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RESTServiceApplication.class, args);
    }
}
