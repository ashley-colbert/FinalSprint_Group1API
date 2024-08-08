package com.keyin.agency;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import com.keyin.rental.Rental;
import com.keyin.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class AgencyService {
    @Autowired
    private AgencyRepository repo;
    private Agency current;
    public AgencyService() {}
    /**
     * @name    getAll
     * @desc    Get all agencies
     * @route   GET /api/agencies
     * @access  private
     */
    public List<Agency> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get an agency by its primary key
     * @route   GET /api/agencies/{pk}
     * @access  private
     */
    public Agency getByPk(long pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByName
     * @desc    Get an agency by its name
     * @route   GET /api/agencies/{name}
     * @access  private
     */
    public Agency getByName(String name) {
        return repo.findByName(name);
    }
    /**
     * @name    getByWebsite
     * @desc    Get an agency by its website
     * @route   GET /api/agencies/{website}
     * @access  private
     */
    public Agency getByWebsite(String website) {
        return repo.findByWebsite(website);
    }
    /**
     * @name    getByLocation
     * @desc    Get the agency that owns the given location
     * @route   GET /api/agencies/{location}
     * @access  private
     */
//    public Agency getByLocation(Location location) {
//        return repo.findByLocation(location);
//    }
    /**
     * @name    getByContact
     * @desc    Get the agency that employs the given contact
     * @route   GET /api/agencies/{contact}
     * @access  private
     */
//    public Agency getByContact(Contact contact) {
//        return repo.findByContact(contact);
//    }
    /**
     * @name    getByVehicle
     * @desc    Get the agency that owns the given vehicle
     * @route   GET /api/agencies/{vehicle}
     * @access  private
     */
//    public Agency getByVehicle(Vehicle vehicle) {
//        return repo.findByVehicle(vehicle);
//    }
    /**
     * @name    getByRental
     * @desc    Get the agency that the given vehicle was rented from
     * @route   GET /api/agencies/{rental}
     * @access  private
     */
//    public Agency getByRental(Rental rental) {
//        return repo.findByRental(rental);
//    }
    /**
     * @name    getActive
     * @desc    Get all active agencies
     * @route   GET /api/agencies/active
     * @access  private
     */
    public List<Agency> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive agencies
     * @route   GET /api/agencies/inactive
     * @access  private
     */
    public List<Agency> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add an agency
     * @route   POST /api/agencies
     * @access  private
     */
    public Agency add(Agency agency) {
        return repo.save(agency);
    }
    /**
     * @name    rename
     * @desc    Rename an agency
     * @route   PATCH /api/agencies/{pk}/name
     * @access  private
     */
    public Agency rename(
            long pk,
            String name
    ) {
        this.current = repo.findById(pk).get();
        current.setName(name);
        return repo.save(current);
    }
    /**
     * @name    editWebsite
     * @desc    Edit an agency's website address
     * @route   PATCH /api/agencies/{pk}/website
     * @access  private
     */
    public Agency editWebsite(
            long pk,
            String website
    ) {
        this.current = repo.findById(pk).get();
        current.setWebsite(website);
        return repo.save(current);
    }
//    /**
//     * @name    activate
//     * @desc    Activate an agency
//     * @route   GET /api/agencies/{pk}/activate
//     * @access  private
//     */
//    public Agency activate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(true);
//        return repo.save(current);
//    }
//    /**
//     * @name    deactivate
//     * @desc    Deactivate an agency
//     * @route   GET /api/agencies/{pk}/deactivate
//     * @access  private
//     */
//    public Agency deactivate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(false);
//        return repo.save(current);
//    }
}
