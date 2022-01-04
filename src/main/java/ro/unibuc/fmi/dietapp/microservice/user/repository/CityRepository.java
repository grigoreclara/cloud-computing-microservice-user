package ro.unibuc.fmi.dietapp.microservice.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unibuc.fmi.dietapp.microservice.user.model.City;

import java.util.Currency;
import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByCountryId(Long id);
}
