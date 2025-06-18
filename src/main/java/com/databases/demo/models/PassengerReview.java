package com.databases.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends BaseModel{

    @Column(nullable = false)
    protected String passengerReviewContent;

    @Column(nullable = false)
    protected String passengerReviewRating;
}
