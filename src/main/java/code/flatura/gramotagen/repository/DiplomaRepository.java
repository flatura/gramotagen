package code.flatura.gramotagen.repository;

import code.flatura.gramotagen.model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Integer> {

}
