package com.br.pieng2.domain.entity;

public class Movimentacao {
    private Long idMovimentacao;
    private double valor;

    public Movimentacao(Long idMovimentacao, double valor) {
        this.idMovimentacao = idMovimentacao;
        this.valor = valor;
    }

    public Long getIdMovimentacao() {return idMovimentacao;}
    public double getValor() {return valor;}

    public void setIdMovimentacao (Long idMovimentacao) {this.idMovimentacao = idMovimentacao;}
    public void setValor (double valor) {this.valor = valor;}
}
