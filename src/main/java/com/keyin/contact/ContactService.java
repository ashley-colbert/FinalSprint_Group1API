package com.keyin.contact;
import com.keyin.address.Address;
//import com.keyin.email.Email;
import com.keyin.phone.Phone;
import com.keyin.rental.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class ContactService {
    @Autowired
    private ContactRepository repo;
    private Contact current;

    public ContactService() {}

    /**
     * @name getAll
     * @desc Get all contacts
     * @route GET /contacts
     * @access private
     */
    public List<Contact> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /**
     * @name getByPk
     * @desc Get a contact by their primary key
     * @route GET /contacts/{pk}
     * @access private
     */
    public Contact getByPk(long pk) {
        return repo.findById(pk).orElse(null);
    }

    /**
     * @name getByFirst
     * @desc Get contacts with the given first name
     * @route GET /contacts/first/{first}
     * @access private
     */
    public List<Contact> getByFirst(String first) {
        return repo.findAllByFirst(first);
    }

    /**
     * @name getByLast
     * @desc Get contacts with the given last name
     * @route GET /contacts/last/{last}
     * @access private
     */
    public List<Contact> getByLast(String last) {
        return repo.findAllByLast(last);
    }

    /**
     * @name getByRole
     * @desc Get contacts by role
     * @route GET /contacts/role/{role}
     * @access private
     */
    public List<Contact> getByRole(String role) {
        return repo.findAllByRole(role);
    }

    /**
     * @name getByEmail
     * @desc Get contacts by email
     * @route GET /contacts/role/{email}
     * @access private
     */
    public Contact getByEmail(String email) {
        return repo.findByEmail(email);
    }

    /**
     * @name getActive
     * @desc Get all active contacts
     * @route GET /contacts/active
     * @access private
     */
    public List<Contact> getActive() {
        return repo.findAllByActive(true);
    }

    /**
     * @name getInactive
     * @desc Get all inactive contacts
     * @route GET /contacts/inactive
     * @access private
     */
    public List<Contact> getInactive() {
        return repo.findAllByActive(false);
    }

    /**
     * @name add
     * @desc Add a contact
     * @route POST /contacts
     * @access private
     */
    public Contact add(Contact contact) {
        Contact savedContact = repo.save(contact);
        System.out.println("Saved Contact ID: " + savedContact.getPk()); // Log the pk
        return savedContact;
    }

    /**
     * @name delete
     * @desc Delete a contact
     * @route DELETE /contacts
     * @access private
     */
    public void delete(Contact contact) {
        repo.delete(contact);
        System.out.println("Deleted Contact ID: " + contact.getPk());
    }

    /**
     * @name editFirst
     * @desc Edit a contact's first name
     * @route PATCH /contacts/{pk}/first
     * @access private
     */
    public Contact editFirst(long pk, String first) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.setFirst(first);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name editLast
     * @desc Edit a contact's last name
     * @route PATCH /contacts/{pk}/last
     * @access private
     */
    public Contact editLast(long pk, String last) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.setLast(last);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name editRole
     * @desc Edit a contact's role
     * @route PATCH /contacts/{pk}/role
     * @access private
     */
    public Contact editRole(long pk, String role) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.setRole(role);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name addAddress
     * @desc Add an address to a contact
     * @route POST /contacts/{pk}/addresses
     * @access private
     */
    public Contact addAddress(long pk, Address address) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getAddresses().add(address);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name addAddresses
     * @desc Add addresses to a contact
     * @route POST /contacts/{pk}/addresses/batch
     * @access private
     */
    public Contact addAddresses(long pk, List<Address> addresses) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.setAddresses(addresses);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name replaceAddress
     * @desc Replace an address associated with a contact
     * @route PATCH /contacts/{pk}/addresses/{index}
     * @access private
     */
    public Contact replaceAddress(long pk, int index, Address address) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getAddresses().set(index, address);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name replaceAddresses
     * @desc Replace all addresses associated with a contact
     * @route PATCH /contacts/{pk}/addresses
     * @access private
     */
    public Contact replaceAddresses(long pk, List<Address> addresses) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.setAddresses(addresses);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name deleteAddress
     * @desc Delete an address from a contact
     * @route DELETE /contacts/{pk}/addresses/{index}
     * @access private
     */
    public Contact deleteAddress(long pk, int index) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getAddresses().remove(index);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name deleteAddresses
     * @desc Delete all addresses associated with a contact
     * @route DELETE /contacts/{pk}/addresses
     * @access private
     */
    public Contact deleteAddresses(long pk) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getAddresses().clear();
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name addPhone
     * @desc Add a phone number to a contact
     * @route POST /contacts/{pk}/phones
     * @access private
     */
    public Contact addPhone(long pk, Phone phone) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getPhones().add(phone);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name replacePhone
     * @desc Replace a phone number associated with a contact
     * @route PATCH /contacts/{pk}/phones/{index}
     * @access private
     */
    public Contact replacePhone(long pk, int index, Phone phone) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getPhones().set(index, phone);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name replacePhones
     * @desc Replace all phone numbers associated with a contact
     * @route PATCH /contacts/{pk}/phones
     * @access private
     */
    public Contact replacePhones(long pk, List<Phone> phones) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.setPhones(phones);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name deletePhone
     * @desc Delete a phone number from a contact
     * @route DELETE /contacts/{pk}/phones/{index}
     * @access private
     */
    public Contact deletePhone(long pk, int index) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getPhones().remove(index);
            return repo.save(current);
        }
        return null;
    }

    /**
     * @name deletePhones
     * @desc Delete all phone numbers from a contact
     * @route DELETE /contacts/{pk}/phones
     * @access private
     */
    public Contact deletePhones(long pk) {
        this.current = repo.findById(pk).orElse(null);
        if (current != null) {
            current.getPhones().clear();
            return repo.save(current);
        }
        return null;
    }

}
