package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.models.Plane;
import com.vlady.ticketsservice.models.Ticket;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface PlaneService {

    public List<Plane> showPlanes();
    public Plane getPlane(int id);
    public Plane addPlane(Plane plane);
    public Plane updatePlane(int id, String name, Integer places,
                             LocalDate depart, Duration duration,
                             String cityFrom, String cityTo, boolean isDeleted);
    public Plane markPlaneDeleted(int id);
    public  List<Ticket>  getTicketsForPlane(int planId);

}
