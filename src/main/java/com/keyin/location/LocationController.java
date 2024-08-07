package com.keyin.classes.location;
import com.keyin.classes.address.Address;
import com.keyin.classes.agency.Agency;
import com.keyin.classes.phone.Phone;
import com.keyin.classes.rental.Rental;
import com.keyin.classes.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public final class LocationController {
    @Autowired
    private LocationService service;
    public LocationController() {
        this.service = new LocationService();
    }
    @GetMapping("/api/locations")
    public List<Location> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/locations/{pk}")
    public Location getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/locations/{agency}")
    public List<Location> getByAgency(@PathVariable Agency agency) {
        return service.getByAgency(agency);
    }
    @GetMapping("/api/locations/{address}")
    public Location getByAddress(@PathVariable Address address) {
        return service.getByAddress(address);
    }
    @GetMapping("/api/locations/{phone}")
    public Location getByPhone(@PathVariable Phone phone) {
        return service.getByPhone(phone);
    }
    @GetMapping("/api/locations/{vehicle}")
    public Location getByVehicle(@PathVariable Vehicle vehicle) {
        return service.getByVehicle(vehicle);
    }
    @GetMapping("/api/locations/{rental}")
    public List<Location> getByRental(@PathVariable Rental rental) {
        return service.getByRental(rental);
    }
    @PostMapping("/api/locations")
    public Location add(@RequestBody Location location) {
        return service.add(location);
    }
    @PatchMapping("/api/locations/{pk}/agency")
    public Location editAgency(
            @PathVariable long pk,
            @RequestBody Agency agency
    ) {
        return service.editAgency(pk, agency);
    }
    @PatchMapping("/api/locations/{pk}/address")
    public Location editAddress(
            long pk,
            Address address
    ) {
        return service.editAddress(pk, address);
    }
    @PatchMapping("/api/locations/{pk}/phone")
    public Location editPhone(
            long pk,
            Phone phone
    ) {
        return service.editPhone(pk, phone);
    }
    @PatchMapping("/api/locations/{pk}/hours")
    public Location editHours(
            @PathVariable long pk,
            @RequestBody String hours
    ) {
        return service.editHours(pk, hours);
    }
//    @GetMapping("/api/locations/{pk}/activate")
//    public Location activate(@PathVariable long pk) {
//        return service.activate(pk);
//    }
//    @GetMapping("/api/locationss/{pk}/deactivate")
//    public Location deactivate(@PathVariable long pk) {
//        return service.deactivate(pk);
//    }
}
