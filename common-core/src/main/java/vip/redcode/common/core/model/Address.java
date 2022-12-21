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
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "address_to_people")
    private List<AddressToPeople> addressToPeople;

    private String country; // Страна

    private String region; // Регион

    private String locality; // Район

    private String city; // Город

    private String neighborhood; // Микрорайон

    private String street; // Улица

    private String house; // Дом

    private String structure; // Строение

    private String entrance; // Подъезд

    private String floor; // Этаж

    private String flat; // Квартира
}
