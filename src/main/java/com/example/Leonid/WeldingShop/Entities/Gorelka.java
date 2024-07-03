package com.example.Leonid.WeldingShop.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "gorelka")
@Component
public class Gorelka {


    private int length = 5;

    public void showLength(){
        System.out.println(length);
    }
}
