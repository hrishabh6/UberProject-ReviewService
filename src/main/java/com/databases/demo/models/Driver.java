package com.databases.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false, unique = true)
    private String licenceNumber;

    //One to many 1:n
    @Builder.Default
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();

}
