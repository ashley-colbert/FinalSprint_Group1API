package com.keyin.agency;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import com.keyin.rental.Rental;
import com.keyin.vehicle.Vehicle;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "agencies")
public class Agency {
    @Id
    @SequenceGenerator(name = "agency_sequence", sequenceName = "agency_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "agency_sequence")
    private long pk;
    private String name;
    private String website;
    @OneToMany
    private List<Location> locations;
    @OneToMany
    private List<Contact> contacts;
    @OneToMany
    private List<Vehicle> vehicles;
    @Nullable
    @OneToMany
    private List<Rental> rentals;
    boolean active;

    public Agency(
            String name,
            String website,
            List<Location> locations,
            List<Contact> contacts,
            List<Vehicle> vehicles
    ) {
        super();
        this.name = name;
        this.website = website;
        this.locations = locations;
        this.contacts = contacts;
        this.vehicles = vehicles;
    }
    public Agency() {
        super();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getPk() {
        return pk;
    }
    public void setPk(long pk) {
        this.pk = pk;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public List<Location> getLocations() {
        return locations;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public List<Rental> getRentals() {
        return rentals;
    }
    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
