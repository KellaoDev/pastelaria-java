package com.divina.pastelaria.service;

import com.divina.pastelaria.entidades.roles.Role;
import com.divina.pastelaria.entidades.usuario.Usuario;
import com.divina.pastelaria.repositorio.RoleRepository;
import com.divina.pastelaria.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    //CONSULTAR O BANCO DE DADOS DO USUARIO
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //CRIAR USUARIO
    public void cadastrar(Usuario usuario) {
        if (this.usuarioRepository.findByCpf(usuario.getCpf()) != null)
            throw new DataIntegrityViolationException("Usuários já existente");

        Role role = this.roleRepository.findById(2L).get();

        List<Role> roles = new ArrayList<Role>();

        roles.add(role);

        usuario.setRoles(roles);

        usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));

        this.usuarioRepository.save(usuario);

    }

    //LISTAR USUARIOS
    public List<Usuario> listar() {
        return this.usuarioRepository.findAll();
    }

    //ATUALIZAR USUARIOS
    public Usuario atualizar(Usuario usuario) {

        Usuario usarioDb = this.usuarioRepository.findById(usuario.getId()).orElse(null);

        if (usuario != null) {
            usarioDb.setNome(usuario.getNome());
        }
        if (usuario != null) {
            usarioDb.setSenha(usuario.getSenha());
        }
        if (usuario != null) {
            usarioDb.setTelefone(usuario.getTelefone());
        }

        return usuarioRepository.save(usuario);
    }

    //BUSCAR ID DO USUARIO
    public Usuario obterPedidoPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    //EXCLUIR USUARIOS
    public void excluir(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByCpf(login);

        if (usuario == null) throw new UsernameNotFoundException("Usuário não existe.");

        return usuario;
    }
}
