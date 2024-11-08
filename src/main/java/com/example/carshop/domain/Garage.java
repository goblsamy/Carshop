package com.example.carshop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "garage")
@NoArgsConstructor
@Data
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "garage_capacity")
    private Integer garageCapacity;

    @Column(name = "garage_name")
    private String garageName;

    @OneToMany(mappedBy = "garage")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Car> cars;
}
