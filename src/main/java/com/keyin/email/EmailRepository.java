package com.keyin.email;
import com.keyin.contact.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findByAddress(String address);
    List<Email> findByContact(Contact contact);
    List<Email> findAllByCategory(String category);
    List<Email> findAllByActive(boolean active);
}
