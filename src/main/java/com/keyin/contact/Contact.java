package com.keyin.classes.contact;
import com.keyin.classes.address.Address;
import com.keyin.classes.email.Email;
import com.keyin.classes.phone.Phone;
import com.keyin.classes.rental.Rental;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Contact {

    @Id
    @SequenceGenerator(name = "contact_sequence", sequenceName = "contact_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "contact_sequence")
    private String first;
    private String last;
    private String role;

    @ManyToMany
    private List<Address> addresses;

    @ManyToMany
    private List<Phone> phones;

    @OneToMany
    private List<Email> emails;

    @Nullable
    @OneToMany
    private List<Rental> rentals;

    public Contact(
            String first,
            String last,
            String role,
            List<Address> addresses,
            List<Phone> phones,
            List<Email> emails
    ) {
        super();
        this.first = first;
        this.last = last;
        this.role = role;
        this.addresses = addresses;
        this.phones = phones;
        this.emails = emails;
    }
    public Contact() {
        super();
    }
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public List<Phone> getPhones() {
        return phones;
    }
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    public List<Email> getEmails() {
        return emails;
    }
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    public List<Rental> getRentals() {
        return rentals;
    }
    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
