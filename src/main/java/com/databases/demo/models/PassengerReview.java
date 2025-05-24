package com.databases.demo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends BaseModel{

    protected String passengerReviewContent;

}
