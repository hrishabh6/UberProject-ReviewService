package com.example.uberprojectreviewservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DriverReview extends BaseModel{

    protected String driverReviewContent;

}
