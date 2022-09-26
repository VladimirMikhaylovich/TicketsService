package com.vlady.ticketsservice.web;


import com.vlady.ticketsservice.models.Plane;
import com.vlady.ticketsservice.models.Ticket;
import com.vlady.ticketsservice.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/plane")
public class PlanesController {
    @Autowired
     PlaneService planeService;

    @GetMapping
    public List<Plane> showPlanes(){
       return planeService.showPlanes();
    }
    @GetMapping("/{id}/tickets")
    public List<Ticket> getPlane(@PathVariable int id){
        return planeService.getTicketsForPlane(id);
    }
    @PostMapping("/")
    public Plane addPlane(@RequestBody Plane plane){
        return planeService.addPlane(plane);
    }
    @PutMapping("/{id}/{name}/{places}/{depart}/{cityFrom}/{cityTo}/{isDeleted}")

    public Plane updatePlane(@PathVariable int id,@PathVariable String name,@PathVariable Integer places,
                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE ) LocalDate depart,
                             @PathVariable String cityFrom, String cityTo,@PathVariable boolean isDeleted){
        return planeService.updatePlane(id, name, places, depart, cityFrom, cityTo, isDeleted);
    }

    @PutMapping("/plane/delete/{id}")
    public void markPlaneDeleted(@PathVariable int id){
    planeService.markPlaneDeleted(id);
    }

}
