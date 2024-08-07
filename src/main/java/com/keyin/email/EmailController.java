package com.keyin.classes.email;
import com.keyin.classes.address.Address;
import com.keyin.classes.contact.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public final class EmailController {
    @Autowired
    private EmailService service;
    public EmailController() {
        this.service = new EmailService();
    }
    @GetMapping("/api/emails")
    public List<Email> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/emails/{pk}")
    public Email getByPk(@PathVariable long pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/emails/{address}")
    public Email getByAddress(@PathVariable Address address) {
        return service.getByAddress(address);
    }
    @GetMapping("/api/emails/{contact}")
    public List<Email> getByContact(@PathVariable Contact contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/emails/{category}")
    public List<Email> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }
    @GetMapping("/api/emails/active")
    public List<Email> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/emails/inactive")
    public List<Email> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/emails")
    public Email add(@RequestBody Email email) {
        return service.add(email);
    }
    @PatchMapping("/api/emails/{pk}/address")
    public Email editAddress(
            @PathVariable long pk,
            @RequestBody String address
    ) {
        return service.editAddress(pk, address);
    }
    @PatchMapping("/api/emails/{pk}/category")
    public Email editCategory(
            @PathVariable long pk,
            @RequestBody String category
    ) {
        return service.switchCategory(pk, category);
    }
//    @GetMapping("/api/emails/{pk}/activate")
//    public Email activate(@PathVariable long pk) {
//        return service.activate(pk);
//    }
//    @GetMapping("/api/emails/{pk}/deactivate")
//    public Email deactivate(@PathVariable long pk) {
//        return service.deactivate(pk);
//    }
}
