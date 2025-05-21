package com.projeto.sistema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Entity
@Table(name="clientes")
@Getter
@Setter
public class Cliente {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private int numero;//de endereco
    private String bairro;
    private String email;

    @ManyToOne
    private Cidade cidade;
}
