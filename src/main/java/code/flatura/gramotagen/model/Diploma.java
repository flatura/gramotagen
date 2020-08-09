package code.flatura.gramotagen.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "diploma")
public class Diploma {

    // Info about diploma
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "number")
    private Integer number;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "issued", nullable = false)
    private LocalDate issueDate;

    @Column(name = "created", nullable = false)
    private LocalDate createDate;

    @Column(name = "modified")
    private LocalDate dateModified;

    @Column(name = "printed_count")
    private Integer printedCount;

    // Info about competition
    @Column(name = "competition", nullable = false)
    private String competitionTitle;

    @Column(name = "discipline", nullable = false)
    private String competitionDiscipline;

    @Column(name = "competition_address", nullable = false)
    private String competitionBase;

    @Column(name = "competition_date", nullable = false)
    private LocalDate competitionDate;

    //Info about person
    @Column(name = "name", nullable = false)
    private String personName;

    @Column(name = "surname", nullable = false)
    private String personSurname;

    @Column(name = "middle_name", nullable = false)
    private String personMiddleName;

    @Column(name = "class", nullable = false)
    private String personClass;

    @Column(name = "birth_date", nullable = false)
    private LocalDate personBirthDate;

    @Column(name = "school")
    private String school;

    @Column(name = "place")
    private String place;

    public Diploma() {
    }

    public Diploma(String serial, Integer number, String type, LocalDate issueDate, LocalDate createDate, LocalDate dateModified, Integer printedCount, String competitionTitle, String competitionDiscipline, String competitionBase, LocalDate competitionDate, String personName, String personSurname, String personMiddleName, String personClass, LocalDate personBirthDate, String school, String place) {
        this.serial = serial;
        this.number = number;
        this.type = type;
        this.issueDate = issueDate;
        this.createDate = createDate;
        this.dateModified = dateModified;
        this.printedCount = printedCount;
        this.competitionTitle = competitionTitle;
        this.competitionDiscipline = competitionDiscipline;
        this.competitionBase = competitionBase;
        this.competitionDate = competitionDate;
        this.personName = personName;
        this.personSurname = personSurname;
        this.personMiddleName = personMiddleName;
        this.personClass = personClass;
        this.personBirthDate = personBirthDate;
        this.school = school;
        this.place = place;
    }

    public UUID getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public Integer getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public Integer getPrintedCount() {
        return printedCount;
    }

    public String getCompetitionTitle() {
        return competitionTitle;
    }

    public String getCompetitionDiscipline() {
        return competitionDiscipline;
    }

    public String getCompetitionBase() {
        return competitionBase;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public String getPersonMiddleName() {
        return personMiddleName;
    }

    public String getPersonClass() {
        return personClass;
    }

    public LocalDate getPersonBirthDate() {
        return personBirthDate;
    }

    public String getSchool() {
        return school;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "Diploma{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", issueDate=" + issueDate +
                ", createDate=" + createDate +
                ", dateModified=" + dateModified +
                ", printedCount=" + printedCount +
                ", competitionTitle='" + competitionTitle + '\'' +
                ", competitionDiscipline='" + competitionDiscipline + '\'' +
                ", competitionBase='" + competitionBase + '\'' +
                ", competitionDate=" + competitionDate +
                ", personName='" + personName + '\'' +
                ", personSurname='" + personSurname + '\'' +
                ", personMiddleName='" + personMiddleName + '\'' +
                ", personClass='" + personClass + '\'' +
                ", personBirthDate=" + personBirthDate +
                ", school='" + school + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}