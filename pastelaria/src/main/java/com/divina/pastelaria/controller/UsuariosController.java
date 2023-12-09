package com.divina.pastelaria.controller;

import com.divina.pastelaria.entidades.usuario.Usuario;
import com.divina.pastelaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    private UsuarioService usuarioService;

    //Exibir Listar Funcionarios
    @GetMapping("/listarFuncionarios")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "/usuarios/listarFuncionarios";
    }

    //Exibir Cadastrar Usuarios
    @GetMapping("/exibirCadastro")
    public String exibirCadastro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuarios/cadastrarFuncionarios";
    }

    @PostMapping("/cadastrar")
    public String Cadastrar(Usuario usuario) {
        usuarioService.cadastrar(usuario);
        return "redirect:/usuarios/listarFuncionarios";
    }

    @GetMapping("/editar/{id}")
    public String exibirEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.obterPedidoPorId(id);
        model.addAttribute("usuario", usuario);
        return "/usuarios/editarFuncionario";
    }

    @PostMapping("/editar")
    public String alterar(Usuario usuario) {
        usuarioService.atualizar(usuario);
        return "redirect:/usuarios/listarFuncionarios";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return "redirect:/usuarios/listarFuncionarios";
    }
}
