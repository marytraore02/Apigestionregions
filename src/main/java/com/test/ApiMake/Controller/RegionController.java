package com.test.ApiMake.Controller;

import com.test.ApiMake.models.Region;
import com.test.ApiMake.repository.regionRepository;
import com.test.ApiMake.services.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class RegionController {

    private final RegionService regionService;


    //private regionRepository regionRepository;


    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Region create(@RequestBody Region region){
        return regionService.creer(region);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/read")
    public List<Region> read(){
        return regionService.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/update/{id_Region}")
    public Region update(@PathVariable Long id_region, @RequestBody Region region){
        return regionService.modifier(id_region, region);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/delete/{id_Region}")
    public String delete(@PathVariable Long id_Region){
        return regionService.supprimer(id_Region);
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
