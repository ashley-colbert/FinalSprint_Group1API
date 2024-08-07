package com.keyin.classes.email;

import com.keyin.classes.contact.Contact;
import jakarta.persistence.*;

@Entity
public class Email {
    @Id
    @SequenceGenerator(name = "email_sequence", sequenceName = "email_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "email_sequence")
    private String address;
    @ManyToOne
    private Contact contact;
    private String category;
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
