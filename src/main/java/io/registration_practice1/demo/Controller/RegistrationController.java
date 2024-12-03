package io.registration_practice1.demo.Controller;


import io.registration_practice1.demo.RegistrationDto.RegistrationDto;
import io.registration_practice1.demo.Service.RegistrationService;
import io.registration_practice1.demo.entity.Registration;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    // Create a new registration
    @PostMapping
    public ResponseEntity<Registration> createRegistration(@Valid @RequestBody RegistrationDto dto) {
        Registration created = service.createRegistration(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get all registrations
    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = service.getAllRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    // Get registration by ID
    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Registration registration = service.getRegistrationById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
        return new ResponseEntity<>(registration, HttpStatus.OK);
    }

    // Update an existing registration
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable Long id, 
            @Valid @RequestBody RegistrationDto dto) {
        Registration updated = service.updateRegistration(id, dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Delete a registration
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        service.deleteRegistration(id);
        return new ResponseEntity<>("Registration deleted successfully!", HttpStatus.NO_CONTENT);
    }
}
