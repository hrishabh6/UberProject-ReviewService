package com.example.uberprojectreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Review extends BaseModel{

    @Column(nullable = false)
    String content;

    Double rating;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString(){return "review : " + this.content + " "  + this.rating + " " + this.createdAt;}

}
