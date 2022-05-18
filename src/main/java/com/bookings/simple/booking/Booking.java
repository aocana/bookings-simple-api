package com.bookings.simple.booking;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.bookings.simple.user.User;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.EAGER;

@Entity @Data @RequiredArgsConstructor @NoArgsConstructor
@Table(name = "bookings")
public class Booking {

    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false,fetch = EAGER, cascade = CascadeType.ALL)
    private User user;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

}
