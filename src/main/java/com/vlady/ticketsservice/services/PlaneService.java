package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.models.Plane;

import java.util.List;

public interface PlaneService {

    public List<Plane> showPlanes();
    public Plane getPlane(int id);
    public Plane addPlane(Plane plane);
    public Plane updatePlane(int id);
    public Plane markPlaneDeleted(int id);

}
