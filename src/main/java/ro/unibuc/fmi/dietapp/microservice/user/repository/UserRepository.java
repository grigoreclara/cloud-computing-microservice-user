package ro.unibuc.fmi.dietapp.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unibuc.fmi.dietapp.microservice.user.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByCityId(Long id);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
