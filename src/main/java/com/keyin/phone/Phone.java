package com.keyin.classes.phone;

import com.keyin.classes.contact.Contact;
import com.keyin.classes.location.Location;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Phone {
    @Id
    @SequenceGenerator(name = "phone_sequence", sequenceName = "phone_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "phone_sequence")
    private String number;
    @Nullable
    @ManyToMany
    private List<Contact> contacts;
    @Nullable
    @OneToOne
    private Location location;
    private String category;
    public Phone(
            String number,
            List<Contact> contacts,
            String category
    ) {
        super();
        this.number = number;
        this.contacts = contacts;
        this.category = category;
    }
    public Phone(
            String number,
            Location location,
            String category
    ) {
        super();
        this.number = number;
        this.category = category;
        this.location = location;
    }
    public Phone() {
        super();
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
