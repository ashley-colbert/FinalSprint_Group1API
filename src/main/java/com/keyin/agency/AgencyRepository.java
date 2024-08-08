package com.keyin.agency;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import com.keyin.rental.Rental;
import com.keyin.vehicle.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Agency findByPk(long pk);
    Agency findByName(String name);
    Agency findByWebsite(String website);
//    Agency findByLocation(Location locations);
//    Agency findByContact(Contact contact);
//    Agency findByVehicle(Vehicle vehicle);
//    Agency findByRental(Rental rental);
    List<Agency> findAllByActive(boolean active);
}
