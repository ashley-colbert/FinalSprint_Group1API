package com.keyin.contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAllByFirst(String first);
    List<Contact> findAllByLast(String last);
    List<Contact> findAllByRole(String role);
    List<Contact> findAllByActive(boolean active);
    Contact findByEmail(String email);
}
