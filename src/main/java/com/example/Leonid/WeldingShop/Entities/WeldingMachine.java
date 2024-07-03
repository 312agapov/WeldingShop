package com.example.Leonid.WeldingShop.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "weldings")
@Component
public class WeldingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private int price;

    @Embedded
    @Autowired
    private Gorelka gorelka;
}
