package ro.unibuc.fmi.dietapp.microservice.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.fmi.dietapp.microservice.user.dto.RegistrationDto;
import ro.unibuc.fmi.dietapp.microservice.user.mapper.RegistrationMapper;
import ro.unibuc.fmi.dietapp.microservice.user.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService service;
    private final RegistrationMapper mapper;

    public RegistrationController(RegistrationService service, RegistrationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RegistrationDto request){
        service.create(mapper.toEntity(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
