package com.keyin.location;

import com.keyin.address.Address;
import com.keyin.agency.Agency;
import com.keyin.phone.Phone;
import com.keyin.rental.Rental;
import com.keyin.vehicle.Vehicle;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "location_sequence")
    private long pk;
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
    private boolean active;

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
