package code.flatura.gramotagen.model.Dto;

import java.time.LocalDate;

public class DiplomaDto {

    final private String type;
    final private String place;
    final private String personName;
    final private String personSurname;
    final private String competitionTitle;
    final private LocalDate competitionDate;

    public DiplomaDto(String type, String place, String personName, String personSurname, String competitionTitle, LocalDate competitionDate) {
        this.type = type;
        this.place = place;
        this.personName = personName;
        this.personSurname = personSurname;
        this.competitionTitle = competitionTitle;
        this.competitionDate = competitionDate;
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
