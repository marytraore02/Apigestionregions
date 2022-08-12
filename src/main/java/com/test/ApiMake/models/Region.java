package com.test.ApiMake.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Region")
    private Long id_Region;
    private String code_Region;
    private String nom_Regiojn;
    private String domaineActiviteRegion;
    private String superficie;
    private String langueMajoritaire;
}
