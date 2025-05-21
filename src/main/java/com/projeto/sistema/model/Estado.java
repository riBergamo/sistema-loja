package com.projeto.sistema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name="estados")
@Getter
@Setter
public class Estado implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sigla;
}
