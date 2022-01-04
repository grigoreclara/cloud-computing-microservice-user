package ro.unibuc.fmi.dietapp.microservice.user.service;

import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.microservice.user.exception.EntityNotFoundException;
import ro.unibuc.fmi.dietapp.microservice.user.model.City;

import ro.unibuc.fmi.dietapp.microservice.user.repository.CityRepository;

import java.util.List;

@Service
public class CityService {
    private final CityRepository repository;

    public CityService(CityRepository repository) {this.repository = repository;}

    public List<City> findAll() {return repository.findAll();}

    public List<City> findByCountry(Long id) { return repository.findByCountryId(id);}

    public City findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("The city with this id doesn't exist in the database!")
        );
    }
}
