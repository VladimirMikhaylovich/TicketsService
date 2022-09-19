package com.vlady.ticketsservice.web;


import com.vlady.ticketsservice.models.Plane;
import com.vlady.ticketsservice.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PlanesController {
    @Autowired
     PlaneService planeService;

    @GetMapping("/planes")
    public List<Plane> showPlanes(){
       return planeService.showPlanes();
    }
    @GetMapping("/planes/{id}")
    public Plane getPlane(@PathVariable int id){
        return planeService.getPlane(id);
    }
    @PostMapping("plane")
    public Plane addPlane(@RequestBody Plane plane){
        return planeService.addPlane(plane);
    }
    @PutMapping("plane/{id}")
    public Plane updatePlane(@PathVariable int id){
        return planeService.updatePlane(id);
    }

    @PutMapping("/plane/delete/{id}")
    public void markPlaneDeleted(@PathVariable int id){
    planeService.markPlaneDeleted(id);
    }

}
