package com.keyin.classes.location;

import com.keyin.classes.address.Address;
import com.keyin.classes.agency.Agency;
import com.keyin.classes.phone.Phone;
import com.keyin.classes.rental.Rental;
import com.keyin.classes.vehicle.Vehicle;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Location {
    @Id
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "location_sequence")
    @ManyToOne
    private Agency agency;
    @OneToOne
    private Address address;
    @OneToOne
    private Phone phone;
    @OneToMany
    private List<Vehicle> vehicles;
    @Nullable
    @ManyToMany
    private List<Rental> rentals;
    private String hours;
    public Location(
            Agency agency,
            Address address,
            Phone phone,
            List<Vehicle> vehicles,
            String hours
    ) {
        super();
        this.agency = agency;
        this.address = address;
        this.phone = phone;
        this.vehicles = vehicles;
        this.hours = hours;
    }
    public Location() {
        super();
    }
    public Agency getAgency() {
        return agency;
    }
    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
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
    public String getHours() {
        return hours;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
}
