package com.test.ApiMake.Controller;

import com.test.ApiMake.models.Population;
import com.test.ApiMake.models.Region;
import com.test.ApiMake.services.PopulationService;
import com.test.ApiMake.services.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/population")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class PopulationController {


    private final PopulationService populationService;


    //private regionRepository regionRepository;


    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Population create(@RequestBody Population population){
        return populationService.creer(population);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/read")
    public List<Population> read(){
        return populationService.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/update/{id_population}")
    public Population update(@PathVariable Long id_population, @RequestBody Population population){
        return populationService.modifier(id_population, population);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/delete/{id_population}")
    public String delete(@PathVariable Long id_population){
        return populationService.supprimer(id_population);
    }
}
