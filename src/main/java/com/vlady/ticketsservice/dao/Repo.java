package com.vlady.ticketsservice.dao;

import com.vlady.ticketsservice.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<City, Integer> {
}
