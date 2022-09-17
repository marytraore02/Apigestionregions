package com.test.ApiMake.services;

import org.springframework.stereotype.Service;

import com.test.ApiMake.models.Region;
import java.util.List;

@Service
public interface RegionService {
    Region creer(Region region);
    List<Region> lire();
    Region modifier(Long idRegion, Region region);
    void supprimer(long idRegion);
    Region GetIdRegion(Long idRegion);
    Iterable<Object[]> getRegionsSP();

}
