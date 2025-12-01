package com.br.pieng2.domain.dao;

import com.br.pieng2.domain.model.Despesa;
import com.br.pieng2.domain.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class DespesaDAO extends BaseDAO<Despesa>{

    private final String ARQUIVO = "despesa.txt";

    private int gerarNovoId() {
        int maior = 0;

        for (Despesa td : listar()) {
            if (td.getIdTipoDespesa() > maior) {
                maior = td.getIdTipoDespesa();
            }
        }

        return maior + 1;
    }

    public void salvar(Despesa td) {
        td.setIdTipoDespesa(gerarNovoId());
        List<Despesa> lista = listar();
        lista.add(td);
        gravarArquivo(ARQUIVO, lista);
    }

    public List<Despesa> listar() {
        List<String> linhas = lerArquivo(ARQUIVO);
        List<Despesa> lista = new ArrayList<>();

        for (String l : linhas) {
            lista.add(Despesa.fromString(l));
        }
        return lista;
    }

    public Despesa buscar(int id) {
        for (Despesa td : listar()) {
            if (td.getIdTipoDespesa() == id)
                return td;
        }
        return null;
    }

    public void atualizar(Despesa atualizado) {
        List<Despesa> lista = listar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdTipoDespesa() == atualizado.getIdTipoDespesa()) {
                lista.set(i, atualizado);
                break;
            }
        }
        gravarArquivo(ARQUIVO, lista);
    }

    public void remover(int id) {
        List<Despesa> lista = listar();
        lista.removeIf(td -> td.getIdTipoDespesa() == id);
        gravarArquivo(ARQUIVO, lista);
    }
}
