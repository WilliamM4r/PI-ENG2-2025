package com.br.pieng2.domain.model;

public class Despesa {
    private int idTipoDespesa;
    private String descricao;

    public Despesa(int idTipoDespesa, String descricao) {
        this.idTipoDespesa = idTipoDespesa;
        this.descricao = descricao;
    }

    public int getIdTipoDespesa() {return idTipoDespesa;}
    public String getDescricao() {return descricao;}

    public void setIdTipoDespesa(int idTipoDespesa) {this.idTipoDespesa = idTipoDespesa;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    @Override
    public String toString() {
        return idTipoDespesa + ";" + descricao;
    }

    public static Despesa fromString(String linha) {
        String[] p = linha.split(";");
        return new Despesa(
                Integer.parseInt(p[0]),
                p[1]
        );
    }
}
