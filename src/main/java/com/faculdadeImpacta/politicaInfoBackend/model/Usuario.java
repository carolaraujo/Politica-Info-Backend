package com.faculdadeImpacta.politicaInfoBackend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message="{name.not.blank}")
    private String nome;


    @NotBlank(message="{email.not.blank}")
    @Email(message="{email.not.blank}")
    @Column
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

}
