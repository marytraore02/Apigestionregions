package com.test.ApiMake.repository;

import com.test.ApiMake.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface regionRepository extends JpaRepository<Region, Long> {

}
