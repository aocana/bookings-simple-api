package com.bookings.simple.user;

import com.bookings.simple.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final IUserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User get(Long user_id) {
        return userDao.findById(user_id).orElseThrow();
    }

    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(UserDto userDto) {
        return null;
    }
}
