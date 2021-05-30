package com.rsjavasolutions.cache.model;

import lombok.*;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Setter(AccessLevel.NONE)
    private String uuid;
    private String brand;
    private String model;

    public CarEntity(String brand, String model) {
        this.uuid = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
    }
}

