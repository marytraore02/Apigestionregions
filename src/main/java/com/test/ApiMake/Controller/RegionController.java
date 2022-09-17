package com.test.ApiMake.Controller;


import com.test.ApiMake.models.Region;
import com.test.ApiMake.services.PaysService;
import com.test.ApiMake.services.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/region")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class RegionController {

    @Autowired
    private final RegionService regionService;

    @Autowired
    private final PaysService paysServices;

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public ResponseEntity<Region> create(@RequestBody Region region){
        // verification de l'existance du pays, de la langue et du domaine
        /*Pays pays = paysServices.getNomPays(region.getPays().getNomPays());
        // s'il l'une d'entre elles n'existe pas la créer
        if (pays == null) {
            paysServices.creer(region.getPays());
        }*/
        // après créer la region
        Region NewRegion = regionService.creer(region);
        return new ResponseEntity<>(NewRegion, HttpStatus.CREATED);

    }

    @GetMapping("/find/{idRegion}")
    public ResponseEntity<Region>  getIdRegion (@PathVariable("idRegion") Long idRegion){
        Region region = regionService.GetIdRegion(idRegion);
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/read")
    public ResponseEntity<List<Region>> read(){
        List<Region> regions = regionService.lire();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/update/{idRegion}")
    public ResponseEntity<Region> update(@PathVariable Long idRegion, @RequestBody Region region){
        Region UpdateRegion = regionService.modifier(idRegion,region);
        return new ResponseEntity<>(UpdateRegion, HttpStatus.OK);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/delete/{idRegion}")
    public ResponseEntity<Region> supprimer(@PathVariable Long idRegion){
        regionService.supprimer(idRegion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/lireSP")
    public Iterable<Object[]> getRegionsSP(){
        return regionService.getRegionsSP();
    }


    /*
    @RequestMapping("/")
    public String getPage(Model model){
        List<Region> listRegion = service.listAll();
        model.addAttribute("listRegion",listRegion);
        return "index";
    }
*/

/*
    @GetMapping(value = "/region")
    public List<Region> getRegion(){
        return regionRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveRegion(@RequestBody Region region){
        regionRepository.save(region);
        return "saved...";
    }

    @PutMapping(value = "/update/{id_Region}")
    public String updateRegion(@PathVariable Long id_Region,  @RequestBody Region region){
        return regionRepository.findById(id_Region)
                        .map(regions1->{
                            regions1.setCode_Region(region.getCode_Region());
                            regions1.setNom_Regiojn(region.getNom_Regiojn());
                            regions1.setDomaineActiviteRegion(region.getDomaineActiviteRegion());
                            regions1.setSuperficie(region.getSuperficie());
                            regions1.setLangueMajoritaire(region.getLangueMajoritaire());
                            regionRepository.save(regions1);
                            return "Updated...";
                        }).orElseThrow(()-> new RuntimeException("Regions non trouvé"));

    }

    @DeleteMapping(value = "/delete/{id_Region}")
    public String deleteRegion(@PathVariable Long id_Region){
        Region deleteRegion = regionRepository.findById(id_Region).get();
        regionRepository.delete(deleteRegion);
        return "Delete region with the id: "+id_Region;
    }
*/

}
