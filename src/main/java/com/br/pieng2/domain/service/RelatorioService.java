package com.br.pieng2.domain.service;

import com.br.pieng2.domain.model.Movimentacao;
import com.br.pieng2.domain.model.Veiculo;
import com.br.pieng2.domain.model.Despesa;

import com.br.pieng2.domain.dao.DespesaDAO;
import com.br.pieng2.domain.dao.MovimentacaoDAO;
import com.br.pieng2.domain.dao.VeiculoDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RelatorioService {

    private MovimentacaoDAO movimentacaoDAO;
    private VeiculoDAO veiculoDAO = new VeiculoDAO();
    private DespesaDAO despesaDAO;

    public RelatorioService() {
        this.movimentacaoDAO = new MovimentacaoDAO();
        this.veiculoDAO = new VeiculoDAO();
        this.despesaDAO = new DespesaDAO();
    }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public double calcularDespesasPorVeiculo(String placa) {
        double total = 0;
        for (Movimentacao mov : movimentacaoDAO.listar()) {

            Veiculo v = veiculoDAO.buscar(mov.getIdVeiculo());

            if (v != null && v.getPlaca().equalsIgnoreCase(placa)) {
                total += mov.getValor();
            }
        }

        return total;
    }

    public double calcularTotalMensal(int mes, int ano) {
        double total = 0;

        for (Movimentacao mov : movimentacaoDAO.listar()) {
            LocalDate data = mov.getData();

            if (data.getMonthValue() == mes && data.getYear() == ano) {
                total += mov.getValor();
            }
        }

        return total;
    }

    public double calcularTotalCombustivel() {
        double total = 0;

        for (Movimentacao mov : movimentacaoDAO.listar()) {

            Despesa tipo = despesaDAO.buscar(mov.getIdTipoDespesa());

            if (tipo != null && tipo.getDescricao().toLowerCase().contains("combust")) {
                total += mov.getValor();
            }
        }
        return total;
    }

    public double calcularTotalIPVA(int ano) {

        double total = 0;

        for (Movimentacao mov : movimentacaoDAO.listar()) {
            Despesa tipo = despesaDAO.buscar(mov.getIdTipoDespesa());

            if (tipo != null && tipo.getDescricao().equalsIgnoreCase("IPVA")) {

                LocalDate data = mov.getData();

                if (data.getYear() == ano) {
                    total += mov.getValor();
                }
            }
        }

        return total;
    }

    public List<Veiculo> listarVeiculosInativos() {

        List<Veiculo> inativos = new ArrayList<>();

        for (Veiculo v : veiculoDAO.listar()) {
            if (!v.isAtivo()) {
                inativos.add(v);
            }
        }

        return inativos;
    }

    public double calcularTotalMultasPorAno(int ano) {

        double total = 0;

        for (Movimentacao mov : movimentacaoDAO.listar()) {

            Despesa tipo = despesaDAO.buscar(mov.getIdTipoDespesa());

            if (tipo != null && tipo.getDescricao().toLowerCase().contains("multa")) {

                LocalDate data = mov.getData();

                if (data.getYear() == ano) {
                    total += mov.getValor();
                }
            }
        }

        return total;
    }

    public int contarEntregas() {

        int total = 0;

        for (Movimentacao mov : movimentacaoDAO.listar()) {
            Despesa tipo = despesaDAO.buscar(mov.getIdTipoDespesa());

            if (tipo != null && tipo.getDescricao().toLowerCase().contains("entrega")) {
                total++;
            }
        }

        return total;
    }

    public Map<String, Double> calcularTotalPorTipoDeDespesa() {

        Map<String, Double> mapa = new HashMap<>();

        for (Movimentacao mov : movimentacaoDAO.listar()) {

            Despesa tipo = despesaDAO.buscar(mov.getIdTipoDespesa());

            if (tipo != null) {

                String descricao = tipo.getDescricao();

                mapa.put(descricao, mapa.getOrDefault(descricao, 0.0) + mov.getValor());
            }

        }
        return mapa;
    }
}



