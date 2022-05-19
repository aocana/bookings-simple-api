package com.bookings.simple.user.dto;

import org.modelmapper.ModelMapper;
import com.bookings.simple.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoConverter {
    private final ModelMapper modelMapper;

    public UserDto convertUserEntityToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public User convertUserDtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }
}