package com.bookings.simple.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_phone_unique", columnNames = "phone")
        }
)
public class User {
    @Id @GeneratedValue
    private Long id;

    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(80)", nullable = true)
    private String lastName;

    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
}
