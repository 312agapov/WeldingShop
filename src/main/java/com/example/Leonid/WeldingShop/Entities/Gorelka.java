package com.example.Leonid.WeldingShop.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "gorelka")
public class Gorelka {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int length;

    public void showLength(){
        System.out.println(length);
    }
}
