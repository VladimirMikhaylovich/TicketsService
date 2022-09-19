package com.vlady.ticketsservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "plane")
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

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "city_from")
    private String cityFrom;

    @Column(name = "city_to")
    private String cityTo;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plane", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Ticket> ticketListPlane;

    public Plane() {
    }

    public Plane(String name, Integer places, LocalDate depart, Duration duration, String cityFrom, String cityTo, boolean isDeleted) {
        this.name = name;
        this.places = places;
        this.depart = depart;
        this.duration = duration;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.isDeleted = isDeleted;
//        for(int i = 0; i<places; i++){
//            Ticket ticket = new Ticket();
//            ticketListPlane.add(ticket);
//        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public LocalDate getDepart() {
        return depart;
    }

    public void setDepart(LocalDate depart) {
        this.depart = depart;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
//       Duration dur = Duration.ofMinutes(duration);
//        this.duration = Duration.ofDays(dur.toMinutes());
        this.duration = duration;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
                isDeleted = deleted;
    }

    public List<Ticket> getTicketListPlane() {
        return ticketListPlane;
    }

    public void setTicketListPlane(List<Ticket> ticketList) {
        this.ticketListPlane = ticketList;
    }
}




