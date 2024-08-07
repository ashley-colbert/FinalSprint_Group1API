package com.keyin.classes.contact;

import com.keyin.classes.address.Address;
import com.keyin.classes.email.Email;
import com.keyin.classes.phone.Phone;
import com.keyin.classes.rental.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAllByFirst(String first);
    List<Contact> findAllByLast(String last);
    List<Contact> findAllByRole(String role);
    List<Contact> findAllByAddress(Address address);
    List<Contact> findAllByPhone(Phone phone);
    Contact findByEmail(Email email);
    Contact findByRental(Rental rental);
    List<Contact> findAllByActive(boolean active);
}
