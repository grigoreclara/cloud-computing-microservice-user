package ro.unibuc.fmi.dietapp.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unibuc.fmi.dietapp.microservice.user.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
