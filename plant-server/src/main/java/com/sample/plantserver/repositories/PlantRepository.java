package com.sample.plantserver.repositories;

import com.sample.plantserver.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//TODO: remove annotation
@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

}
