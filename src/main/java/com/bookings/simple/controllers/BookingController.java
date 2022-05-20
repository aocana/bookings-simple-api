package com.bookings.simple.controllers;

import com.bookings.simple.user.User;
import lombok.RequiredArgsConstructor;
import com.bookings.simple.booking.Booking;
import org.springframework.http.ResponseEntity;
import com.bookings.simple.user.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.bookings.simple.booking.dto.BookingDto;
import com.bookings.simple.booking.BookingServiceImpl;
import com.bookings.simple.booking.dto.BookingDtoConverter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final UserServiceImpl userService;
    private final BookingServiceImpl bookingService;
    private final BookingDtoConverter bookingDtoConverter;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Booking> result = bookingService.getAll();
        if (result.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            List<BookingDto> dtoList = result
                    .stream()
                    .map(bookingDtoConverter::convertBookingEntityToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(dtoList);
        }
    }

    @PostMapping
    ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto){
        User user = userService.get(bookingDto.getUserId());
        Booking newBooking = bookingService.save(new Booking(user, bookingDto.getBookingDate()));

        return  ResponseEntity.ok().body(
                bookingDtoConverter.convertBookingEntityToDto(newBooking)
        );
    }

    @GetMapping("/{id}")
    ResponseEntity<Booking> get(@RequestParam Long bookingId){
        return ResponseEntity.ok().body(bookingService.get(bookingId));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@RequestParam Long id){
        bookingService.delete(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/user/{id}")
    ResponseEntity<List<Booking>> getAllByUserId(@RequestParam Long userId){
        return ResponseEntity.ok().body(bookingService.getByUser(userId));
    }
}
