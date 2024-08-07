package com.keyin.classes.rental;

import com.keyin.classes.agency.Agency;
import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import com.keyin.classes.vehicle.Vehicle;
import com.keyin.classes.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    private VehicleRepository vehicleRepository;
    private Rental currentRental;
    private Vehicle currentVehicle;
    public RentalService() {}
    /**
     * @name    getAll
     * @desc    Get all rentals
     * @route   GET /api/rentals
     * @access  private
     */
    public List<Rental> getAll() {
        return StreamSupport.stream(
                rentalRepository.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a rental by its primary key
     * @route   GET /api/rentals/{pk}
     * @access  private
     */
    public Rental getByPk(long pk) {
        return rentalRepository.findById(pk).get();
    }
    /**
     * @name    getByVehicle
     * @desc    Get all rentals of the given vehicle
     * @route   GET /api/rentals/{vehicle}
     * @access  private
     */
    public List<Rental> getByVehicle(Vehicle vehicle) {
        return rentalRepository.findAllByVehicle(vehicle);
    }
    /**
     * @name    getByContact
     * @desc    Get all of a contact's rentals
     * @route   GET /api/rentals/{contact}
     * @access  private
     */
    public List<Rental> getByContact(Contact contact) {
        return rentalRepository.findAllByContact(contact);
    }
    /**
     * @name    getByLicense
     * @desc    Get all rentals associated with the given driving license
     * @route   GET /api/rentals/{license}
     * @access  private
     */
    public List<Rental> getByLicense(String license) {
        return rentalRepository.findAllByLicense(license);
    }
    /**
     * @name    getByAgency
     * @desc    Get all rentals from the given agency
     * @route   GET /api/rentals/{agency}
     * @access  private
     */
    public List<Rental> getByAgency(Agency agency) {
        return rentalRepository.findAllByAgency(agency);
    }
    /**
     * @name    getByRentedFrom
     * @desc    Get all vehicles rented from a location
     * @route   GET /api/rentals/rentedFrom/{location}
     * @access  private
     */
    public List<Rental> getByRentedFrom(Location location) {
        return rentalRepository.findAllByRentedFrom(location);
    }
    /**
     * @name    getByRentedOn
     * @desc    Get all rentals booked on the given date
     * @route   GET /api/rentals/rentedOn/{date}
     * @access  private
     */
    public List<Rental> getByRentedOn(ZonedDateTime date) {
        return rentalRepository.findAllByRentedOn(date);
    }
    /**
     * @name    getDueToday
     * @desc    Get all rentals due today
     * @route   GET /api/rentals/dueToday
     * @access  private
     */
    public List<Rental> getDueToday() {
        return rentalRepository.findAllByDue(ZonedDateTime.now());
    }
    /**
     * @name    getDueOn
     * @desc    Get all rentals due to be returned on the given date
     * @route   GET /api/rentals/due/{date}
     * @access  private
     */
    public List<Rental> getDueOn(ZonedDateTime date) {
        return rentalRepository.findAllByDue(date);
    }
    /**
     * @name    getByReturnedOn
     * @desc    Get all rentals returned on the given date
     * @route   GET /api/rentals/returnedOn/{date}
     * @access  private
     */
    public List<Rental> getByReturnedOn(ZonedDateTime date) {
        return rentalRepository.findAllByRentedOn(date);
    }
    /**
     * @name    getByRetunedTo
     * @desc    Get all rentals returned to the given location
     * @route   GET /api/rentals/returnedTo/{location}
     * @access  private
     */
    public List<Rental> getByReturnedTo(Location location) {
        return rentalRepository.findAllByReturnedTo(location);
    }
    /**
     * @name    getActive
     * @desc    Get all active rentals
     * @route   GET /api/rentals/active
     * @access  private
     */
    public List<Rental> getActive() {
        return rentalRepository.findAllByActive(true);
    }
    /**
     * @name    getReturned
     * @desc    Get all returned rentals
     * @route   GET /api/rentals/returned
     * @access  private
     */
    public List<Rental> getReturned() {
        return rentalRepository.findAllByActive(false);
    }
    /**
     * @name    getOverdue
     * @desc    Get all overdue rentals
     * @route   GET /api/rentals/overdue
     * @access  private
     */
    public List<Rental> getOverdue() {
        return rentalRepository.findAllOverdue();
    }
    /**
     * @name    rent
     * @desc    Rent a vehicle
     * @route   POST /api/rentals
     * @access  private
     */
    public Rental rent(Rental rental) {
        this.currentVehicle = vehicleRepository.findById(rental.getVehicle().getPk()).get();
        currentVehicle.setRented(true);
        vehicleRepository.save(currentVehicle);
        return rentalRepository.save(rental);
    }
    /**
     * @name    swapVehicle
     * @desc    Swap a rented vehicle
     * @route   PATCH /api/rentals/{pk}/vehicle
     * @access  private
     */
    public Rental swapVehicle(
            long pk,
            Vehicle vehicle
    ) {
        this.currentRental = rentalRepository.findById(pk).get();
        this.currentVehicle = vehicleRepository.findById(currentRental.getVehicle().getPk()).get();
        currentVehicle.setRented(false);
        vehicleRepository.save(currentVehicle);
        currentRental.setVehicle(vehicle);
        this.currentVehicle = vehicleRepository.findById(currentRental.getVehicle().getPk()).get();
        currentVehicle.setRented(true);
        vehicleRepository.save(currentVehicle);
        return rentalRepository.save(currentRental);
    }
    /**
     * @name    returnVehicle
     * @desc    Return a rented vehicle
     * @route   PATCH /api/rentals/{pk}/return
     * @access  private
     */
    public Rental returnVehicle(
            long pk,
            Location location
    ) {
        this.currentRental = rentalRepository.findById(pk).get();
        this.currentVehicle = vehicleRepository.findById(currentRental.getVehicle().getPk()).get();
        currentVehicle.setRented(false);
        currentRental.setReturnedTo(location);
        currentRental.setReturnedOn(ZonedDateTime.now());
        vehicleRepository.save(currentVehicle);
        return rentalRepository.save(currentRental);
    }
}
