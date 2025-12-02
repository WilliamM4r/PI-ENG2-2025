package com.br.pieng2.domain.service;

import com.br.pieng2.domain.dao.VeiculoDAO;
import com.br.pieng2.domain.model.Veiculo;

import java.util.List;

public class VeiculoService {

    private VeiculoDAO dao;

    public VeiculoService() {
        this.dao = new VeiculoDAO();
    }

    public void adicionarVeiculo(String placa, String marca, String modelo, int anoFabricacao, boolean veiculoAtivo) throws Exception {
        if (placa == null || placa.trim().isEmpty()) {
            throw new Exception("A placa não pode ser vazia.");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new Exception("A marca não pode ser vazia");
            }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new Exception("O modelo não pode ser vazio");
        }
        if (anoFabricacao < 1900 || anoFabricacao >2100) {
            throw new Exception("Ano de fabricação invalido");
        }

        for (Veiculo v : dao.listar()) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                throw new Exception("Já existe um veículo com essa placa.");
            }
        }

        Veiculo veiculo = new Veiculo(placa.trim(), marca.trim(), modelo.trim());
        dao.salvar(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return dao.listar();
    }

    public Veiculo buscarPorPlaca(String placa) throws Exception {
        if (placa == null || placa.isEmpty()) {
            throw new Exception("Informe uma placa válida.");
        }

        for (Veiculo v : dao.listar()) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }

        throw new Exception("Veículo não encontrado.");
    }

    public void atualizarVeiculo(Veiculo atualizado) throws Exception {
        if (atualizado.getPlaca() == null || atualizado.getPlaca().trim().isEmpty()) {
            throw new Exception("A placa não pode ser vazia.");
        }

        dao.atualizar(atualizado);
    }

    public void remover(String placa) throws Exception {
        if (placa == null || placa.isEmpty()) {
            throw new Exception("Informe uma placa para remover.");
        }

        dao.remover(Integer.parseInt(placa));
    }
}
