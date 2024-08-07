package com.keyin.classes.location;

import com.keyin.classes.address.Address;
import com.keyin.classes.agency.Agency;
import com.keyin.classes.phone.Phone;
import com.keyin.classes.rental.Rental;
import com.keyin.classes.vehicle.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findAllByAgency(Agency agency);
    Location findByAddress(Address address);
    Location findByPhone(Phone phone);
    Location findByVehicle(Vehicle vehicle);
    List<Location> findAllByRental(Rental rental);
    List<Location> findAllByHours(String hours);
    List<Location> findAllByActive(boolean active);
}
