package code.flatura.gramotagen.model.Dto;

import java.time.LocalDate;

public class DiplomaDto {
    private final Integer id;
    private final String type;
    private final String place;
    private final String personName;
    private final String personSurname;
    private final String competitionTitle;
    private LocalDate competitionDate;

    public DiplomaDto(Integer id, String type, String place, String personName, String personSurname, String competitionTitle, LocalDate competitionDate) {
        this.id = id;
        this.type = type;
        this.place = place;
        this.personName = personName;
        this.personSurname = personSurname;
        this.competitionTitle = competitionTitle;
        this.competitionDate = competitionDate;
    }

    public Integer getId() {
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
