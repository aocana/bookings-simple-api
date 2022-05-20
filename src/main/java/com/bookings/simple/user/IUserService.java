package com.bookings.simple.user;

import com.bookings.simple.user.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User get(Long user_id);
    User findByPhone(String phone);
    User save(User user);
    User update(UserDto userDto);
}
