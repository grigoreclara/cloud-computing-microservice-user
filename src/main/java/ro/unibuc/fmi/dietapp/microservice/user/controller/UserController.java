package ro.unibuc.fmi.dietapp.microservice.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.fmi.dietapp.microservice.user.dto.UserDto;
import ro.unibuc.fmi.dietapp.microservice.user.exception.BadRequestException;
import ro.unibuc.fmi.dietapp.microservice.user.mapper.UserMapper;
import ro.unibuc.fmi.dietapp.microservice.user.model.User;
import ro.unibuc.fmi.dietapp.microservice.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserMapper mapper, UserService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> response = service.findAll();
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<List<UserDto>> findByCity(@RequestParam Long id){
        List<User> response = service.findByCityId(id);
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        User response = service.findById(id);
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<UserDto> findByEmail(@RequestParam String request){
        User response = service.findByUsername(request);
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto request){
        if(!id.equals(request.getId())) {
            throw new BadRequestException("The path variable doesn't match the request body id!");
        }

        User response = service.update(mapper.toEntity(request));
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }
}
