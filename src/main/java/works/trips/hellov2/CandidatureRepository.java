package works.trips.hellov2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CandidatureRepository extends JpaRepository<Candidature, Long>{
    List<Candidature> findByusers_id(@Param("user_id") Integer integer); 

}
