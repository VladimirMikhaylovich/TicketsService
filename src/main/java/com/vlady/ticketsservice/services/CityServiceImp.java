package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.dao.Repo;
import com.vlady.ticketsservice.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImp implements ModelService<City> {
    @Autowired
    Repo cityRepo;

    @Override
    public List<City> showAll() {
        return cityRepo.findAll();
    }

    @Override
    public City getOne(int id) {
       City city = null;
        Optional<City> optional = (Optional<City>) cityRepo.findById(id);
        if(optional.isPresent())
            city = optional.get();
        return city ;
    }

    @Override
    public City addNew(City city) {
        return (City) cityRepo.save(city);
    }


    @Override
    public City updateIt(int id, String name, Integer numbers, LocalDate date, Duration time) {
        City city = null;
        Optional<City> optional = cityRepo.findById(id);
        if(optional.isPresent())
            city = optional.get();
        city.setName(name);
        city.setNumbers(numbers);
        city.setCityDay(date);
        city.setTime(time);
       // String s = "City "+city.getName()+" is updated";
        return cityRepo.save(city);
    }

    @Override
    public void deleteIt(int id) {
        cityRepo.deleteById(id);
    }
}
