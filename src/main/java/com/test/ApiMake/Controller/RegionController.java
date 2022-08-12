package com.test.ApiMake.Controller;

import com.test.ApiMake.models.Region;
import com.test.ApiMake.repository.regionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private regionRepository regionRepository;

    @GetMapping(value = "/")
    public String getPage(){
        return "hello world";
    }

    @GetMapping(value = "/region")
    public List<Region> getRegion(){
        return regionRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveRegion(@RequestBody Region region){
        regionRepository.save(region);
        return "saved...";
    }

}
