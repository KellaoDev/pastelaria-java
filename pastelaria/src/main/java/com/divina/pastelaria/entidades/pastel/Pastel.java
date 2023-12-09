package com.divina.pastelaria.entidades.pastel;

import com.divina.pastelaria.entidades.recheio.Recheio;
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
public class Pastel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double preco;
    private Boolean picante = false;
    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Recheio recheios;

    public Pastel(Recheio recheio) {
        this.recheios = recheio;
    }
}
