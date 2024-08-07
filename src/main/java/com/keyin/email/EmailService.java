package com.keyin.classes.email;

import com.keyin.classes.address.Address;
import com.keyin.classes.contact.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class EmailService {
    @Autowired
    private EmailRepository repo;
    private Email current;
    public EmailService() {}
    /**
     * @name    getAll
     * @desc    Get all email address
     * @route   GET /api/emails
     * @access  private
     */
    public List<Email> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get an email address by its primary key
     * @route   GET /api/emails/{pk}
     * @access  private
     */
    public Email getByPk(long pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByAddress
     * @desc    Get a single email address
     * @route   GET /api/emails/{address}
     * @access  private
     */
    public Email getByAddress(Address address) {
        return repo.findByAddress(null);
    }
    /**
     * @name    getByContact
     * @desc    Get all email address associated with the given contact
     * @route   GET /api/emails/{contact}
     * @access  private
     */
    public List<Email> getByContact(Contact contact) {
        return repo.findByContact(contact);
    }
    /**
     * @name    getByCategory
     * @desc    Get all personal or work email addresses
     * @route   GET /api/emails/{category}
     * @access  private
     */
    public List<Email> getByCategory(String category) {
        return repo.findAllByCategory(category);
    }
    /**
     * @name    getActive
     * @desc    Get all active email addresses
     * @route   GET /api/emails/active
     * @access  private
     */
    public List<Email> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive email addresses
     * @route   GET /api/emails/inactive
     * @access  private
     */
    public List<Email> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add an email address
     * @route   POST /api/emails
     * @access  private
     */
    public Email add(Email email) {
        return repo.save(email);
    }
    /**
     * @name    editAddress
     * @desc    Edit an email address
     * @route   PATCH /api/emails/{pk}/address
     * @access  private
     */
    public Email editAddress(
            long pk,
            String address
    ) {
        this.current = repo.findById(pk).get();
        current.setAddress(address);
        return repo.save(current);
    }
    /**
     * @name    switchCategory
     * @desc    Switch an email address's category to personal or work
     * @route   PATCH /api/emails/{pk}/category
     * @access  private
     */
    public Email switchCategory(
            long pk,
            String category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
//    /**
//     * @name    activate
//     * @desc    Activate an email address
//     * @route   GET /api/emails/{pk}/activate
//     * @access  private
//     */
//    public Email activate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(true);
//        return repo.save(current);
//    }
//    /**
//     * @name    deactivate
//     * @desc    Deactivate an email address
//     * @route   GET /api/emails/{pk}/deactivate
//     * @access  private
//     */
//    public Email deactivate(long pk) {
//        this.current = repo.findById(pk).get();
//        current.setActive(false);
//        return repo.save(current);
//    }
}
