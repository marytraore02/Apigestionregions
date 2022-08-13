package com.test.ApiMake.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id_population;
    @Column(length = 10)
    private Long nb_population;
    @Column(length = 4)
    private Long annee_population;
}
