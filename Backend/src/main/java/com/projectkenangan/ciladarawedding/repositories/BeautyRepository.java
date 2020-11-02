package com.projectkenangan.ciladarawedding.repositories;

import com.projectkenangan.ciladarawedding.entities.Beauty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeautyRepository extends JpaRepository<Beauty,String> {

}
