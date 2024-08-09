package com.keyin.phone;
import com.keyin.contact.Contact;
import com.keyin.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public final class PhoneController {
    @Autowired
    private PhoneService service;
    public PhoneController() {
        this.service = new PhoneService();
    }
    @GetMapping("/api/phones")
    public List<Phone> list() {
        return service.getAll();
    }
    @GetMapping("/api/phones/{pk}")
    public Phone getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/phones/{number}")
    public Phone getByNumber(@PathVariable String number) {
        return service.getByNumber(number);
    }
//    @GetMapping("/api/phones/{contact}")
//    public List<Phone> getByContact(@PathVariable Contact contact) {
//        return service.getByContact(contact);
//    }
    @GetMapping("/api/phones/{category}")
    public List<Phone> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }
    @GetMapping("/api/phones/{location}")
    public Phone getByLocation(@PathVariable Location location) {
        return service.getByLocation(location);
    }
    @GetMapping("/api/phones/active")
    public List<Phone> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/phones/inactive")
    public List<Phone> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/phones")
    public Phone add(@RequestBody Phone number) {
        return service.add(number);
    }
    @DeleteMapping("/api/phones/{pk}")
    public ResponseEntity<Void> delete(
            @PathVariable long pk
    ) {
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/api/phones/{pk}/number")
    public Phone editNumber(
            @PathVariable long pk,
            @RequestBody String number
    ) {
        return service.editNumber(pk, number);
    }
    @PatchMapping("/api/phones/{pk}/category")
    public Phone switchCategory(
            @PathVariable long pk,
            @RequestBody String category
    ) {
        return service.switchCategory(pk, category);
    }
    @PostMapping("/api/phones/:pk")
    public Phone addLocation(
            @PathVariable long pk,
            @RequestBody Location location
    ) {
        return service.addLocation(pk, location);
    }
    @DeleteMapping("/api/phones/{pk}/location")
    public Phone deleteLocation(@PathVariable long pk) {
        return service.deleteLocation(pk);
    }
    @PostMapping("/api/phones/{pk}/contacts")
    public Phone addContact(
            @PathVariable long pk,
            @RequestBody Contact contact
    ) {
        return service.addContact(pk, contact);
    }
    @PostMapping("/api/phones/{pk}")
    public Phone addContacts(
            @PathVariable long pk,
            @RequestBody List<Contact> contacts
    ) {
        return service.addContacts(pk, contacts);
    }
    @PatchMapping("/api/phones/{pk}/contacts/{index}")
    public Phone replaceContact(
            @PathVariable long pk,
            @PathVariable int index,
            @RequestBody Contact contact
    ) {
        return service.replaceContact(pk, index, contact);
    }
    @PatchMapping("/api/phones/{pk}/contacts")
    public Phone replaceContacts(
            long pk,
            List<Contact> contacts
    ) {
        return service.replaceContacts(pk, contacts);
    }
    @DeleteMapping("/api/phones/{pk}/contacts/{index}")
    public Phone deleteContact(
            @PathVariable long pk,
            @PathVariable int index
    ) {
        return service.deleteContact(pk, index);
    }
    @DeleteMapping("/api/phones/{pk}/contacts")
    public Phone deleteContacts(@PathVariable long pk) {
        return service.deleteContacts(pk);
    }
//    @GetMapping("/api/phones/{pk}/activate")
//    public Phone activate(@PathVariable long pk) {
//        return service.activate(pk);
//    }
//    @GetMapping("/api/phone/{pk}/deactivate")
//    public Phone deactivate(@PathVariable long pk) {
//        return service.deactivate(pk);
//    }
}
