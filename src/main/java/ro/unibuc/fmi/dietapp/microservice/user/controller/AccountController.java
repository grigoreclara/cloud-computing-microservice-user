package ro.unibuc.fmi.dietapp.microservice.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.fmi.dietapp.microservice.user.dto.AccountDto;
import ro.unibuc.fmi.dietapp.microservice.user.exception.BadRequestException;
import ro.unibuc.fmi.dietapp.microservice.user.mapper.AccountMapper;
import ro.unibuc.fmi.dietapp.microservice.user.model.Account;
import ro.unibuc.fmi.dietapp.microservice.user.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService service;
    private final AccountMapper mapper;

    public AccountController(AccountService service, AccountMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable Long id){
        Account response = service.findById(id);
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable Long id, @RequestBody AccountDto request){
        if(!id.equals(request.getId())){
            throw new BadRequestException("The path variable doesn't match the request body id!");
        }

        Account response = service.update(mapper.toEntity(request));
        return new ResponseEntity<>(mapper.toDto(response), HttpStatus.OK);
    }
}
