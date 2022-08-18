package com.test.ApiMake.services;

import com.test.ApiMake.models.Population;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.test.ApiMake.repository.PopulationRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements PopulationService{

    private final PopulationRepository PopulationRepository;

    @Override
    public Population creer(Population population) {
        return PopulationRepository.save(population);
    }

    @Override
    public List<Population> lire() {
        return PopulationRepository.findAll();
    }

    @Override
    public Population modifier(Long id_population, Population population) {
        return PopulationRepository.findById(id_population)
                .map(p->{
                    p.setNb_population(population.getNb_population());
                    p.setAnnee_population(population.getAnnee_population());
                    return PopulationRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Population non trouvé !"));
    }

    @Override
    public String supprimer(long id_population) {
        PopulationRepository.deleteById(id_population);
        return "Population supprimé";
    }

}
