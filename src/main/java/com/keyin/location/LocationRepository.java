package com.keyin.location;

import com.keyin.address.Address;
import com.keyin.agency.Agency;
import com.keyin.phone.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> findAllByAgency(Agency agency);
    Location findByAddress(Address address);
    Location findByPhone(Phone phone);
    List<Location> findAllByHours(String hours);
    List<Location> findAllByActive(boolean active);
}
