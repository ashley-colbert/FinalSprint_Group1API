package com.keyin.classes.contact;

import com.keyin.classes.address.Address;
import com.keyin.classes.email.Email;
import com.keyin.classes.phone.Phone;
import com.keyin.classes.rental.Rental;
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
     * @name    getAll
     * @desc    Get all contacts
     * @route   GET /api/contacts
     * @access  private
     */
    public List<Contact> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a contact by their primary key
     * @route   GET /api/contacts/{pk}
     * @access  private
     */
    public Contact getByPk(long pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByFirst
     * @desc    Get contacts with the given name
     * @route   GET /api/contacts/{first}
     * @access  private
     */
    public List<Contact> getByFirst(String first) {
        return repo.findAllByFirst(first);
    }
    /**
     * @name    getByLast
     * @desc    Get contacts with the given name
     * @route   GET /api/contact/{last}
     * @access  private
     */
    public List<Contact> getByLast(String last) {
        return repo.findAllByLast(last);
    }
    /**
     * @name    getByRole
     * @desc    Get contacts by role
     * @route   GET /api/contacts/{role}
     * @access  private
     */
    public List<Contact> getByRole(String role) {
        return repo.findAllByRole(role);
    }
    /**
     * @name    getByAddress
     * @desc    Get all contacts at the given street address
     * @route   GET /api/contacts/{address}
     * @access  private
     */
    public List<Contact> getByAddress(Address address) {
        return repo.findAllByAddress(address);
    }
    /**
     * @name    getByPhone
     * @desc    Get all contacts with the given phone number
     * @route   GET /api/contacts/{phone}
     * @access  private
     */
    public List<Contact> getByPhone(Phone phone) {
        return repo.findAllByPhone(phone);
    }
    /**
     * @name    getByEmail
     * @desc    Get the contact with the given email address
     * @route   GET /api/contacts/{email}
     * @access  private
     */
    public Contact getByEmail(Email email) {
        return repo.findByEmail(email);
    }
    /**
     * @name    getByRental
     * @desc    Get the contact who rented the given vehicle
     * @route   GET /api/contacts/{rental}
     * @access  private
     */
    public Contact getByRental(Rental rental) {
        return repo.findByRental(rental);
    }
    /**
     * @name    getActive
     * @desc    Get all active contacts
     * @route   GET /api/contacts/active
     * @access  private
     */
    public List<Contact> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive contacts
     * @route   GET /api/contacts/inactive
     * @access  private
     */
    public List<Contact> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add a contact
     * @route   POST /api/contacts
     * @access  private
     */
    public Contact add(Contact contact) {
        return repo.save(contact);
    }
    /**
     * @name    editFirst
     * @desc    Edit a contact's first name
     * @route   PATCH /api/contacts/{pk}/first
     * @access  private
     */
    public Contact editFirst(
            long pk,
            String first
    ) {
        this.current = repo.findById(pk).get();
        current.setFirst(first);
        return repo.save(current);
    }
    /**
     * @name    editLast
     * @desc    Edit a contact's last name
     * @route   PATCH /api/contacts/{pk}/last
     * @access  private
     */
    public Contact editLast(
            long pk,
            String last
    ) {
        this.current = repo.findById(pk).get();
        current.setLast(last);
        return repo.save(current);
    }
    /**
     * @name    editRole
     * @desc    Edit a contact's role
     * @route   PATCH /api/contacts/{pk}/role
     * @access  private
     */
    public Contact editRole(
            long pk,
            String role
    ) {
        this.current = repo.findById(pk).get();
        current.setRole(role);
        return repo.save(current);
    }
    /**
     * @name    addAddress
     * @desc    Add an address to a contact
     * @route   POST /api/contacts/{pk}/contacts
     * @access  private
     */
    public Contact addAddress(
            long pk,
            Address address
    ) {
        this.current = repo.findById(pk).get();
        current.getAddresses().add(address);
        return repo.save(current);
    }
    /**
     * @name    addAddresses
     * @desc    Add addresses to a contact
     * @route   POST /api/contacts/{pk}
     * @access  private
     */
    public Contact addAddresses(
            long pk,
            List<Address> addresses
    ) {
        this.current = repo.findById(pk).get();
        current.setAddresses(addresses);
        return repo.save(current);
    }
    /**
     * @name    replaceAddress
     * @desc    Replace an address associated with a contact
     * @route   PATCH /api/addresses/{pk}/addresses/{index}
     * @access  private
     */
    public Contact replaceAddress(
            long pk,
            int index,
            Address address
    ) {
        this.current = repo.findById(pk).get();
        current.getAddresses().set(index, address);
        return repo.save(current);
    }
    /**
     * @name    replaceAddresses
     * @desc    Replace all addresses associated with a contact
     * @route   PATCH /api/contacts/{pk}/addresses
     * @access  private
     */
    public Contact replaceAddresses(
            long pk,
            List<Address> addresses
    ) {
        this.current = repo.findById(pk).get();
        current.setAddresses(addresses);
        return repo.save(current);
    }
    /**
     * @name    deleteAddress
     * @desc    Delete an address from a contact
     * @route   DELETE /api/contacts/{pk}/addresses/{index}
     * @access  private
     */
    public Contact deleteAddress(
            long pk,
            int index
    ) {
        this.current = repo.findById(pk).get();
        current.getAddresses().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deleteAddresses
     * @desc    Delete all addresses associated with a contact
     * @route   DELETE /api/contacts/{pk}/addresses
     * @access  private
     */
    public Contact deleteAddresses(long pk) {
        this.current = repo.findById(pk).get();
        current.getAddresses().clear();
        return repo.save(current);
    }
    /**
     * @name    addPhone
     * @desc    Add a phone number to a contact
     * @route   POST /api/contacts/{pk}/phones
     * @access  private
     */
    public Contact addPhone(
            long pk,
            Phone phone
    ) {
        this.current = repo.findById(pk).get();
        current.getPhones().add(phone);
        return repo.save(current);
    }
    /**
     * @name    addPhones
     * @desc    Add phone numbers to a contact
     * @route   POST /api/contacts/{pk}
     * @access  private
     */
    public Contact addPhones(
            long pk,
            List<Phone> phones
    ) {
        this.current = repo.findById(pk).get();
        current.setPhones(phones);
        return repo.save(current);
    }
    /**
     * @name    replacePhone
     * @desc    Replace a phone number associated with a contact
     * @route   PATCH /api/contacts/{pk}/phones/{index}
     * @access  private
     */
    public Contact replacePhone(
            long pk,
            int index,
            Phone phone
    ) {
        this.current = repo.findById(pk).get();
        current.getPhones().set(index, phone);
        return repo.save(current);
    }
    /**
     * @name    replacePhones
     * @desc    Replace all phone numbers associated with a contact
     * @route   PATCH /api/contacts/{pk}/phones
     * @access  private
     */
    public Contact replacePhones(
            long pk,
            List<Phone> phones
    ) {
        this.current = repo.findById(pk).get();
        current.setPhones(phones);
        return repo.save(current);
    }
    /**
     * @name    deletePhone
     * @desc    Delete a phone number from a contact
     * @route   DELETE /api/contacts/{pk}/phones/{index}
     * @access  private
     */
    public Contact deletePhone(
            long pk,
            int index
    ) {
        this.current = repo.findById(pk).get();
        current.getPhones().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deletePhones
     * @desc    Delete all phones numbers from a contact
     * @route   DELETE /api/contacts/{pk}/phones
     * @access  private
     */
    public Contact deletePhones(long pk) {
        this.current = repo.findById(pk).get();
        current.getPhones().clear();
        return repo.save(current);
    }
//    /**
//     * @name    activate
//     * @desc    Activate a contact
//     * @route   GET /api/contacts/{pk}/activate
//     * @access  private
//     */
//    public Contact activate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(true);
//        return repo.save(current);
//    }
//    /**
//     * @name    deactivate
//     * @desc    Deactivate a contact
//     * @route   GET /api/contacts/{pk}/deactivate
//     * @access  private
//     */
//    public Contact deactivate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(false);
//        return repo.save(current);
//    }
}
