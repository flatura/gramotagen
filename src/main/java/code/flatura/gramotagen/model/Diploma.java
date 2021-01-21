package code.flatura.gramotagen.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "diploma")
public class Diploma {

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

    @Column(name = "competition_theme_short", nullable = false)
    private String competitionThemeShort;

    @Column(name = "competition_theme", nullable = false)
    private String competitionTheme;

    @Column(name = "discipline", nullable = false)
    private String competitionDiscipline;

    @Column(name = "competition_date")
    private LocalDate competitionDate;

    //Info about person
    @Column(name = "name", nullable = false)
    private String personName;

    @Column(name = "middle_name")
    private String personMiddleName;

    @Column(name = "surname", nullable = false)
    private String personSurname;

    @Column(name = "birth_date")
    private LocalDate personBirthDate;

    @Column(name = "class")
    private String personClass;

    @Column(name = "actual_class")
    private String personActualClass;

    @Column(name = "school")
    private String school;

    @Column(name = "points")
    private Integer points;

    @Column(name = "place")
    private String place;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "issued", nullable = false)
    private LocalDate issueDate;

    @Column(name = "created", nullable = false)
    private LocalDate createDate;

    @Column(name = "modified")
    private LocalDate modifiedDate;

    @Column(name = "printed_count")
    private Integer printedCount = 0;

    @Column(name = "decree")
    private String decree;

    @Column(name = "template")
    private String template;

    public Diploma() {
    }

    public Diploma(String serial, Integer number, String type, String competitionThemeShort, String competitionTheme, String competitionDiscipline, LocalDate competitionDate, String personName, String personMiddleName, String personSurname, LocalDate personBirthDate, String personClass, String personActualClass, String school, Integer points, String place, String status, LocalDate issueDate, LocalDate createDate, LocalDate modifiedDate, Integer printedCount, String decree, String template) {
        this.serial = serial;
        this.number = number;
        this.type = type;
        this.competitionThemeShort = competitionThemeShort;
        this.competitionTheme = competitionTheme;
        this.competitionDiscipline = competitionDiscipline;
        this.competitionDate = competitionDate;
        this.personName = personName;
        this.personMiddleName = personMiddleName;
        this.personSurname = personSurname;
        this.personBirthDate = personBirthDate;
        this.personClass = personClass;
        this.personActualClass = personActualClass;
        this.school = school;
        this.points = points;
        this.place = place;
        this.status = status;
        this.issueDate = issueDate;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.printedCount = printedCount;
        this.decree = decree;
        this.template = template;
    }

    public UUID getId() {
        return id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompetitionThemeShort() {
        return competitionThemeShort;
    }

    public void setCompetitionThemeShort(String competitionThemeShort) {
        this.competitionThemeShort = competitionThemeShort;
    }

    public String getCompetitionTheme() {
        return competitionTheme;
    }

    public void setCompetitionTheme(String competitionTheme) {
        this.competitionTheme = competitionTheme;
    }

    public String getCompetitionDiscipline() {
        return competitionDiscipline;
    }

    public void setCompetitionDiscipline(String competitionDiscipline) {
        this.competitionDiscipline = competitionDiscipline;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(LocalDate competitionDate) {
        this.competitionDate = competitionDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonMiddleName() {
        return personMiddleName;
    }

    public void setPersonMiddleName(String personMiddleName) {
        this.personMiddleName = personMiddleName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public LocalDate getPersonBirthDate() {
        return personBirthDate;
    }

    public void setPersonBirthDate(LocalDate personBirthDate) {
        this.personBirthDate = personBirthDate;
    }

    public String getPersonClass() {
        return personClass;
    }

    public void setPersonClass(String personClass) {
        this.personClass = personClass;
    }

    public String getPersonActualClass() {
        return personActualClass;
    }

    public void setPersonActualClass(String personActualClass) {
        this.personActualClass = personActualClass;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getPrintedCount() {
        return printedCount;
    }

    public void setPrintedCount(Integer printedCount) {
        this.printedCount = printedCount;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDecree() {
        return decree;
    }

    public void setDecree(String decree) {
        this.decree = decree;
    }

    @Override
    public String toString() {
        return "Diploma{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", competitionThemeShort='" + competitionThemeShort + '\'' +
                ", competitionTheme='" + competitionTheme + '\'' +
                ", competitionDiscipline='" + competitionDiscipline + '\'' +
                ", competitionDate=" + competitionDate +
                ", personName='" + personName + '\'' +
                ", personMiddleName='" + personMiddleName + '\'' +
                ", personSurname='" + personSurname + '\'' +
                ", personBirthDate=" + personBirthDate +
                ", personClass='" + personClass + '\'' +
                ", personActualClass='" + personActualClass + '\'' +
                ", school='" + school + '\'' +
                ", points=" + points +
                ", place='" + place + '\'' +
                ", status='" + status + '\'' +
                ", issueDate=" + issueDate +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                ", printedCount=" + printedCount +
                ", template='" + template + '\'' +
                '}';
    }

    public Diploma incrementPrintedCount() {
        System.out.println("Old printedCount = " + this.printedCount + ". Incrementing");
        this.printedCount++;
        System.out.println("Now it's " + this.printedCount);
        return this;
    }
}