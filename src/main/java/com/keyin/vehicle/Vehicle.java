package com.keyin.vehicle;
import com.keyin.agency.Agency;
import com.keyin.location.Location;
import com.keyin.rental.Rental;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @SequenceGenerator(name = "vehicle_sequence", sequenceName = "vehicle_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "vehicle_sequence")
    private long pk;
    private String manufacturer;
    private String model;
    private int year;
    private int capacity;
    private String category;
    private float stdRate;
    @Nullable
    private float premRate;
    private float stdIns;
    @Nullable
    private float premIns;
    private String plates;
    @OneToOne
    private Agency agency;
    @OneToOne
    private Location location;
    @Nullable
    @OneToMany
    private List<Rental> rentals;
    private boolean rented;
    private boolean active;
    public Vehicle(
            String manufacturer,
            String model,
            int year,
            int capacity,
            String category,
            float stdRate,
            float premRate,
            float stdIns,
            float premIns,
            String plates,
            Agency agency,
            Location location
    ) {
        super();
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.category = category;
        this.stdRate = stdRate;
        this.premRate = premRate;
        this.stdIns = stdIns;
        this.premIns = premIns;
        this.plates = plates;
        this.agency = agency;
        this.location = location;
        this.rented = false;
    }
    public Vehicle(
            String manufacturer,
            String model,
            int year,
            int capacity,
            String category,
            float stdRate,
            float stdIns,
            String plates,
            Agency agency,
            Location location
    ) {
        super();
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.category = category;
        this.stdRate = stdRate;
        this.stdIns = stdIns;
        this.plates = plates;
        this.agency = agency;
        this.location = location;
        this.rented = false;
    }
    public Vehicle() {
        super();
        this.rented = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getStdRate() {
        return stdRate;
    }
    public void setStdRate(float stdRate) {
        this.stdRate = stdRate;
    }
    public float getPremRate() {
        return premRate;
    }
    public void setPremRate(float premRate) {
        this.premRate = premRate;
    }
    public float getStdIns() {
        return stdIns;
    }
    public void setStdIns(float stdIns) {
        this.stdIns = stdIns;
    }
    public float getPremIns() {
        return premIns;
    }
    public void setPremIns(float premIns) {
        this.premIns = premIns;
    }
    public String getPlates() {
        return plates;
    }
    public long getPk() {return pk; }
    public void setPk(long pk) { this.pk = pk; }
    public void setPlates(String plates) {
        this.plates = plates;
    }
    public Agency getAgency() {
        return agency;
    }
    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public List<Rental> getRentals() {
        return rentals;
    }
    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
    public boolean isRented() {
        return rented;
    }
    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
