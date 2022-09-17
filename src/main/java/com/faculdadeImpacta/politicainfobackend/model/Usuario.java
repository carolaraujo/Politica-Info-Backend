package com.faculdadeImpacta.politicainfobackend.model;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome", nullable = false)
    private String nome;


    @Column(name = "email", nullable = false)
    @Email
    private String email;

}
