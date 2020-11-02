package com.projectkenangan.ciladarawedding.repositories;

import com.projectkenangan.ciladarawedding.entities.WeddingServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingServiceRepository extends JpaRepository<WeddingServices,String> {
}
