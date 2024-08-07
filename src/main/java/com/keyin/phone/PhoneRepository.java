package com.keyin.classes.phone;

import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
    Phone findByNumber(String number);
    List<Phone> findAllByContact(Contact contact);
    List<Phone> findAllByCategory(String category);
    Phone findByLocation(Location location);
    List<Phone> findAllByActive(boolean active);
}
