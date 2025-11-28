package com.br.pieng2.domain.dao;

import com.br.pieng2.domain.model.Movimentacao;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO extends BaseDAO<Movimentacao>{

    private final String ARQUIVO = "movimentacao.txt";

    public void salvar(Movimentacao m) {
        List<Movimentacao> lista = listar();
        lista.add(m);
        gravarArquivo(ARQUIVO, lista);
    }

    public List<Movimentacao> listar() {
        List<String> linhas = lerArquivo(ARQUIVO);
        List<Movimentacao> lista = new ArrayList<>();

        for (String l : linhas) {
            lista.add(Movimentacao.fromString(l));
        }
        return lista;
    }

    public Movimentacao buscar(int id) {
        for (Movimentacao m : listar()) {
            if (m.getIdMovimentacao() == id)
                return m;
        }
        return null;
    }

    public void atualizar(Movimentacao atualizado) {
        List<Movimentacao> lista = listar();

        for (int i = 0 ; i < lista.size(); i++) {
            if (lista.get(i).getIdMovimentacao() == atualizado.getIdMovimentacao()) {
                lista.set(i, atualizado);
                break;
            }
        }
        gravarArquivo(ARQUIVO, lista);
    }

    public  void remover(int id) {
        List<Movimentacao> lista = listar();
        lista.removeIf(m -> m.getIdMovimentacao() == id);
        gravarArquivo(ARQUIVO, lista);
    }
}
