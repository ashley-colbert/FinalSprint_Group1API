package com.keyin.address;

import com.keyin.contact.Contact;
import com.keyin.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public final class AddressController {
    @Autowired
    private AddressService service;
    public AddressController() {
        this.service = new AddressService();
    }
    @GetMapping("/api/addresses")
    public List<Address> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/addresses/{pk}")
    public Address getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }

    @GetMapping("/api/addresses/{street}")
    public List<Address> getByStreet(@PathVariable String street) {
        return service.getByStreet(street);
    }
    @GetMapping("/api/addresses/{city}")
    public List<Address> getByCity(@PathVariable String city) {
        return service.getByCity(city);
    }
    @GetMapping("/api/addresses/{prov}")
    public List<Address> getByProvTerr(@PathVariable String prov) {
        return service.getByProvTerr(prov);
    }
    @GetMapping("/api/addresses/{postal}")
    public List<Address> getByPostal(@PathVariable String postal) {
        return service.getByPostal(postal);
    }
    @GetMapping("/api/addresses/{category}")
    public List<Address> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }
//    @GetMapping("/api/addresses/{contact}")
//    public List<Address> getByContact(@PathVariable Contact contact) {
//        return service.getByContact(contact);
//    }
    @GetMapping("/api/addresses/{location}")
    public Address getByLocation(@PathVariable Location location) {
        return service.getByLocation(location);
    }
    @GetMapping("/api/addresses/active")
    public List<Address> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/addresses/inactive")
    public List<Address> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/addresses")
    public Address add(@RequestBody Address newAddress) {
        return service.add(newAddress);
    }
    @DeleteMapping("/api/addresses/{pk}")
    public ResponseEntity<Void> delete(
            @PathVariable long pk
    ) {
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/api/address/{pk}/street")
    public Address editStreet(
            @PathVariable long pk,
            @RequestBody String street
    ) {
        return service.editStreet(pk, street);
    }
    @PatchMapping("/api/address/{pk}/city")
    public Address editCity(
            @PathVariable long pk,
            @RequestBody String city
    ) {
        return service.editCity(pk, city);
    }
    @PatchMapping("/api/address/{pk}/prov")
    public Address editProvTerr(
            @PathVariable long pk,
            @RequestBody String prov
    ) {
        return service.editProvTerr(pk, prov);
    }
    @PatchMapping("/api/address/{pk}/postal")
    public Address editPostal(
            @PathVariable long pk,
            @RequestBody String postal
    ) {
        return service.editPostal(pk, postal);
    }
    @PatchMapping("/api/address/{pk}/category")
    public Address editCategory(
            @PathVariable long pk,
            @RequestBody String category
    ) {
        return service.editCategory(pk, category);
    }
    @PostMapping("/api/addresses/{pk}/contacts")
    public Address addContact(
            @PathVariable long pk,
            @RequestBody Contact contact
    ) {
        return service.addContact(pk, contact);
    }
    @PostMapping("/api/addresses/{pk}")
    public Address addContacts(
            @PathVariable long pk,
            @RequestBody List<Contact> contacts
    ) {
        return service.addContacts(pk, contacts);
    }
    @PatchMapping("/api/addresses/{pk}/contacts/{index}")
    public Address replaceContact(
            @PathVariable long pk,
            @PathVariable int index,
            @RequestBody Contact contact
    ) {
        return service.replaceContact(pk, index, contact);
    }
    @PatchMapping("/api/addresses/{pk}/contacts")
    public Address replaceContacts(
            @PathVariable long pk,
            @RequestBody List<Contact> contacts
    ) {
        return service.replaceContacts(pk, contacts);
    }
    @DeleteMapping("/api/addresses/{pk}/contacts/{index}")
    public Address deleteContact(
            @PathVariable long pk,
            @PathVariable int index
    ) {
        return service.deleteContact(pk, index);
    }
    @DeleteMapping("/api/addresses/{pk}/contacts")
    public Address deleteContacts(@PathVariable long pk) {
        return service.deleteContacts(pk);
    }
//    @GetMapping("/api/address/{pk}/activate")
//    public Address activate(@PathVariable long pk) {
//        return service.activate(pk);
//    }
//    @GetMapping("/api/address/{pk}/deactivate")
//    public Address deactivate(@PathVariable long pk) {
//        return service.deactivate(pk);
//    }
}
