package code.flatura.gramotagen.service;

import code.flatura.gramotagen.model.Diploma;
import code.flatura.gramotagen.model.Dto.DiplomaDto;
import code.flatura.gramotagen.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DiplomaService {
    private DiplomaRepository diplomaRepository;

    public DiplomaService() {
    }

    @Autowired
    public DiplomaService(DiplomaRepository diplomaRepository) {
        this.diplomaRepository = diplomaRepository;
    }

    public List<DiplomaDto> getAll() {
        return diplomaRepository.findAll()
                .stream()
                .map(d -> new DiplomaDto(
                        d.getId(),
                        d.getType(),
                        d.getStatus(),
                        d.getPersonName(),
                        d.getPersonMiddleName(),
                        d.getPersonSurname(),
                        d.getCompetitionTheme(),
                        d.getCompetitionDate(),
                        d.getDecree()))
                .collect(Collectors.toList());
    }

    public List<DiplomaDto> findByPersonalInfoWithBirthday(String name, String middleName, String surname, LocalDate birthDate) {
        return diplomaRepository.findAllByPersonNameAndPersonMiddleNameAndPersonSurnameAndPersonBirthDate(name, middleName, surname, birthDate)
                .stream()
                .map(d -> new DiplomaDto(
                        d.getId(),
                        d.getType(),
                        d.getStatus(),
                        d.getPersonName(),
                        d.getPersonMiddleName(),
                        d.getPersonSurname(),
                        d.getCompetitionTheme(),
                        d.getCompetitionDate(),
                        d.getDecree())
        )
                .collect(Collectors.toList());
    }

    public List<DiplomaDto> findByPersonalInfo(String name, String middleName, String surname) {
        return diplomaRepository.findAllByPersonNameAndPersonMiddleNameAndPersonSurname(name, middleName, surname)
                .stream()
                .map(d -> new DiplomaDto(
                        d.getId(),
                        d.getType(),
                        d.getStatus(),
                        d.getPersonName(),
                        d.getPersonMiddleName(),
                        d.getPersonSurname(),
                        d.getCompetitionTheme(),
                        d.getCompetitionDate(),
                        d.getDecree()))
                .collect(Collectors.toList());
    }

    public DiplomaDto getById(UUID id) {
        Optional<Diploma> optional = diplomaRepository.findById(id);
        if(optional.isPresent()) {
                final Diploma d = optional.get();
                return new DiplomaDto(
                        d.getId(),
                        d.getType(),
                        d.getStatus(),
                        d.getPersonName(),
                        d.getPersonMiddleName(),
                        d.getPersonSurname(),
                        d.getCompetitionTheme(),
                        d.getCompetitionDate(),
                        d.getDecree());
        }
        return null;
    }

    @Transactional
    public void incrementPrintCounter(UUID id) {
        // Ищем запись в БД, если существует, то запускаем инкремент счетчика и сохраняем
        diplomaRepository.findById(id).ifPresent(d -> diplomaRepository.save(d.incrementPrintedCount()));
    }

    public int addDiploma(
            String competitionThemeShort,
            String competitionTheme,
            String issueDateStr,
            String type,
            String discipline,
            String name,
            String middleName,
            String surName,
            String status) {
        LocalDate issueDate = null;
        try {
            issueDate = LocalDate.parse(issueDateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        Diploma diploma = new Diploma("",
                0,
                type,
                competitionThemeShort,
                competitionTheme,
                discipline,
                null,
                name,
                middleName,
                surName,
                null,
                null,
                null,
                null,
                null,
                null,
                status,
                issueDate,
                LocalDate.now(),
                null,
                0,
                null,
                "default");
        diplomaRepository.save(diploma);
        return 0;
    }
}
