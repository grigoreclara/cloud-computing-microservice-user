package ro.unibuc.fmi.dietapp.microservice.user.service;

import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.microservice.user.exception.EntityNotFoundException;
import ro.unibuc.fmi.dietapp.microservice.user.model.Account;

import ro.unibuc.fmi.dietapp.microservice.user.repository.AccountRepository;


import java.util.List;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {this.repository = repository;}

    public Account findById(Long id){
        return repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("The account with this id doesn't exist in the database!")
        );
    }

    public Account create(Account account){
        return repository.save(account);
    }

    public Account update(Account account){
        if(repository.existsById(account.getId())){
            return repository.save(account);
        } else {
            throw new EntityNotFoundException(String.format("There is no account with id=%s in the database!", account.getId().toString()));
        }
    }
}
