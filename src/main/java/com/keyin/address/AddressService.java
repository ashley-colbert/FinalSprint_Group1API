package com.keyin.address;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class AddressService {
    @Autowired
    private AddressRepository repo;
    private Address current;
    public AddressService() {}
    /**
     * @name    getAll
     * @desc    Get all addresses
     * @route   GET /api/addresses
     * @access  private
     */
    public List<Address> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get an address by its primary key
     * @route   GET /api/addresses/{pk}
     * @access  private
     */
    public Address getByPk(long pk) {
        return repo.findById(pk).orElse(null);
    }
    /**
     * @name    getByStreet
     * @desc    Get all addresses on a street
     * @route   GET /api/addresses/{street}
     * @access  private
     */
    public List<Address> getByStreet(String street) {
        return StreamSupport.stream(
                repo.findAllByStreet(street).spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByCity
     * @desc    Get all addresses in the given city
     * @route   GET /api/addresses/{city}
     * @access  private
     */
    public List<Address> getByCity(String city) {
        return repo.findAllByCity(city);
    }
    /**
     * @name    getByProvTerr
     * @desc    Get all addresses in the given Province or Territory
     * @route   GET /api/address/{prov}
     * @access  private
     */
    public List<Address> getByProvTerr(String prov) {
        return repo.findAllByProv(prov);
    }
    /**
     * @name    getByPostal
     * @desc    Get all addresses with the given postal code
     * @route   GET /api/addresses/{postal}
     * @access  private
     */
    public List<Address> getByPostal(String postal) {
        return repo.findAllByPostal(postal);
    }
    /**
     * @name    getByCategory
     * @desc    Get all business, government, or residential addresses
     * @route   /api/addresses/{category}
     * @access  private
     */
    public List<Address> getByCategory(String category) {
        return repo.findAllByCategory(category);
    }
    /**
     * @name    getByContact
     * @desc    Get all addresses associated with the given contact
     * @route   GET /api/addresses/{contact}
     * @access  private
     */
//    public List<Address> getByContact(Contact contact) {
//        return repo.findAllByContact(contact);
//    }
    /**
     * @name    getByLocation
     * @desc    Get the address of an agency location
     * @route   GET /api/addresses/{location}
     * @access  private
     */
    public Address getByLocation(Location location) {
        return repo.findByLocation(location);
    }
    /**
     * @name    getActive
     * @desc    Get all active addresses
     * @route   GET /api/addresses/active
     * @access  private
     */
    public List<Address> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive addresses
     * @route   GET /api/addresses/inactive
     * @access  private
     */
    public List<Address> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add an address
     * @route   POST /api/addresses
     * @access  private
     */
    public Address add(Address newAddress) {
        return repo.save(newAddress);
    }
    /**
     * @name    editStreet
     * @desc    Edit an address's street
     * @route   PATCH /api/addresses/{pk}/street
     * @access  private
     */
    public Address editStreet(
            long pk,
            String street
    ) {
        this.current = repo.findById(pk).get();
        current.setStreet(street);
        return repo.save(current);
    }
    /**
     * @name    editCity
     * @desc    Edit an address's city
     * @route   PATCH /api/addresses/{pk}/city
     * @access  private
     */
    public Address editCity(
            long pk,
            String city
    ) {
        this.current = repo.findById(pk).get();
        current.setCity(city);
        return repo.save(current);
    }
    /**
     * @name    editProvTerr
     * @desc    Edit an address's Province  or Territory
     * @route   PATCH /api/addresses/{pk}/prov
     * @access  private
     */
    public Address editProvTerr(
            long pk,
            String prov
    ) {
        this.current = repo.findById(pk).get();
        current.setProv(prov);
        return repo.save(current);
    }
    /**
     * @name    editPostal
     * @desc    Edit an address's postal code
     * @route   PATCH /api/addresses/{pk}/postal
     * @access  private
     */
    public Address editPostal(
            long pk,
            String postal
    ) {
        this.current = repo.findById(pk).get();
        current.setPostal(postal);
        return repo.save(current);
    }
    /**
     * @name    editCategory
     * @desc    Edit an address's category
     * @route   PATCH /api/addresses/{pk}/category
     * @access  private
     */
    public Address editCategory(
            long pk,
            String category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
    /**
     * @name    addContact
     * @desc    Add a contact to an address
     * @route   POST /api/addresses/{pk}/contacts
     * @access  private
     */
    public Address addContact(
            long pk,
            Contact contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().add(contact);
        return repo.save(current);
    }
    /**
     * @name    addContacts
     * @desc    Add contacts to an address
     * @route   POST /api/addresses/{pk}
     * @access  private
     */
    public Address addContacts(
            long pk,
            List<Contact> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }
    /**
     * @name    replaceContact
     * @desc    Replace a contact associated with an address
     * @route   PATCH /api/addresses/{pk}/contacts/{index}
     * @access  private
     */
    public Address replaceContact(
            long pk,
            int index,
            Contact contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().set(index, contact);
        return repo.save(current);
    }
    /**
     * @name    replaceContacts
     * @desc    Replace all contacts associated with an address
     * @route   PATCH /api/addresses/{pk}/contacts
     * @access  private
     */
    public Address replaceContacts(
            long pk,
            List<Contact> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }
    /**
     * @name    deleteContact
     * @desc    Delete a contact from a phone number
     * @route   DELETE /api/addresses/{pk}/contacts/{index}
     * @access  private
     */
    public Address deleteContact(
            long pk,
            int index
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deleteContacts
     * @desc    Delete all contacts from an address
     * @route   DELETE /api/addresses/{pk}/contacts
     * @access  private
     */
    public Address deleteContacts(long pk) {
        this.current = repo.findById(pk).get();
        current.getContacts().clear();
        return repo.save(current);
    }
//    /**
//     * @name    activate
//     * @desc    Activate an address
//     * @route   GET /api/addresses/{pk}/activate
//     * @access  private
//     */
//    public Address activate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(true);
//        return repo.save(current);
//    }
//    /**
//     * @name    deactivate
//     * @desc    Deactivate an address
//     * @route   GET /api/addresses/{pk}/deactivate
//     * @access  private
//     */
//    public Address deactivate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(false);
//        return repo.save(current);
//    }
}
