package com.br.pieng2.domain.model;

import java.time.LocalDate;

public class Veiculo {
    private int idVeiculo;
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private boolean veiculoAtivo;

    public Veiculo(int idVeiculo,String modelo, String placa, String marca, int anoFabricacao, boolean veiculoAtivo) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.veiculoAtivo = veiculoAtivo;
    }

    public int getIdVeiculo() {return idVeiculo;}
    public String getPlaca() {return placa;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getAnoFabricacao() {return anoFabricacao;}
    public boolean getVeiculoAtivo() {return veiculoAtivo;}

    public void setIdVeiculo (int idVeiculo) {this.idVeiculo = idVeiculo;}
    public void setPlaca (String placa) {this.placa = placa;}
    public void setMarca (String marca) {this.marca = marca;}
    public void setModelo (String modelo) {this.modelo = modelo;}
    public void setAnoFabricacao (int anoFabricacao) {this.anoFabricacao = anoFabricacao;}
    public void setVeiculoAtivo (boolean veiculoAtivo) {this.veiculoAtivo = veiculoAtivo;}

    @Override
    public String toString() {
        return idVeiculo + ";" + placa + ";" + marca + ";" + modelo + ";" + anoFabricacao + ";" + veiculoAtivo;
    }

    public  static Veiculo fromString(String linha) {
        String[] p = linha.split(";");
        return new Veiculo(
                Integer.parseInt(p[0]),
                p[1],
                p[2],
                p[3],
                Integer.parseInt(p[4]),
                Boolean.parseBoolean(p[5])
        );
    }

}
