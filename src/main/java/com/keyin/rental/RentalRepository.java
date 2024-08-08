package com.keyin.rental;

import com.keyin.agency.Agency;
import com.keyin.contact.Contact;
import com.keyin.location.Location;
import com.keyin.vehicle.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {
    List<Rental> findAllByVehicle(Vehicle vehicle);
    List<Rental> findAllByContact(Contact contact);
    List<Rental> findAllByLicense(String license);
    List<Rental> findAllByAgency(Agency agency);
    List<Rental> findAllByRentedFrom(Location rentedFrom);
    List<Rental> findAllByRentedOn(ZonedDateTime rentedOn);
    List<Rental> findAllByDue(ZonedDateTime due);
    List<Rental> findAllByReturnedOn(ZonedDateTime returnedOn);
    List<Rental> findAllByReturnedTo(Location returnedTo);
    List<Rental> findAllByActive(boolean active);
    @Query("SELECT r FROM Rental r WHERE r.due < CURRENT_TIMESTAMP")
    List<Rental> findAllOverdue();
}
