package io.registration_practice1.demo.Service;

import io.registration_practice1.demo.RegistrationDto.RegistrationDto;
import io.registration_practice1.demo.Repository.RegistrationRepository;
import io.registration_practice1.demo.entity.Registration;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repository;

    public Registration createRegistration(RegistrationDto dto) {
        Registration registration = new Registration();
        registration.setName(dto.getName());
        registration.setEmail(dto.getEmail());
        registration.setMobile(dto.getMobile());
        return repository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        return repository.findAll();
    }

    public Optional<Registration> getRegistrationById(Long id) {
        return repository.findById(id);
    }

    public Registration updateRegistration(Long id, @Valid RegistrationDto dto) {
        Registration registration = repository.findById(id).orElseThrow(() -> 
                new RuntimeException("Registration not found with id: " + id));
        registration.setName(dto.getName());
        registration.setEmail(dto.getEmail());
        registration.setMobile(dto.getMobile());
        return repository.save(registration);
    }

    public void deleteRegistration(Long id) {
        repository.deleteById(id);
    }
}
