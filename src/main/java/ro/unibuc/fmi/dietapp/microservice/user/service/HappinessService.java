package ro.unibuc.fmi.dietapp.microservice.user.service;

import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.microservice.user.exception.EntityNotFoundException;
import ro.unibuc.fmi.dietapp.microservice.user.model.Happiness;
import ro.unibuc.fmi.dietapp.microservice.user.repository.HappinessRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HappinessService {
    private final HappinessRepository repository;

    public HappinessService(HappinessRepository repository) { this.repository = repository;}

    public List <Happiness> findAll(){ return repository.findAll(); }

    public List<Happiness> findByUserId(Long id){
        return  repository.findByUserId(id);
    }

    public Happiness findById(Long id){
        return repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("The happiness level  with this id doesn't exist in the database!")
        );
    }

    public Happiness create(Happiness happiness){
        happiness.setHappiness_date(LocalDateTime.now());
        return repository.save(happiness);
    }

    public Happiness update(Happiness happiness){
        if(repository.existsById(happiness.getId())){
            happiness.setHappiness_date(LocalDateTime.now());
            return repository.save(happiness);
        } else {
            throw new EntityNotFoundException(String.format("There is no happiness measurement with id=%s in the database!", happiness.getId().toString()));
        }
    }
}