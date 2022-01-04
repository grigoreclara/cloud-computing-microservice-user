package ro.unibuc.fmi.dietapp.microservice.user.service;

import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.microservice.user.exception.EntityNotFoundException;
import ro.unibuc.fmi.dietapp.microservice.user.model.User;
import ro.unibuc.fmi.dietapp.microservice.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private  final UserRepository repository;

    public UserService(UserRepository userRepository) { this.repository=userRepository; }

    public List<User> findAll() {return repository.findAll();}

    public List<User> findByCityId(Long id) { return repository.findByCityId(id); }

    public boolean existsByUsername(String username) { return repository.existsByUsername(username); }

    public User findById(Long userid) {
        return repository.findById(userid).orElseThrow(
                () -> new EntityNotFoundException("The user with this id doesn't exist in the database!")
        );
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("The user with this username doesn't exist in the database!")
        );
    }

    public User create(User user){
        return repository.save(user);
    }

    public User update(User user){
        if(repository.existsById(user.getId())){
            return repository.save(user);
        } else {
            throw new EntityNotFoundException(String.format("There is no user with id=%s in the database!", user.getId().toString()));
        }
    }
}
