package com.keyin.address;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "address_sequence")
    private long pk;
    private String street;
    private String city;
    private String prov;
    private String postal;
    private String category;
    private boolean active;
    @Nullable
    @ManyToMany
    private List<Contact> contacts;
    @Nullable
    @OneToOne
    private Location location;


    public Address(
            String street,
            String city,
            String prov,
            String postal,
            String category,
            List<Contact> contacts
    ) {
        super();
        this.street = street;
        this.city = city;
        this.prov = prov;
        this.postal = postal;
        this.category = category;
        this.contacts = contacts;

    }
    public Address(
            String street,
            String city,
            String prov,
            String postal,
            String category,
            Location location
    ) {
        super();
        this.street = street;
        this.city = city;
        this.prov = prov;
        this.postal = postal;
        this.category = category;
        this.location = location;
    }
    public Address() {
        super();
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

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProv() {
        return prov;
    }
    public void setProv(String prov) {
        this.prov = prov;
    }
    public String getPostal() {
        return postal;
    }
    public void setPostal(String postal) {
        this.postal = postal;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
}
