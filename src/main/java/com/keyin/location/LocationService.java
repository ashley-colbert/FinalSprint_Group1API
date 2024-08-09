package com.keyin.location;

import com.keyin.address.Address;
import com.keyin.agency.Agency;
import com.keyin.phone.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class LocationService {
    @Autowired
    private LocationRepository repo;
    private Location current;
    public LocationService() {}
    /**
     * @name    getAll
     * @desc    Get all locations
     * @route   GET /api/locations
     * @access  private
     */
    public List<Location> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a location by its primary key
     * @route   GET /api/locations/{pk}
     * @access  private
     */
    public Location getByPk(long pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByAgency
     * @desc    Get all of an agency's locations
     * @route   GET /api/locations/{agency}
     * @access  private
     */
    public List<Location> getByAgency(Agency agency) {
        return repo.findAllByAgency(agency);
    }
    /**
     * @name    getByAddress
     * @desc    Get the location at the given address
     * @route   GET /api/locations/{address}
     * @access  private
     */
    public Location getByAddress(Address address) {
        return repo.findByAddress(address);
    }
    /**
     * @name    getByPhone
     * @desc    Get the location by phone
     * @route   GET /api/locations/{phone}
     * @access  private
     */
    public Location getByPhone(Phone phone) {
        return repo.findByPhone(phone);
    }

    /**
     * @name    getByHours
     * @desc    Get all locations with the given hours
     * @route   GET /api/locations/{hours}
     * @access  private
     */
    public List<Location> getByHours(String hours) {
        return repo.findAllByHours(hours);
    }
    /**
     * @name    getActive
     * @desc    Get all active locations
     * @route   GET /api/locations/active
     * @access  private
     */
    public List<Location> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive locations
     * @route   GET /api/locations/inactive
     * @access  private
     */
    public List<Location> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add a location
     * @route   POST /api/locations
     * @access  private
     */
    public Location add(Location location) {
        return repo.save(location);
    }
    /**
     * @name    editAgency
     * @desc    Edit a location's owner agency
     * @route   PATCH /api/locations/{pk}/agency
     * @access  private
     */
    public Location editAgency(
            long pk,
            Agency agency
    ) {
        this.current = repo.findById(pk).get();
        current.setAgency(agency);
        return repo.save(current);
    }
    /**
     * @name    editAddress
     * @desc    Edit a location's address
     * @route   PATCH /api/locations/{pk}/address
     * @access  private
     */
    public Location editAddress(
            long pk,
            Address address
    ) {
        this.current = repo.findById(pk).get();
        current.setAddress(address);
        return repo.save(current);
    }
    /**
     * @name    editPhone
     * @desc    Edit a location's phone number
     * @route   PATCH /api/locations/{pk}/phone
     * @access  private
     */
    public Location editPhone(
            long pk,
            Phone phone
    ) {
        this.current = repo.findById(pk).get();
        current.setPhone(phone);
        return repo.save(current);
    }
    /**
     * @name    editHours
     * @desc    Edit a location's hours
     * @route   PATCH /api/locations/{pk}/hours
     * @access  private
     */
    public Location editHours(
            long pk,
            String hours
    ) {
        this.current = repo.findById(pk).get();
        current.setHours(hours);
        return repo.save(current);
    }
}
