package com.br.pieng2.domain.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaArquivo {

    public static <T> void salvar(String caminho, List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
        }   catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o arquivo " + caminho, e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> carregar(String caminho) {
        File arquivo = new File(caminho);

        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return (List<T>) ois.readObject();
        }   catch (Exception e) {

            return new ArrayList<>();
        }
    }
}
