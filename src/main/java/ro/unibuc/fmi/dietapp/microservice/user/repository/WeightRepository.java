package ro.unibuc.fmi.dietapp.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.unibuc.fmi.dietapp.microservice.user.model.Weight;

import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight,Long> {
    List<Weight> findByUserId(Long id);
}
