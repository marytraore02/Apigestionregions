package com.test.ApiMake.services;


import com.test.ApiMake.models.Pays;
import com.test.ApiMake.repository.PaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService {

    private final PaysRepository PaysRepository;

    @Override
    public Pays creer(Pays pays) {
        return PaysRepository.save(pays);
    }
/*
    @Override
    public Pays getNomPays(Pays pays) {
        return PaysRepository.findByNompays(pays.getNomPays());
    }

 */
    @Override
    public List<Pays> lire() {
        return PaysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id_pays, Pays pays) {
        return PaysRepository.findById(id_pays)
                .map(p->{
                    p.setNomPays(pays.getNomPays());
                    return PaysRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Pays non trouvé !"));
    }

    @Override
    public String supprimer(long id_pays) {
        PaysRepository.deleteById(id_pays);
        return "Region supprimé";
    }

}
