package com.test.ApiMake.services;

import com.test.ApiMake.models.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService {
    Region creer(Region region);
    List<Region> lire();
    Region modifier(Long id_Region, Region region);
    String supprimer(long id_Region);
    Iterable<Object[]> getRegionsSP();

}
