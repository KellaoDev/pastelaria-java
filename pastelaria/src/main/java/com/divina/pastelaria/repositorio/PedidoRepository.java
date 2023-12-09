package com.divina.pastelaria.repositorio;

import com.divina.pastelaria.entidades.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

//METÓDO UTILIZADO PARA BUSCAR A ENTIDADE PEDIDO NO BANCO DE DADOS
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
