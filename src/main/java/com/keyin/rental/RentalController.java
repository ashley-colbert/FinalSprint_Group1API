package com.keyin.classes.rental;

import com.keyin.classes.agency.Agency;
import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import com.keyin.classes.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@CrossOrigin
public final class RentalController {
    @Autowired
    private RentalService service;
    public RentalController() {
        this.service = new RentalService();
    }
    @GetMapping("/api/rentals")
    public List<Rental> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/rentals/{pk}")
    public Rental getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/rentals/{vehicle}")
    public List<Rental> getByVehicle(@PathVariable Vehicle vehicle) {
        return service.getByVehicle(vehicle);
    }
    @GetMapping("/api/rentals/{contact}")
    public List<Rental> getByContact(@PathVariable Contact contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/rentals/{license}")
    public List<Rental> getByLicense(@PathVariable String license) {
        return service.getByLicense(license);
    }
    @GetMapping("/api/rentals/{agency}")
    public List<Rental> getByAgency(@PathVariable Agency agency) {
        return service.getByAgency(agency);
    }
    @GetMapping("/api/rentals/rentedFrom/{location}")
    public List<Rental> getByRentedFrom(@PathVariable Location location) {
        return service.getByRentedFrom(location);
    }
    @GetMapping("/api/rentals/rentedOn/{date}")
    public List<Rental> getByRentedOn(@PathVariable ZonedDateTime date) {
        return service.getByRentedOn(date);
    }
    @GetMapping("/api/rentals/dueToday")
    public List<Rental> getDueToday() {
        return service.getDueToday();
    }
    @GetMapping("/api/rentals/dueOn/{date}")
    public List<Rental> getDueOn(@PathVariable ZonedDateTime date) {
        return service.getDueOn(date);
    }
    @GetMapping("/api/rentals/returnedOn/{date}")
    public List<Rental> getByReturnedOn(@PathVariable ZonedDateTime date) {
        return service.getByReturnedOn(date);
    }
    @GetMapping("/api/rentals/returnedTo/{location}")
    public List<Rental> getByReturnedTo(@PathVariable Location location) {
        return service.getByReturnedTo(location);
    }
    @GetMapping("/api/rentals/active")
    public List<Rental> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/rentals/returned")
    public List<Rental> getReturned() {
        return service.getReturned();
    }
    @GetMapping("api/rentals/overdue")
    public List<Rental> getOverdue() {
        return service.getOverdue();
    }
    @PostMapping("/api/rentals")
    public Rental rent(@RequestBody Rental rental) {
        return service.rent(rental);
    }
    @PatchMapping("/api/rentals/{pk}/vehicle")
    public Rental swapVehicle(
            @PathVariable long pk,
            @RequestBody Vehicle vehicle
    ) {
        return service.swapVehicle(pk, vehicle);
    }
    @PatchMapping("/api/rentals/{pk}/return")
    public Rental returnVehicle(
            @PathVariable long pk,
            @RequestBody Location location
    ) {
        return service.returnVehicle(pk, location);
    }
}
