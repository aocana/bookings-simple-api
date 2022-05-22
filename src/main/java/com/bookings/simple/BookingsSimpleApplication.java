package com.bookings.simple;

import com.bookings.simple.user.User;
import com.bookings.simple.user.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingsSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsSimpleApplication.class, args);
    }


    @Bean
    CommandLineRunner run (IUserService iUserService){
        return args -> {
            iUserService.save(new User(null, "Adrian", "Ocana", "666666666"));
        };
    }
}
