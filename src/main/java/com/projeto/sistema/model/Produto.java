package com.projeto.sistema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="produtos")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Código de barras é obrigatório")
    private String codigoDeBarras;

    @NotBlank(message = "Unidade de medida é obrigatória")
    private String unidadeDeMedida;

    private double estoque;

    @PositiveOrZero(message = "Preço de custo não pode ser negativo")
    private double precoCusto;

    @PositiveOrZero(message = "Preço de venda não pode ser negativo")
    private double precoVenda;

    private double lucro;
    private double margemDeLucro;

}
