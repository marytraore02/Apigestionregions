package com.test.ApiMake.services;

import com.test.ApiMake.models.Region;
import com.test.ApiMake.repository.regionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final regionRepository regionRepository;

    @Override
    public Region creer(Region region) {
        return regionRepository.save(region);
        //return "add-student";
    }

    @Override
    public List<Region> lire() {
        return regionRepository.findAll();
    }

    @Override
    public Region modifier(Long id_Region, Region region) {
            return regionRepository.findById(id_Region)
                    .map(p->{
                        p.setCode_Region(region.getCode_Region());
                        p.setNom_Regiojn(region.getNom_Regiojn());
                        p.setDomaineActiviteRegion(region.getDomaineActiviteRegion());
                        p.setSuperficie(region.getSuperficie());
                        p.setLangueMajoritaire(region.getLangueMajoritaire());
                        return regionRepository.save(p);
                    }).orElseThrow(()-> new RuntimeException("Region non trouvé !"));
        }

    @Override
    public String supprimer(long id_Region) {
        regionRepository.deleteById(id_Region);
        return "Region supprimé";
    }

    public Iterable<Object[]> getRegionsSP() {
        return regionRepository.getRegionsSP();
    }
}
