package com.divina.pastelaria.repositorio;

import com.divina.pastelaria.entidades.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//METÓDO UTILIZADO PARA BUSCAR A ENTIDADE USUARIO NO BANCO DE DADOS
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String login);
}
