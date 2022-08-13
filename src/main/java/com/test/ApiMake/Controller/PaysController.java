package com.test.ApiMake.Controller;


import com.test.ApiMake.models.Pays;
import com.test.ApiMake.models.Region;
import com.test.ApiMake.services.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Sample hello world application")
@RestController
@RequestMapping("/pays")
@AllArgsConstructor
public class PaysController {

    private final PaysService paysService;


    //private regionRepository regionRepository;

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Pays create(@RequestBody Pays pays){
        return paysService.creer(pays);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/read")
    public List<Pays> read(){
        return paysService.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/update/{id_pays}")
    public Pays update(@PathVariable Long id_pays, @RequestBody Pays pays){
        return paysService.modifier(id_pays, pays);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/delete/{id_pays}")
    public String delete(@PathVariable Long id_pays){
        return paysService.supprimer(id_pays);
    }
}
