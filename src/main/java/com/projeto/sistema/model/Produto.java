package com.projeto.sistema.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="produtos")
@Getter
@Setter
public class Produto {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String codigoDeBarras;
    private String unidadeDeMedida;
    private double estoque;//pq o estoque seria double e não int
    private double precoCusto;
    private double precoVenda;
    private double lucro;
    private double margemDeLucro;//margemLucro




}
