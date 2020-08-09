package code.flatura.gramotagen.model.Dto;

import java.time.LocalDate;
import java.util.UUID;

public class DiplomaDto {
    private final UUID id;
    private final String type;
    private final String place;
    private final String personName;
    private final String personSurname;
    private final String competitionTitle;
    private LocalDate competitionDate;

    public DiplomaDto(UUID id, String type, String place, String personName, String personSurname, String competitionTitle, LocalDate competitionDate) {
        this.id = id;
        this.type = type;
        this.place = place;
        this.personName = personName;
        this.personSurname = personSurname;
        this.competitionTitle = competitionTitle;
        this.competitionDate = competitionDate;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPlace() {
        return place;
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
