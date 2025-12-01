package com.br.pieng2.domain.service;

import com.br.pieng2.domain.dao.DespesaDAO;
import com.br.pieng2.domain.model.Despesa;

import java.util.List;

public class DespesaService {

    private DespesaDAO dao;

    public DespesaService() {
        this.dao = new DespesaDAO();
    }

    public void adicionarTipoDespesa(String nome) throws Exception {

        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("O nome da despesa não pode ser vazio.");
        }

        Despesa tipo = new Despesa(nome.trim());
        dao.salvar(tipo);
    }

    public List<Despesa> listar() {
        return dao.listar();
    }

    public void remover(String nome) throws Exception {

        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome inválido para remoção.");
        }

        dao.remover(nome.trim());
    }
}
