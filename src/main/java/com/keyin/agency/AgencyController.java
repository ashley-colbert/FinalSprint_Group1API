package com.keyin.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public final class AgencyController {
    @Autowired
    private AgencyService service;
    public AgencyController() {
        this.service = new AgencyService();
    }
    @GetMapping("/api/agencies")
    public List<Agency> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/agencies/{pk}")
    public Agency getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/agencies/{name}")
    public Agency getByName(@PathVariable String name) {
        return service.getByName(name);
    }
    @GetMapping("/api/agencies/{website}")
    public Agency getByWebsite(@PathVariable String website) {
        return service.getByWebsite(website);
    }
    @GetMapping("/api/agencies/active")
    public List<Agency> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/agencies/inactive")
    public List<Agency> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/agencies")
    public Agency add(@RequestBody Agency agency) {
        return service.add(agency);
    }
    @PatchMapping("/api/agencies/{pk}/name")
    public Agency rename(
            @PathVariable long pk,
            @RequestBody String name
    ) {
        return service.rename(pk, name);
    }
    @PatchMapping("/api/agencies/{pk}/website")
    public Agency editWebsite(
            @PathVariable long pk,
            @RequestBody String website
    ) {
        return service.editWebsite(pk, website);
    }
}
