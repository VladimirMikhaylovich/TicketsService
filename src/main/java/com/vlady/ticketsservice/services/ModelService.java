package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.models.City;

import java.time.LocalDate;
import java.util.List;

public interface ModelService<T> {
   public List<T> showAll();
    public T getOne(int id);
    public T addNew(T t);
    public City updateIt(int id, String name, Integer numbers, LocalDate date);
    public void deleteIt(int id);

}
