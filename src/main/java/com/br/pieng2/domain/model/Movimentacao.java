package com.br.pieng2.domain.model;

import java.time.LocalDate;

public class Movimentacao {
    private int idMovimentacao;
    private int idVeiculo;
    private int idTipoDespesa;
    private String descricao;
    private LocalDate data;
    private double valor;

    public Movimentacao(int idMovimentacao, int idVeiculo, int idTipoDespesa, String descricao, LocalDate data, double valor) {
        this.idMovimentacao = idMovimentacao;
        this.idVeiculo = idVeiculo;
        this.idTipoDespesa = idTipoDespesa;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public int getIdMovimentacao() {return idMovimentacao;}
    public int getIdVeiculo() {return idVeiculo;}
    public int getIdTipoDespesa() {return idTipoDespesa;}
    public String getDescricao() {return descricao;}
    public LocalDate getData() {return data;}
    public double getValor() {return valor;}

    public void setIdMovimentacao (int idMovimentacao) {this.idMovimentacao = idMovimentacao;}
    public void setIdVeiculo (int idVeiculo) {this.idVeiculo = idVeiculo;}
    public void setIdTipoDespesa (int idTipoDespesa) {this.idTipoDespesa = idTipoDespesa;}
    public void setDescricao (String descricao) {this.descricao = descricao;}
    public void setData (LocalDate data) {this.data = data;}
    public void setValor (double valor) {this.valor = valor;}

    @Override
    public String toString() {
        return idMovimentacao + ";" + idVeiculo + ";" + idTipoDespesa + ";" + descricao + ";" + data + ";" + valor;
    }

    public static Movimentacao fromString(String linha) {
        String[] p = linha.split(";");
        return new Movimentacao(
                Integer.parseInt(p[0]),
                Integer.parseInt(p[1]),
                Integer.parseInt(p[2]),
                p[3],
                LocalDate.parse(p[4]),
                Double.parseDouble(p[5])
        );
    }

}
