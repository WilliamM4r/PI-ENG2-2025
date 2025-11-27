package com.br.pieng2.domain.dao;

import com.br.pieng2.domain.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO extends BaseDAO<Veiculo>{

    private final String ARQUIVO = "veiculos.txt";

    public void salvar(Veiculo v) {
        List<Veiculo> lista = listar();
        lista.add(v);
        gravarArquivo(ARQUIVO, lista);
    }

    public List<Veiculo> listar() {
        List<String> linhas = lerArquivo(ARQUIVO);
        List<Veiculo> lista = new ArrayList<>();
        for (String l : linhas) {
            lista.add(Veiculo.fromString(l));
        }
        return lista;
    }

    public Veiculo buscar(int id) {
        for (Veiculo v : listar()) {
            if (v.getIdVeiculo() == id)
                return v;
        }
        return null;
    }

    public void atualizar(Veiculo vAtualizado) {
        List<Veiculo> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdVeiculo() == vAtualizado.getIdVeiculo()) {
                lista.set(i, vAtualizado);
                break;
            }
        }
        gravarArquivo(ARQUIVO, lista);
    }

    public void remover(int id) {
        List<Veiculo> lista = listar();
        lista.removeIf(v -> v.getIdVeiculo() == id);
        gravarArquivo(ARQUIVO, lista);
    }
}
