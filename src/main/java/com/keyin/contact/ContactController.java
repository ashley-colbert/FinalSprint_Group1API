package com.keyin.contact;

import com.keyin.address.Address;
//import com.keyin.email.Email;
import com.keyin.phone.Phone;
import com.keyin.rental.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public final class ContactController {
    @Autowired
    private ContactService service;
    private ContactController() {
        this.service = new ContactService();
    }
    @GetMapping("/api/contacts")
    public List<Contact> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/contacts/{pk}")
    public Contact getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/contacts/{first}")
    public List<Contact> getByFirst(@PathVariable String first) {
        return service.getByFirst(first);
    }
    @GetMapping("/api/contacts/{last}")
    public List<Contact> getByLast(@PathVariable String last) {
        return service.getByLast(last);
    }
    @GetMapping("/api/contacts/{role}")
    public List<Contact> getByRole(@PathVariable String role) {
        return service.getByRole(role);
    }
    @GetMapping("api/contacts:email")
    public Contact getByEmail(@PathVariable String email) {
        return service.getByEmail(email);
    }

    @GetMapping("/api/contacts/{active}")
    public List<Contact> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/contacts/inactive")
    public List<Contact> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/contacts")
    public ResponseEntity<Contact> add(@RequestBody Contact contact) {
        Contact savedContact = service.add(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }
    @DeleteMapping("/api/contacts/{pk}")
    public ResponseEntity<Void> delete(
            @PathVariable long pk
    ) {
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/api/contacts/{pk}/first")
    public Contact editFirst(
            @PathVariable long pk,
            @RequestBody String first
    ) {
        return service.editFirst(pk, first);
    }
    @PatchMapping("/api/contacts/{pk}/last")
    public Contact editLastt(
            @PathVariable long pk,
            @RequestBody String last
    ) {
        return service.editLast(pk, last);
    }
    @PatchMapping("/api/contacts/{pk}/role")
    public Contact editRole(
            @PathVariable long pk,
            @RequestBody String role
    ) {
        return service.editRole(pk, role);
    }
    @PostMapping("/api/contacts/{pk}/addresses")
    public Contact addAddress(
            @PathVariable long pk,
            @RequestBody Address address
    ) {
        return service.addAddress(pk, address);
    }
    @PostMapping("/api/contacts/{pk}")
    public Contact addAddresses(
            @PathVariable long pk,
            @RequestBody List<Address> addresses
    ) {
        return service.addAddresses(pk, addresses);
    }
    @PatchMapping("/api/contacts/{pk}/addresses/{index}")
    public Contact replaceAddress(
            @PathVariable long pk,
            @RequestBody int index,
            @RequestBody Address address
    ) {
        return service.replaceAddress(pk, index, address);
    }
    @PatchMapping("/api/contacts/{pk}/addresses")
    public Contact replaceAddresses(
            @PathVariable long pk,
            @RequestBody List<Address> addresses
    ) {
        return service.replaceAddresses(pk, addresses);
    }
    @DeleteMapping("/api/contacts/{pk}/addresses/{index}")
    public Contact deleteAddress(
            @PathVariable long pk,
            @PathVariable int index
    ) {
        return service.deleteAddress(pk, index);
    }
    @DeleteMapping("/api/contacts/{pk}/addresses")
    public Contact deleteAddresses(@PathVariable long pk) {
        return service.deleteAddresses(pk);
    }
    @PostMapping("/api/contacts/{pk}/phones")
    public Contact addPhone(
            @PathVariable long pk,
            @RequestBody Phone phone
    ) {
        return service.addPhone(pk, phone);
    }

    @PatchMapping("/api/contacts/{pk}/phones/{index}")
    public Contact replacePhone(
            @PathVariable long pk,
            @RequestBody int index,
            @RequestBody Phone phone

    ) {
        return service.replacePhone(pk, index, phone);
    }
    @PatchMapping("/api/contacts/{pk}/phones")
    public Contact replacePhones(
            @PathVariable long pk,
            @RequestBody List<Phone> phones
    ) {
        return service.replacePhones(pk, phones);
    }
    @DeleteMapping("/api/contacts/{pk}/phones/{index}")
    public Contact deletePhone(
            @PathVariable long pk,
            @PathVariable int index
    ) {
        return service.deletePhone(pk, index);
    }
    @DeleteMapping("/api/contacts/{pk}/phones")
    public Contact deletePhones(@PathVariable long pk) {
        return service.deletePhones(pk);
    }

}