package com.vlady.ticketsservice.dao;

import com.vlady.ticketsservice.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanesRepo extends JpaRepository<Plane, Integer> {
}
