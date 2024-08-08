package com.keyin.email;

import com.keyin.contact.Contact;
import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class Email {
    @Id
    @SequenceGenerator(name = "email_sequence", sequenceName = "email_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "email_sequence")
    private long pk;
    private String address;
    @ManyToOne
    private Contact contact;
    private String category;
    private boolean active;
    public Email(
            String address,
            Contact contact,
            String category
    ) {
        super();
        this.address = address;
        this.contact = contact;
        this.category = category;
    }
    public Email() {
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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
