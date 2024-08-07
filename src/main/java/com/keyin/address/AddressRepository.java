package com.keyin.classes.address;

import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
    List<Address> findAllByStreet(String street);
    List<Address> findAllByCity(String city);
    List<Address> findAllByProv(String prov);
    List<Address> findAllByPostal(String postal);
    List<Address> findAllByCategory(String category);
    List<Address> findAllByContact(Contact contact);
    Address findByLocation(Location location);
    List<Address> findAllByActive(boolean active);
}
