package com.test.ApiMake.Controller;


import com.test.ApiMake.models.Pays;
import com.test.ApiMake.models.Region;
import com.test.ApiMake.services.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pays")
@AllArgsConstructor
public class PaysController {

    private final PaysService paysService;


    //private regionRepository regionRepository;

    @GetMapping(value = "/")
    public String getPage(){
        return "hello world";
    }

    @PostMapping("/create")
    public Pays create(@RequestBody Pays pays){
        return paysService.creer(pays);
    }
    @GetMapping("/read")
    public List<Pays> read(){
        return paysService.lire();
    }

    @PutMapping("/update{id_pays}")
    public Pays update(@PathVariable Long id_pays, @RequestBody Pays pays){
        return paysService.modifier(id_pays, pays);
    }

    @DeleteMapping("/delete/{id_pays}")
    public String delete(@PathVariable Long id_pays){
        return paysService.supprimer(id_pays);
    }
}
