package com.bookings.simple.booking;

import lombok.*;
import com.bookings.simple.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "bookings")
public class Booking {

    @Id @GeneratedValue
    private Long id;

    @NonNull
    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false,fetch = EAGER, cascade = CascadeType.ALL)
    private User user;

    @NonNull
    @Column(columnDefinition = "date",name = "booking_date")
    private LocalDateTime bookingDate;

}
