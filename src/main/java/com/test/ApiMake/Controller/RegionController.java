package com.test.ApiMake.Controller;

//import javax.validation.Valid;

import com.test.ApiMake.models.Pays;
import com.test.ApiMake.models.Population;
import com.test.ApiMake.models.Region;
import com.test.ApiMake.services.PaysService;
import com.test.ApiMake.services.PopulationService;
import com.test.ApiMake.services.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class RegionController {

    @Autowired
    private final RegionService regionService;

    @Autowired
    PaysService paysServices;

    @Autowired
    PopulationService populationService;

/*
    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Region create(@RequestBody Region region, Population population){
        Pays pays = paysServices.getNomPays(region.getPays());
        if(pays==null || population==null){
            paysServices.creer(region.getPays());
            populationService.creer(population);
        }

       return regionService.creer(region);
    }
*/
/*


    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("list")
    public String region(Model model) {
        model.addAttribute("region", this.regionRepository.findAll());
        return "index";
    }
*/


    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Region create(@RequestBody Region region, Population population){
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
    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/lireSP")
    public Iterable<Object[]> getRegionsSP(){
        return regionService.getRegionsSP();
    }
*/

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
