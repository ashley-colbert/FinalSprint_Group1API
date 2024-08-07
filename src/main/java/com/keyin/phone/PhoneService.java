package com.keyin.classes.phone;

import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class PhoneService {
    @Autowired
    private PhoneRepository repo;
    private Phone current;

    public PhoneService() {
    }

    /**
     * @name getAll
     * @desc Get all phone numbers
     * @route GET /api/phones
     * @access private
     */
    public List<Phone> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }

    /**
     * @name getByPk
     * @desc Get a phone number by its primary key
     * @route GET /api/phones/{pk}
     * @access private
     */
    public Phone getByPk(long pk) {
        return repo.findById(pk).get();
    }

    /**
     * @name getByNumber
     * @desc Get a phone number by the recorded number
     * @route GET /api/phones/{number}
     * @access private
     */
    public Phone getByNumber(String number) {
        return repo.findByNumber(number);
    }

    /**
     * @name getByContact
     * @desc Get all phone numbers associated with a contact
     * @route GET /api/phones/{contact}
     * @access private
     */
    public List<Phone> getByContact(Contact contact) {
        return repo.findAllByContact(contact);
    }

    /**
     * @name getByCategory
     * @desc Get all personal or work phone numbers
     * @route GET /api/phones/{category}
     * @access private
     */
    public List<Phone> getByCategory(String category) {
        return repo.findAllByCategory(category);
    }

    /**
     * @name getByLocation
     * @desc Get the phone number of the given agency location
     * @route GET /api/phones/{location}
     * @access private
     */
    public Phone getByLocation(Location location) {
        return repo.findByLocation(location);
    }

    /**
     * @name getActive
     * @desc Get all active phone numbers
     * @route GET /api/phones/active
     * @access private
     */
    public List<Phone> getActive() {
        return repo.findAllByActive(true);
    }

    /**
     * @name getInactive
     * @desc Get all inactive phone numbers
     * @route GET /api/phones/inactive
     * @access private
     */
    public List<Phone> getInactive() {
        return repo.findAllByActive(false);
    }

    /**
     * @name add
     * @desc Add a phone number
     * @route POST /api/phones
     * @access private
     */
    public Phone add(Phone number) {
        return repo.save(number);
    }

    /**
     * @name editNumber
     * @desc Edit a phone number
     * @route PATCH /api/phones/{pk}/number
     * @access private
     */
    public Phone editNumber(
            long pk,
            String number
    ) {
        this.current = repo.findById(pk).get();
        current.setNumber(number);
        return repo.save(current);
    }

    /**
     * @name switchCategory
     * @desc Switch a phone number's category to personal or work
     * @route PATCH /api/phones/{pk}/category
     * @access private
     */
    public Phone switchCategory(
            long pk,
            String category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }

    /**
     * @name addLocation
     * @desc Add an agency location to a phone number
     * @route POST /api/phones/{pk}
     * @access private
     */
    public Phone addLocation(
            long pk,
            Location location
    ) {
        this.current = repo.findById(pk).get();
        current.setLocation(location);
        return repo.save(current);
    }

    /**
     * @name deleteLocation
     * @desc Delete an agency location from a phone number
     * @route DELETE /api/phones/{pk}/location
     * @access private
     */
    public Phone deleteLocation(long pk) {
        this.current = repo.findById(pk).get();
        current.setLocation(null);
        return repo.save(current);
    }

    /**
     * @name addContact
     * @desc Add a contact to a phone number
     * @route POST /api/phones/{pk}/contacts
     * @access private
     */
    public Phone addContact(
            long pk,
            Contact contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().add(contact);
        return repo.save(current);
    }

    /**
     * @name addContacts
     * @desc Add contacts to a phone number
     * @route POST /api/phones/{pk}
     * @access private
     */
    public Phone addContacts(
            long pk,
            List<Contact> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }

    /**
     * @name replaceContact
     * @desc Replace a contact associated with a phone number
     * @route PATCH /api/phones/{pk}/contacts/{index}
     * @access private
     */
    public Phone replaceContact(
            long pk,
            int index,
            Contact contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().set(index, contact);
        return repo.save(current);
    }

    /**
     * @name replaceContacts
     * @desc Replace all contacts associated with a phone number
     * @route PATCH /api/phones/{pk}/contacts
     * @access private
     */
    public Phone replaceContacts(
            long pk,
            List<Contact> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }

    /**
     * @name deleteContact
     * @desc Delete a contact from a phone number
     * @route DELETE /api/phones/{pk}/contacts/{index}
     * @access private
     */
    public Phone deleteContact(
            long pk,
            int index
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().remove(index);
        return repo.save(current);
    }

    /**
     * @name deleteContacts
     * @desc Delete all contacts from a phone number
     * @route DELETE /api/phones/{pk}/contacts
     * @access private
     */
    public Phone deleteContacts(long pk) {
        this.current = repo.findById(pk).get();
        current.getContacts().clear();
        return repo.save(current);
    }
//    /**
//     * @name activate
//     * @desc Activate a phone number
//     * @route GET /api/phones/{pk}/activate
//     * @access private
//     */
//    public Phone activate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(true);
//        return repo.save(current);
//    }
//
//    /**
//     * @name deactivate
//     * @desc Deactivate a phone number
//     * @route GET /api/phones/{pk}/deactivate
//     * @access private
//     */
//    public Phone deactivate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(false);
//        return repo.save(current);
//    }
}