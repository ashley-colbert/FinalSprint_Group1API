package com.keyin.contact;
import com.keyin.address.Address;
import com.keyin.email.Email;
import com.keyin.phone.Phone;
import com.keyin.rental.Rental;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @SequenceGenerator(name = "contact_sequence", sequenceName = "contact_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "contact_sequence")
    private long pk;
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
    private boolean active;

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

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
