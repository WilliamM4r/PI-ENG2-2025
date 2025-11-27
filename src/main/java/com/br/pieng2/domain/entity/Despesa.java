package com.br.pieng2.domain.entity;

public class Despesa {
    private Long idTipoDespesa;
    private String descricao;

    public Despesa(Long idTipoDespesa, String descricao) {
        this.idTipoDespesa = idTipoDespesa;
        this.descricao = descricao;
    }
}
