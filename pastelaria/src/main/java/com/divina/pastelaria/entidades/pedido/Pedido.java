package com.divina.pastelaria.entidades.pedido;

import com.divina.pastelaria.entidades.pastel.Pastel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Pastel pastel;

    public Pedido(Pastel pastel) {
        this.setPastel(pastel);
    }
}
