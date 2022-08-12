package com.test.ApiMake.services;

import com.test.ApiMake.models.Pays;

import java.util.List;

public interface PaysService {

    Pays creer (Pays pays);
    List<Pays> lire();
    Pays modifier(Long id_pays, Pays pays);
    String supprimer(long id_pays);
}
