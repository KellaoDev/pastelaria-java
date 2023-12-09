package com.divina.pastelaria.entidades.recheio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recheio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean presunto = false;
    private Boolean queijo = false;
    private Boolean frango = false;
    private Boolean carneSeca = false;
    private Boolean mussarela = false;
    private Boolean catupiry = false;
    private Boolean bacon = false;
    private Boolean cheddar = false;
    private Boolean palmito = false;
    private Boolean azeitona = false;
    private Boolean barbecue = false;
    private Boolean pepperoni = false;

}

