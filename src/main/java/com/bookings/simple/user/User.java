package com.bookings.simple.user;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_phone_unique", columnNames = "phone")
        }
)
public class User {
    @Id @GeneratedValue
    private Long id;

    @NonNull
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(80)", nullable = true)
    private String lastName;

    @NonNull
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
}
