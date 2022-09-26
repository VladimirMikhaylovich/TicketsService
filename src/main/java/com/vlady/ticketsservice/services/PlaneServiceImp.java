package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.dao.PlanesRepo;
import com.vlady.ticketsservice.models.Plane;
import com.vlady.ticketsservice.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        if(plane.getName().contains("SuperJET")) {
            List<Ticket> ticketList = new ArrayList<>();
            for(int i= 0; i<plane.getPlaces();i++){
                Ticket ticket = new Ticket(5000,false);
                ticketList.add(ticket);
            }
            plane.setTicketListPlane(ticketList);

        }
//        if(plane.getName().contains("Boing777"))
//            plane.setPlaces(200);
        return planesRepo.save(plane);
    }

    @Override
    public Plane updatePlane(int id, String name, Integer places,
                             LocalDate depart, String cityFrom, String cityTo, boolean isDeleted) {
        Plane plane=null;
        Optional<Plane> optionalPlane =  planesRepo.findById(id);
        if(optionalPlane.isPresent())
            plane = optionalPlane.get();
        plane.setName(name);
        plane.setPlaces(places);
        plane.setDepart(depart);
        plane.setCityFrom(cityFrom);
        plane.setCityTo(cityTo);
        plane.setDeleted(isDeleted);
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

    public  List<Ticket>  getTicketsForPlane(int planId){
        Plane plane=null;
        Optional<Plane> optionalPlane =  planesRepo.findById(planId);
        if(optionalPlane.isPresent()){
            plane = optionalPlane.get();
            List<Ticket> list = plane.getTicketListPlane();
            return list;
        }
        return Collections.emptyList();
            }


}
