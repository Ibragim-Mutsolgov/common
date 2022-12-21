package vip.redcode.common.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "first_name")
    private String firstName; // Фамилия

    @Column(name = "last_name")
    private String lastName; // Имя

    @Column(name = "middle_name")
    private String middleName; // Отчество

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate; // Дата рождения

    private Integer gender; // Пол

    private Integer height; // Вес

    private Integer weight; // Рост

    @Column(name = "cloth_size")
    private Integer clothSize; // Размер одежды

    @Column(name = "foot_size")
    private Integer footSize; // Размер ноги

    private Timestamp added; // Дата добавления

    private Long inn; // ИНН

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport; // Список паспортов

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policy_id", referencedColumnName = "id")
    private Policy policy; // Список полюсов

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "snils_id", referencedColumnName = "id")
    private Snils snils;

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "address_to_people")
    private List<AddressToPeople> addressToPeople; // Список адресов
}
