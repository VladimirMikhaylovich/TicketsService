package com.vlady.ticketsservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "plane")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "places")
    private Integer places;

    @Column(name = "depart")
    private LocalDate depart;

//    @Column(name = "duration")
//    private Duration duration;

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane", fetch = FetchType.LAZY)
    private List<Ticket> ticketListPlane;


}




