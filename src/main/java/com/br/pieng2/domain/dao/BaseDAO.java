package com.br.pieng2.domain.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {

    protected List<String> lerArquivo(String arquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    protected void gravarArquivo(String arquivo, List<T> dados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (T obj : dados) {
                bw.write(obj.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
