package com.br.pieng2.domain.service;

import com.br.pieng2.domain.dao.MovimentacaoDAO;
import com.br.pieng2.domain.model.Movimentacao;

import java.util.List;
import java.time.LocalDate;

public class MovimentacaoService {

    private MovimentacaoDAO dao;

    public MovimentacaoService() {
        this.dao = new MovimentacaoDAO();
    }

    public void registrarMovimentacao(String tipo, double valor, LocalDate data) throws Exception {

        if (valor <= 0) {
            throw new Exception("O valor deve ser maior que zero.");
        }

        if (data == null) {
            throw new Exception("Data inválida.");
        }

        Movimentacao mov = new Movimentacao(tipo, valor, data);
        dao.salvar(mov);
    }

    public List<Movimentacao> listar() {
        return dao.listar();
    }

    public double calcularTotal() {
        return dao.listar()
                .stream()
                .mapToDouble(Movimentacao::getValor)
                .sum();
    }
}
