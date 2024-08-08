package com.keyin.phone;
import com.keyin.contact.Contact;
import com.keyin.location.Location;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @SequenceGenerator(name = "phone_sequence", sequenceName = "phone_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "phone_sequence")
    private long pk;
    private String number;
    @Nullable
    @ManyToMany
    private List<Contact> contacts;
    @Nullable
    @OneToOne
    private Location location;
    private String category;
    private boolean active;

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
