package com.keyin.address;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAllByStreet(String street);
    List<Address> findAllByCity(String city);
    List<Address> findAllByProv(String prov);
    List<Address> findAllByPostal(String postal);
    List<Address> findAllByCategory(String category);
//    List<Address> findAllByContact(Contact contact);
    Address findByLocation(Location location);
    List<Address> findAllByActive(boolean active);
}