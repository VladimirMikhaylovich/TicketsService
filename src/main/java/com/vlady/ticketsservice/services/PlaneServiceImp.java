package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.dao.PlanesRepo;
import com.vlady.ticketsservice.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImp implements PlaneService{
@Autowired
private PlanesRepo planesRepo;
    @Override
    public List<Plane> showPlanes() {
        return planesRepo.findAll();
    }

    @Override
    public Plane getPlane(int id) {
        Plane plane=null;
        Optional<Plane> optionalPlane =  planesRepo.findById(id);
        if(optionalPlane.isPresent())
            plane = optionalPlane.get();
        return plane;
    }

    @Override
    public Plane addPlane(Plane plane) {
//        if(plane.getName().contains("SuperJET"))
//            plane.setPlaces(100);
//        if(plane.getName().contains("Boing777"))
//            plane.setPlaces(200);
        return planesRepo.save(plane);
    }

    @Override
    public Plane updatePlane(int id) {
        Plane plane=null;
        Optional<Plane> optionalPlane =  planesRepo.findById(id);
        if(optionalPlane.isPresent())
            plane = optionalPlane.get();
        return planesRepo.save(plane);
    }

    @Override
    public Plane markPlaneDeleted(int id) {
        Plane plane=null;
        Optional<Plane> optionalPlane =  planesRepo.findById(id);
        if(optionalPlane.isPresent())
            plane = optionalPlane.get();
        plane.setDeleted(true);
        return plane;
    }
}
