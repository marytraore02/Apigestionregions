package com.test.ApiMake.repository;
import com.test.ApiMake.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//import java.util.List;

@Repository
public interface regionRepository extends JpaRepository<Region, Long> {
    //List<Region> findByName(String name);
    //Region deleteRegionById(Long idRegion);
    Optional<Region> findByIdRegion(Long idRegion);

    @Query(value = "SELECT id_region,code_region,nom_regiojn,domaine_activite_region,superficie,langue_majoritaire FROM region", nativeQuery = true)
    Iterable<Object[]> getRegionsSP ();

}
