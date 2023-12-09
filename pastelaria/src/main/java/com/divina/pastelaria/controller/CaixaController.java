package com.divina.pastelaria.controller;

import com.divina.pastelaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaixaController {

    @Autowired
    private PedidoService pedidoService;

    //Exibir Caixa
    @GetMapping("/caixa")
    public String listar(Model model) {
        Object[] dados = pedidoService.exibirDadosDoCaixa();

        model.addAttribute("valorTotal", dados[0]);
        model.addAttribute("qtdPasteis", dados[1]);

        return "/caixa/caixa";
    }

}
