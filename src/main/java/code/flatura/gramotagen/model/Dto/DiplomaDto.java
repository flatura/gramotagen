package code.flatura.gramotagen.model.Dto;

import java.time.LocalDate;
import java.util.UUID;

public class DiplomaDto {
    private final UUID id;
    private final String type;
    private final String status;
    private final String personName;
    private final String personMiddleName;
    private final String personSurname;
    private final String competitionTitle;
    private final String decree;
    private LocalDate competitionDate;

    public DiplomaDto(UUID id, String type, String status, String personName, String personMiddleName, String personSurname, String competitionTitle, LocalDate competitionDate, String decree) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.personName = personName;
        this.personMiddleName = personMiddleName;
        this.personSurname = personSurname;
        this.competitionTitle = competitionTitle;
        this.competitionDate = competitionDate;
        this.decree = decree;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getPersonMiddleName() {
        return personMiddleName;
    }

    public String getDecree() {
        return decree;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public String getCompetitionTitle() {
        return competitionTitle;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }
}