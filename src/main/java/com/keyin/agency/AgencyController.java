package com.keyin.classes.agency;
import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import com.keyin.classes.rental.Rental;
import com.keyin.classes.vehicle.Vehicle;
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
    @GetMapping("/api/agencies/{location}")
    public Agency getByLocation(@PathVariable Location location) {
        return service.getByLocation(location);
    }
    @GetMapping("/api/agencies/{contact}")
    public Agency getByContact(@PathVariable Contact contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/agencies/{vehicle}")
    public Agency getByVehicle(@PathVariable Vehicle vehicle) {
        return service.getByVehicle(vehicle);
    }
    @GetMapping("/api/agencies/{rental}")
    public Agency getByRental(@PathVariable Rental rental) {
        return service.getByRental(rental);
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
//    @GetMapping("/api/agencies/{pk}/activate")
//    public Agency activate(@PathVariable pk pk) {
//        return service.activate(pk);
//    }
//    @GetMapping("/api/agencies/{pk}/deactivate")
//    public Agency deactivate(@PathVariable pk pk) {
//        return service.deactivate(pk);
//    }
}
