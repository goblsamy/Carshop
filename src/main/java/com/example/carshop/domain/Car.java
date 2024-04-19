package com.example.carshop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "car")
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "car_type")
    private CarType carType;

    @Column(name = "car_name")
    private String carName;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

}
