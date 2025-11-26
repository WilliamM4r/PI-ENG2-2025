package com.br.pieng2.domain.entity;

import java.time.LocalDate;

public class Veiculo {
    private Long idVeiculo;
    private String placa;
    private String marca;
    private LocalDate anoFabricacao;
    private boolean veiculoAtivo;

    public Veiculo(Long idVeiculo, String placa, String marca, LocalDate anoFabricacao, boolean veiculoAtivo) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.veiculoAtivo = veiculoAtivo;
    }
}
