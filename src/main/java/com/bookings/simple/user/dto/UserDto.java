package com.bookings.simple.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String phone;
}
