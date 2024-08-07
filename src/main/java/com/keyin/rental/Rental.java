package com.keyin.classes.rental;

import com.keyin.classes.agency.Agency;
import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import com.keyin.classes.vehicle.Vehicle;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Rental {
    @Id
    @SequenceGenerator(name = "rental_sequence", sequenceName = "rental_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "rental_sequence")
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Contact contact;
    private String license;
    @ManyToOne
    private Agency agency;
    @ManyToOne
    private Location rentedFrom;
    private ZonedDateTime rentedOn;
    private ZonedDateTime due;
    @Nullable
    private ZonedDateTime returnedOn;
    @Nullable
    @ManyToOne
    private Location returnedTo;
    public Rental(
            Vehicle vehicle,
            Contact contact,
            String license,
            Agency agency,
            Location rentedFrom,
            ZonedDateTime rentedOn,
            ZonedDateTime due
    ) {
        super();
        this.vehicle = vehicle;
        this.contact = contact;
        this.license = license;
        this.agency = agency;
        this.rentedFrom = rentedFrom;
        this.rentedOn = rentedOn;
        this.due = due;
    }
    public Rental() {
        super();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public Agency getAgency() {
        return agency;
    }
    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    public Location getRentedFrom() {
        return rentedFrom;
    }
    public void setRentedFrom(Location rentedFrom) {
        this.rentedFrom = rentedFrom;
    }
    public ZonedDateTime getRentedOn() {
        return rentedOn;
    }
    public void setRentedOn(ZonedDateTime rentedOn) {
        this.rentedOn = rentedOn;
    }
    public ZonedDateTime getDue() {
        return due;
    }
    public void setDue(ZonedDateTime due) {
        this.due = due;
    }
    public ZonedDateTime getReturnedOn() {
        return returnedOn;
    }
    public void setReturnedOn(ZonedDateTime returnedOn) {
        this.returnedOn = returnedOn;
    }
    public Location getReturnedTo() {
        return returnedTo;
    }
    public void setReturnedTo(Location returnedTo) {
        this.returnedTo = returnedTo;
    }
}
