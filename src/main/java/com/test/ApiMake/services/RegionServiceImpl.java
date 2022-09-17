package com.test.ApiMake.services;

import com.test.ApiMake.models.Region;
import com.test.ApiMake.repository.regionRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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
    public Region modifier(Long idRegion, Region region) {
            return regionRepository.findById(idRegion)
                    .map(p->{
                        p.setCode_Region(region.getCode_Region());
                        p.setNom_Region(region.getNom_Region());
                        p.setDomaineActiviteRegion(region.getDomaineActiviteRegion());
                        p.setSuperficie(region.getSuperficie());
                        p.setLangueMajoritaire(region.getLangueMajoritaire());
                        return regionRepository.save(p);
                    }).orElseThrow(()-> new RuntimeException("Region non trouvé !"));
        }

    @Override
    public void supprimer(long idRegion) {
         regionRepository.deleteById(idRegion);
    }

    @Override
    public Region GetIdRegion(Long idRegion) {
        return regionRepository.findByIdRegion(idRegion).get();
                //.orElseThrow(() -> mew UserNotFoundException("User by is "+ idRegion +" was not found"));
    }

    public Iterable<Object[]> getRegionsSP() {
        return regionRepository.getRegionsSP();
    }

}
