package pacotes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarArquivos {

    public void salvar(String[][] matriz, int n, int col, File nome, String[] cabecalho, int est) {
        String ext = null;
        if (est == 1) {
            ext = ".csv";
        }
        if (est == 2) {
            ext = ".txt";
        }
        try {
            //nome.createNewFile();
            FileWriter file = new FileWriter(nome+ext, false);
            try (BufferedWriter escrever = new BufferedWriter(file)) {
                for (int i = 1; i < col+1; i++) {
                    escrever.write(cabecalho[i] + ",");
                }
               // escrever.write("Fileira,");
                for (int i = 1; i <= n; i++) {
                    escrever.newLine();
                    for (int j = 0; j < col; j++) {
                        escrever.write(matriz[i][j] + ",");
                    }
                }
                escrever.flush();
                escrever.close();
            }
        } catch (IOException e) {
        }
    }
}
