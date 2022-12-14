package com.test.ApiMake.repository;


import com.test.ApiMake.models.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationRepository extends JpaRepository<Population, Long> {
}
