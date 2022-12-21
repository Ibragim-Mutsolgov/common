package vip.redcode.common.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Temporal(TemporalType.DATE)
    private Date date; // Дата рождения

    private int gender; // Пол

    @Column(name = "place_birth")
    private String placeBirth; // Место рождения

    @Column(name = "passport_series")
    private Long passportSeries; // Паспорт - серия

    @Column(name = "passport_number")
    private Long passportNumber; // Паспорт - номер

    @Column(name = "passport_issue")
    private String passportIssue; // Паспорт выдан

    @Temporal(TemporalType.DATE)
    @Column(name = "date_issue")
    private Date dateIssue; // Дата выдачи

    @Column(name = "department_code")
    private String departmentCode; // Код подразделения
}
