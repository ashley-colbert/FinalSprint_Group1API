package com.keyin.classes.agency;

import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import com.keyin.classes.rental.Rental;
import com.keyin.classes.vehicle.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Agency findByName(String name);
    Agency findByWebsite(String website);
    Agency findByLocation(Location location);
    Agency findByContact(Contact contact);
    Agency findByVehicle(Vehicle vehicle);
    Agency findByRental(Rental rental);
    List<Agency> findAllByActive(boolean active);
}
