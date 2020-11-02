package com.projectkenangan.ciladarawedding.repositories;

import com.projectkenangan.ciladarawedding.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue,String> {
}
