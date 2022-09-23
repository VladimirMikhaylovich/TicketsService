package com.vlady.ticketsservice.web;


import com.vlady.ticketsservice.models.City;
import com.vlady.ticketsservice.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    ModelService<City> modelService;

    @GetMapping
    public List<City> showAll(){
        return modelService.showAll();
    }
    @GetMapping("/{id}")
    public City getCity(@PathVariable int id){
        return (City) modelService.getOne(id);
    }
    @PostMapping("/")
    public City addCity(@RequestBody City ciy){
        return (City) modelService.addNew(ciy);
    }
    @PutMapping("/{id}/{name}/{numbers}/{date}")
    public City changeCity(@PathVariable int id, @PathVariable String name, @PathVariable int numbers, @PathVariable
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date){
        return modelService.updateIt(id, name, numbers, date);
    }
//    @PutMapping("/")
//    public City changeCity(@PathVariable int id){
//        return modelService.updateIt(id);
//    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id){
        modelService.deleteIt(id);
        String s = "City № "+id+" is deleted";
        System.out.println(s);
        return s;
    }

}
