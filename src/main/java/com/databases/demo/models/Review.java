package com.databases.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id //Makes the property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //it means auto increment
    long id;

    @Column(nullable = false)
    String content;

    double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) //This tells the springboot about the format of date to be stored
    @CreatedDate //Stores the createdAt date automatically (At the time of object creation)
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //tells the spring only handle it when the object is updated
    Date updatedAt;



}
