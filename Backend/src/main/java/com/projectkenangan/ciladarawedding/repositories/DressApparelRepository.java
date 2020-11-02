package com.projectkenangan.ciladarawedding.repositories;

import com.projectkenangan.ciladarawedding.entities.DressApparel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DressApparelRepository extends JpaRepository<DressApparel,String> {
}
