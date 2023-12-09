package com.divina.pastelaria.repositorio;

import com.divina.pastelaria.entidades.pastel.Pastel;
import org.springframework.data.jpa.repository.JpaRepository;

//METÓDO UTILIZADO PARA BUSCAR A ENTIDADE PASTEL NO BANCO DE DADOS
public interface PastelRepository extends JpaRepository<Pastel, Long> {

}
