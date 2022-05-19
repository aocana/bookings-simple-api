package com.bookings.simple.booking.dto;

import com.bookings.simple.booking.Booking;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingDtoConverter {
    private final ModelMapper modelMapper;

    public BookingDto convertBookingEntityToDto(Booking booking){
        return modelMapper.map(booking, BookingDto.class);
    }

    public Booking convertBookingDtoToEntity(BookingDto bookingDto){
        return modelMapper.map(bookingDto, Booking.class);
    }
}
