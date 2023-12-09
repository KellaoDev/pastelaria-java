package com.divina.pastelaria.controller;

import com.divina.pastelaria.entidades.pastel.Pastel;
import com.divina.pastelaria.entidades.pedido.Pedido;
import com.divina.pastelaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    //Exibir Listar Pedidos
    @GetMapping("/listarPedidos")
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.listar());
        return "/pedidos/listarPedidos";
    }

    //Exibir Cadastrar Pedidos
    @GetMapping("/exibirCadastro")
    public String exibirCadastro(Model model) {
        Pastel pastel = new Pastel();
        model.addAttribute("pastel", pastel);
        return "/pedidos/cadastrarPedidos";
    }

    //Cadastrar Pedidos
    @PostMapping("/cadastrar")
    public String Cadastrar(Pastel pastel) {
        pedidoService.cadastrar(new Pedido(pastel));
        return "redirect:/menu";
    }

    //Exibir Atualizar Pedidos
    @GetMapping("/editar/{id}")
    public String exibirEditar(@PathVariable Long id, Model model) {
        Pastel pastel = pedidoService.obterPedidoPorId(id);
        model.addAttribute("pastel", pastel);
        return "/pedidos/editarPedido";
    }

    //Atualizar Pedidos
    @PostMapping("/editar")
    public String Alterar(Pastel pastel) {
        pedidoService.atualizar(pastel);
        return "redirect:/pedidos/listarPedidos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        pedidoService.excluir(id);
        return "redirect:/pedidos/listarPedidos";
    }
}
