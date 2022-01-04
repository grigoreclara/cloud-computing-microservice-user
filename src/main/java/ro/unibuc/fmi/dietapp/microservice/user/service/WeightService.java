package ro.unibuc.fmi.dietapp.microservice.user.service;

import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.microservice.user.model.Weight;
import ro.unibuc.fmi.dietapp.microservice.user.repository.WeightRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeightService {
    private final WeightRepository repository;

    public WeightService(WeightRepository repository) {this.repository= repository;}

    public List<Weight> findAll() { return repository.findAll(); }

    public List<Weight> findByUserId(Long id){
        return repository.findByUserId(id);
    }

    public Weight findById(Long id){
        return repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("The weight measurement with this id doesn't exist in the database!")
        );
    }

    public Weight create(Weight weight){
        weight.setWeight_date(LocalDateTime.now());
        return repository.save(weight);
    }

    public Weight update(Weight weight){
        if(repository.existsById(weight.getId())){
            weight.setWeight_date(LocalDateTime.now());
            return repository.save(weight);
        } else {
            throw new EntityNotFoundException(String.format("There is no weight measurement with id=%s in the database!", weight.getId().toString()));
        }
    }
}
