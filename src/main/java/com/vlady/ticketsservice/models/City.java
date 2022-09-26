package com.vlady.ticketsservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;


@Entity
@Table(name = "city")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "name")
private String name;
    @Column(name = "numbers")
private Integer numbers;
    @Column(name = "city_day")
   private LocalDate cityDay;
    @Column(name = "tm")
    private Duration time;

 }
