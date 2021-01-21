package code.flatura.gramotagen.repository;

import code.flatura.gramotagen.model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Integer> {

    @Query
    List<Diploma> findAllByPersonNameAndPersonMiddleNameAndPersonSurnameAndPersonBirthDate(String name, String middleName, String surName, LocalDate birthDate);

    @Query("SELECT d FROM Diploma d WHERE d.id = :id")
    Optional<Diploma> findById(UUID id);

    @Query
    List<Diploma> findAllByPersonNameAndPersonMiddleNameAndPersonSurname(String name, String middleName, String surName);
}
