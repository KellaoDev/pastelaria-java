package com.divina.pastelaria.service;

import com.divina.pastelaria.entidades.pastel.Pastel;
import com.divina.pastelaria.entidades.pedido.Pedido;
import com.divina.pastelaria.repositorio.PastelRepository;
import com.divina.pastelaria.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    //CONSULTAR O BANCO DE DADOS DO PEDIDO
    @Autowired
    private PedidoRepository pedidoRepository;

    //CONSULTAR O BANCO DE DADOS DO PASTEL
    @Autowired
    private PastelRepository pastelRepository;

    //CRIAR PEDIDO
    public void cadastrar(Pedido pedido) {
        this.pedidoRepository.save(pedido);
    }

    //LISTAR PEDIDOS
    public List<Pedido> listar() {
        return this.pedidoRepository.findAll();
    }

    //ATUALIZAR PEDIDOS
    public Pastel atualizar(Pastel pastel) {

        Pastel pastelDb = this.pastelRepository.findById(pastel.getId()).orElse(null);

        assert pastelDb != null;

        if (pastel != null) {
            pastelDb.setPicante(pastel.getPicante());
        }
        if (pastel != null) {
            pastelDb.setRecheios(pastel.getRecheios());
        }

        return pastelRepository.save(pastel);
    }

    //BUSCAR ID DO PEDIDO
    public Pastel obterPedidoPorId(Long id) {
        return pastelRepository.findById(id).get();
    }

    //EXCLUIR PEDIDOS
    public void excluir(Long id) {
        this.pedidoRepository.deleteById(id);
    }

    //UTILIZADO PARA DEFINIR OS VALORES NA VIEW DE CAIXA
    public Object[] exibirDadosDoCaixa() {
        List<Pedido> pedidos = this.pedidoRepository.findAll();

        Double valorTotal = pedidos.stream()
                .mapToDouble(pedido -> pedido.getPastel().getPreco())
                .sum();
        int qtdPasteis = pedidos.size();

        Object[] dados = {valorTotal, qtdPasteis};

        return dados;
    }
}
