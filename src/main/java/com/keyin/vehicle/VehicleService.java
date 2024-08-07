package com.keyin.classes.vehicle;

import com.keyin.classes.agency.Agency;
import com.keyin.classes.location.Location;
import com.keyin.classes.rental.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class VehicleService {
    @Autowired
    private VehicleRepository repo;
    private Vehicle current;
    public VehicleService() {}
    /**
     * @name    getAll
     * @desc    Get all vehicles
     * @route   GET /api/vegicles
     * @access  private
     */
    public List<Vehicle> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a vehicle by its primary key
     * @route   GET /api/vehicles/{pk}
     * @access  private
     */
    public Vehicle getByPk(long pk) {
        return repo.findById(pk).orElse(null);
    }
    /**
     * @name    getByManufacturer
     * @desc    Get all vehicles by manufacturer
     * @route   GET /api/vehicles/{manufacturer}
     * @access  private
     */
    public List<Vehicle> getByManufacturer(String manufacturer) {
        return repo.findAllByManufacturer(manufacturer);
    }
    /**
     * @name    getByModel
     * @desc    Get all vehicles by model
     * @route   GET /api/vehicles/{model}
     * @access  private
     */
    public List<Vehicle> getByModel(String model) {
        return repo.findAllByModel(model);
    }
    /**
     * @name    getByYear
     * @desc    Get all vehicles by year
     * @route   GET /api/vehicles/{year}
     * @access  private
     */
    public List<Vehicle> getByYear(int year) {
        return repo.findAllByYear(year);
    }
    /**
     * @name    getByCapacity
     * @desc    Get all vehicles by seating capacity
     * @route   GET /api/vehicles/{capacity}
     * @access  private
     */
    public List<Vehicle> getByCapacity(int capacity) {
        return repo.findAllByCapacity(capacity);
    }
    /**
     * @name    getByCategory
     * @desc    Get all vehicles by category
     * @route   GET /api/vehicles/{category}
     * @access  private
     */
    public List<Vehicle> getByCategory(String category) {
        return repo.findAllByCategory(category);
    }
    /**
     * @name    getByStdRate
     * @desc    Get all vehicles by standard rate
     * @route   GET /api/vehicles/{stdRate}
     * @access  private
     */
    public List<Vehicle> getByStdRate(float stdRate) {
        return repo.findAllByStdRate(stdRate);
    }
    /**
     * @name    getByPremRate
     * @desc    Get all vehicles by premium rate
     * @route   GET /api/vehicles/{stdRate}
     * @access  private
     */
    public List<Vehicle> getByPremRate(float premRate) {
        return repo.findAllByPremRate(premRate);
    }
    /**
     * @name    getByStdIns
     * @desc    Get all vehicles by standard insurance rate
     * @route   GET /api/vehicles/{stdIns}
     * @access  private
     */
    public List<Vehicle> getByStdIns(float stdIns) {
        return repo.findAllByStdIns(stdIns);
    }
    /**
     * @name    getByPremIns
     * @desc    Get all vehicles by premium insurance rate
     * @route   GET /api/vehicles/{premIns}
     * @access  private
     */
    public List<Vehicle> getByPremIns(float premIns) {
        return repo.findAllByPremIns(premIns);
    }
    /**
     * @name    getByPlates
     * @desc    Get a vehicle by its plates
     * @route   GET /api/vehicles/{plates}
     * @access  private
     */
    public Vehicle getByPlates(String plates) {
        return repo.findByPlates(plates);
    }
    /**
     * @name    getByAgency
     * @desc    Get all vehicles by agency
     * @route   GET /api/vehicles/{agency}
     * @access  private
     */
    public List<Vehicle> getByAgency(Agency agency) {
        return repo.findAllByAgency(agency);
    }
    /**
     * @name    getByLocation
     * @desc    Get all vehicles by location
     * @route   GET /api/vehicles/{location}
     * @access  private
     */
    public List<Vehicle> getByLocation(Location location) {
        return repo.findAllByLocation(location);
    }
    /**
     * @name    getByRental
     * @desc    Get the rented vehicle
     * @route   GET /api/vehicles/{rental}
     * @access  private
     */
    public Vehicle getByRental(Rental rental) {
        return repo.findByRental(rental);
    }
    /**
     * @name    getRented
     * @desc    Get all currently rented vehicles
     * @route   GET /api/vehicles/rented
     * @access  private
     */
    public List<Vehicle> getRented() {
        return repo.findAllByRented(true);
    }
    /**
     * @name    getAvailable
     * @desc    Get all currently available vehicles
     * @route   GET /api/vehicles/rented
     * @access  private
     */
    public List<Vehicle> getAvailable() {
        return repo.findAllByRented(false);
    }
    /**
     * @name    getActive
     * @desc    Get all active vehicles
     * @route   GET /api/vehicles/active
     * @access  private
     */
    public List<Vehicle> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive vehicles
     * @route   GET /api/vehicles/inactive
     * @access  private
     */
    public List<Vehicle> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    getAllWithStdUnder
     * @desc    Get all vehicles under the given standard rate
     * @route   GET /api/vehicles/stdUnder/{max}
     * @access  private
     */
    public List<Vehicle> getAllWithStdUnder(float max) {
        return repo.findAllWithStdUnder(max);
    }
    /**
     * @name    getAllWithPremUnder
     * @desc    Get all vehicles under the given premium rate
     * @route   GET /api/vehicles/premUnder/{max}
     * @access  private
     */
    public List<Vehicle> getAllWithPremUnder(float max) {
        return repo.findAllWithPremUnder(max);
    }
    /**
     * @name    add
     * @desc    Add a vehicle
     * @route   POST /api/vehicles
     * @access  private
     */
    public Vehicle add(Vehicle newVehicle) {
        return repo.save(newVehicle);
    }
    /**
     * @name    editManufacturer
     * @desc    Edit a vehicle's manufacturer
     * @route   PATCH /api/vehicle/{pk}/manufacturer
     * @access  private
     */
    public Vehicle editManufacturer(
            long pk,
            String manufacturer
    ) {
        this.current = repo.findById(pk).get();
        current.setManufacturer(manufacturer);
        return repo.save(current);
    }
    /**
     * @name    editModel
     * @desc    Edit a vehicle's model
     * @route   PATCH /api/vehicle/{pk}/model
     * @access  private
     */
    public Vehicle editModel(
            long pk,
            String model
    ) {
        this.current = repo.findById(pk).get();
        current.setModel(model);
        return repo.save(current);
    }
    /**
     * @name    editYear
     * @desc    Edit a vehicle's year
     * @route   PATCH /api/vehicle/{pk}/year
     * @access  private
     */
    public Vehicle editYear(
            long pk,
            int year
    ) {
        this.current = repo.findById(pk).get();
        current.setYear(year);
        return repo.save(current);
    }
    /**
     * @name    editCapacity
     * @desc    Edit a vehicle's capacity
     * @route   PATCH /api/vehicle/{pk}/capacity
     * @access  private
     */
    public Vehicle editCapacity(
            long pk,
            int capacity
    ) {
        this.current = repo.findById(pk).get();
        current.setCapacity(capacity);
        return repo.save(current);
    }
    /**
     * @name    editCategory
     * @desc    Edit a vehicle's category
     * @route   PATCH /api/vehicle/{pk}/category
     * @access  private
     */
    public Vehicle editCategory(
            long pk,
            String category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
    /**
     * @name    editStdRate
     * @desc    Edit a vehicle's standard rate
     * @route   PATCH /api/vehicle/{pk}/stdRate
     * @access  private
     */
    public Vehicle editStdRate(
            long pk,
            float stdRate
    ) {
        this.current = repo.findById(pk).get();
        current.setStdRate(stdRate);
        return repo.save(current);
    }
    /**
     * @name    editPremRate
     * @desc    Edit a vehicle's premium rate
     * @route   PATCH /api/vehicle/{pk}/premRate
     * @access  private
     */
    public Vehicle editPremRate(
            long pk,
            float premRate
    ) {
        this.current = repo.findById(pk).get();
        current.setPremRate(premRate);
        return repo.save(current);
    }
    /**
     * @name    editStdIns
     * @desc    Edit a vehicle's standard insurance rate
     * @route   PATCH /api/vehicle/{pk}/stdIns
     * @access  private
     */
    public Vehicle editStdIns(
            long pk,
            float stdIns
    ) {
        this.current = repo.findById(pk).get();
        current.setStdRate(stdIns);
        return repo.save(current);
    }
    /**
     * @name    editPremIns
     * @desc    Edit a vehicle's premium insurance rate
     * @route   PATCH /api/vehicle/{pk}/premIns
     * @access  private
     */
    public Vehicle editPremIns(
            long pk,
            float premIns
    ) {
        this.current = repo.findById(pk).get();
        current.setPremRate(premIns);
        return repo.save(current);
    }
    /**
     * @name    editPlates
     * @desc    Edit a vehicle's plates
     * @route   PATCH /api/vehicle/{pk}/plates
     * @access  private
     */
    public Vehicle editPlates(
            long pk,
            String plates
    ) {
        this.current = repo.findById(pk).get();
        current.setPlates(plates);
        return repo.save(current);
    }
    /**
     * @name    editAgency
     * @desc    Edit the agency that owns the given vehicle
     * @route   PATCH /api/vehicle/{pk}/agency/{index}
     * @access  private
     */
    public Vehicle editAgency(
            long pk,
            Agency agency
    ) {
        this.current = repo.findById(pk).get();
        current.setAgency(agency);
        return repo.save(current);
    }
    /**
     * @name    editLocation
     * @desc    Edit a vehicle's location
     * @route   PATCH /api/vehicle/{pk}/location/{index}
     * @access  private
     */
    public Vehicle editLocation(
            long pk,
            Location location
    ) {
        this.current = repo.findById(pk).get();
        current.setLocation(location);
        return repo.save(current);
    }
//    /**
//     * @name    activate
//     * @desc    Activate a vehicle
//     * @route   GET /api/vehicles/{pk}/activate
//     * @access  private
//     */
//    public Vehicle activate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(true);
//        return repo.save(current);
//    }
//    /**
//     * @name    deactivate
//     * @desc    Deactivate a vehicle
//     * @route   GET /api/vehicles/{pk}/deactivate
//     * @access  private
//     */
//    public Vehicle deactivate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(false);
//        return repo.save(current);
//    }
}
