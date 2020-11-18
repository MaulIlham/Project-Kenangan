package com.projectkenangan.ciladarawedding.repositories;

import com.projectkenangan.ciladarawedding.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
