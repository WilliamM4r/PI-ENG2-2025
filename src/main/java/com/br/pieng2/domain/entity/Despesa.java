package com.br.pieng2.domain.entity;

import java.time.LocalDate;

public class Despesa {
    private Long idTipoDespesa;
    private String descricao;

    public Despesa(Long idTipoDespesa, String descricao) {
        this.idTipoDespesa = idTipoDespesa;
        this.descricao = descricao;
    }

    public Long getIdTipoDespesa() {return idTipoDespesa;}
    public String getDescricao() {return descricao;}

    public void setIdTipoDespesa(Long idTipoDespesa) {this.idTipoDespesa = idTipoDespesa;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}
