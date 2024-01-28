package com.example.bankapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Compte")
public class CompteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idcompte")
    private int id;
    public String code;
    private Double solde;
    private Date date;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="idclient")
    private ClientEntity clientEntity;
}
