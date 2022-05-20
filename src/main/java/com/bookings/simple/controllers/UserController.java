package com.bookings.simple.controllers;

import com.bookings.simple.user.User;
import lombok.RequiredArgsConstructor;
import com.bookings.simple.user.dto.UserDto;
import com.bookings.simple.user.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookings.simple.user.dto.UserDtoConverter;
import com.bookings.simple.user.dto.UserFindByPhoneDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;
    private final UserDtoConverter userDtoConverter;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<User> result = userService.getAll();
        if (result.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserDto userDto){
        User user = userService.save(userDtoConverter.convertUserDtoToEntity(userDto));
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@RequestParam Long id){
        return ResponseEntity.ok().body(userService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestParam Long userId, @RequestBody UserDto userDto){
        User user = userService.get(userId);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/findByPhone")
    public ResponseEntity<?> findByPhone(@RequestBody UserFindByPhoneDto userDto){
        User user = userService.findByPhone(userDto.getPhone());
        if (user == null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }
}