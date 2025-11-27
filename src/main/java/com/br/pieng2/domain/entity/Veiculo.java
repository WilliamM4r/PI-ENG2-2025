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

    public Long getIdVeiculo() {return idVeiculo;}
    public String getPlaca() {return placa;}
    public String getMarca() {return marca;}
    public LocalDate getAnoFabricacao() {return anoFabricacao;}
    public boolean getVeiculoAtivo() {return veiculoAtivo;}

    public void setIdVeiculo (Long idVeiculo) {this.idVeiculo = idVeiculo;}
    public void setPlaca (String placa) {this.placa = placa;}
    public void setMarca (String marca) {this.marca = marca;}
    public void setAnoFabricacao (LocalDate anoFabricacao) {this.anoFabricacao = anoFabricacao;}
    public void setVeiculoAtivo (boolean veiculoAtivo) {this.veiculoAtivo = veiculoAtivo;}
}
