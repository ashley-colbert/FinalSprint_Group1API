package com.keyin.classes.vehicle;
import com.keyin.classes.agency.Agency;
import com.keyin.classes.location.Location;
import com.keyin.classes.rental.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public final class VehicleController {
    @Autowired
    private VehicleService service;
    public VehicleController() {
        this.service = new VehicleService();
    }
    @GetMapping("/api/vehicles")
    public List<Vehicle> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/vehicles/{pk}")
    public Vehicle getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/vehicles/{manufacturer}")
    public List<Vehicle> getByManufacturer(@PathVariable String manufacturer) {
        return service.getByManufacturer(manufacturer);
    }
    @GetMapping("/api/vehicles/{model}")
    public List<Vehicle> getByModel(@PathVariable String model) {
        return service.getByModel(model);
    }
    @GetMapping("/api/vehicles/{year}")
    public List<Vehicle> getByYear(@PathVariable int year) {
        return service.getByYear(year);
    }
    @GetMapping("/api/vehicles/{capacity}")
    public List<Vehicle> getByCapacity(@PathVariable int capacity) {
        return service.getByCapacity(capacity);
    }
    @GetMapping("/api/vehicles/{category}")
    public List<Vehicle> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }
    @GetMapping("/api/vehicles/{stdRate}")
    public List<Vehicle> getByStdRate(@PathVariable float stdRate) {
        return service.getByStdRate(stdRate);
    }
    @GetMapping("/api/vehicles/{premRate}")
    public List<Vehicle> getByPremRate(@PathVariable float premRate) {
        return service.getByPremRate(premRate);
    }
    @GetMapping("/api/vehicles/{stdIns}")
    public List<Vehicle> getByStdIns(@PathVariable float stdIns) {
        return service.getByStdIns(stdIns);
    }
    @GetMapping("/api/vehicles/{premIns}")
    public List<Vehicle> getByPremIns(@PathVariable float premIns) {
        return service.getByPremIns(premIns);
    }
    @GetMapping("/api/vehicles/{plates}")
    public Vehicle getByPlates(@PathVariable String plates) {
        return service.getByPlates(plates);
    }
    @GetMapping("/api/vehicles/{agency}")
    public List<Vehicle> getByAgency(@PathVariable Agency agency) {
        return service.getByAgency(agency);
    }
    @GetMapping("/api/vehicles/{location}")
    public List<Vehicle> getByLocation(@PathVariable Location location) {
        return service.getByLocation(location);
    }
    @GetMapping("/api/vehicles/{rental}")
    public Vehicle getByRental(@PathVariable Rental rental) {
        return service.getByRental(rental);
    }
    @GetMapping("/api/vehicles/rented")
    public List<Vehicle> getRented() {
        return service.getRented();
    }
    @GetMapping("/api/vehicles/available")
    public List<Vehicle> getAvailable() {
        return service.getAvailable();
    }
    @GetMapping("/api/vehicles/active")
    public List<Vehicle> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/vehicle/inactive")
    public List<Vehicle> getInactive() {
        return service.getInactive();
    }
    @GetMapping("/api/vehicles/stdUnder/{max}")
    public List<Vehicle> getAllWithStdUnder(@PathVariable float max) {
        return service.getAllWithStdUnder(max);
    }
    @GetMapping("/api/vehicles/premUnder/{max}")
    public List<Vehicle> getAllWithPremUnder(@PathVariable float max) {
        return service.getAllWithPremUnder(max);
    }
    @PostMapping("/api/vehicles")
    public Vehicle add(@RequestBody Vehicle vehicle) {
        return service.add(vehicle);
    }
    @PatchMapping("/api/vehicles/{pk}/manufacturer")
    public Vehicle editManufacturer(
            @PathVariable long pk,
            @RequestBody String manufacturer
    ) {
        return service.editManufacturer(pk, manufacturer);
    }
    @PatchMapping("/api/vehicles/{pk}/model")
    public Vehicle editModel(
            @PathVariable long pk,
            @RequestBody String model
    ) {
        return service.editModel(pk, model);
    }
    @PatchMapping("/api/vehicles/{pk}/year")
    public Vehicle editYear(
            @PathVariable long pk,
            @RequestBody int year
    ) {
        return service.editYear(pk, year);
    }
    @PatchMapping("/api/vehicles/{pk}/capacity")
    public Vehicle editCapacity(
            @PathVariable long pk,
            @RequestBody int capacity
    ) {
        return service.editCapacity(pk, capacity);
    }
    @PatchMapping("/api/vehicles/{pk}/category")
    public Vehicle editCategory(
            @PathVariable long pk,
            @RequestBody String category
    ) {
        return service.editCategory(pk, category);
    }
    @PatchMapping("/api/vehicles/{pk}/stdRate")
    public Vehicle editStdRate(
            @PathVariable long pk,
            @RequestBody float stdRate
    ) {
        return service.editStdRate(pk, stdRate);
    }
    @PatchMapping("/api/vehicles/{pk}/premRate")
    public Vehicle editPremRate(
            @PathVariable long pk,
            @RequestBody float premRate
    ) {
        return service.editPremRate(pk, premRate);
    }
    @PatchMapping("/api/vehicles/{pk}/stdIms")
    public Vehicle editStdIns(
            @PathVariable long pk,
            @RequestBody float stdIns
    ) {
        return service.editStdIns(pk, stdIns);
    }
    @PatchMapping("/api/vehicles/{pk}/premIms")
    public Vehicle editPremIns(
            @PathVariable long pk,
            @RequestBody float premIns
    ) {
        return service.editPremIns(pk, premIns);
    }
    @PatchMapping("/api/vehicles/{pk}/plates")
    public Vehicle editPlates(
            @PathVariable long pk,
            @RequestBody String plates
    ) {
        return service.editPlates(pk, plates);
    }
    @PatchMapping("/api/vehicles/{pk}/agency")
    public Vehicle editAgency(
            @PathVariable long pk,
            @RequestBody Agency agency
    ) {
        return service.editAgency(pk, agency);
    }
    @PatchMapping("/api/vehicles/{pk}/location")
    public Vehicle editLocation(
            @PathVariable long pk,
            @RequestBody Location location
    ) {
        return service.editLocation(pk, location);
    }
//    @GetMapping("/api/vehicles/{pk}/activate")
//    public Vehicle activate(@PathVariable long pk) {
//        return service.activate(pk);
//    }
//    @GetMapping("/api/vehicle/{pk}/deactivate")
//    public Vehicle deactivate(@PathVariable long pk) {
//        return service.deactivate(pk);
//    }
}
