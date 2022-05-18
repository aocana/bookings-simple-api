package com.bookings.simple.user;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User get(Long user_id);
    User save(User user);
    User update(User user);
}
