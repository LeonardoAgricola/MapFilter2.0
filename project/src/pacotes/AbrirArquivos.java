package pacotes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leonardo Felipe Maldaner
 * @author Mark Spekken
 * @author Jose Paulo Molin
 */

public class AbrirArquivos {

    public String[] cabecalho(File x) throws IOException {
        String[] cabeca = new String[500];
        int conta = 1;
        try {
            FileReader arq = new FileReader(x);
            BufferedReader ler = new BufferedReader(arq);
            String linha = ler.readLine();
            char[] line = linha.toCharArray();
            int inCol = 0;
            conta = 1;
            for (int i = 0; i < line.length; i++) {
                String car = String.valueOf(line[i]);
                if (",".equals(car) || ";".equals(car)) {
                    cabeca[conta] = linha.substring(inCol, i);
                    inCol = i + 1;
                    conta++;
                }
            }
            cabeca[conta] = linha.substring(inCol, line.length);
          } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        cabeca[0] = String.valueOf(conta);
        return cabeca;
    }

    public String[][] arquivo(File x) throws IOException {
        int conta;
        String[][] matriz = new String[500000][100];
        conta = 1;  
                
        try {
            FileReader lerarquivo22 = new FileReader(x);
            try (BufferedReader arq1 = new BufferedReader(lerarquivo22)) {
                int conta2 = 0;
                int inCol;
                arq1.readLine();
                String linha = arq1.readLine();
                while (linha != null) {
                    char[] dados = linha.toCharArray();
                    inCol = 0;
                    for (int i = 1; i < dados.length; i++) {
                        String car = String.valueOf(dados[i]);
                        if (",".equals(car) || ";".equals(car)) {
                            matriz[conta][conta2] = linha.substring(inCol, i);
                            conta2++;
                            inCol = i + 1;
                        }
                    }
                    matriz[conta][conta2] = linha.substring(inCol,dados.length);
                    conta2 = 0;
                    conta++;
                    linha = arq1.readLine();
                }
            }
           } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        matriz[0][0] = String.valueOf(conta);
        return matriz;
    }

    public int findX(String[] line) throws IOException {
        int x = 0;
        for (int i = 0; i < ((int) Double.parseDouble(line[0])); i++) {
            String esc = line[i];
            switch (esc) {
                case "Long":
                case "Longitude":
                case "long":
                case "longitude":
                case "LONG":
                case "LONGITUDE":
                case "X":
                    x = i;
                    break;
                default:
                    break;
            }
        }
        return x - 1;
    }

    public int findY(String[] line) throws IOException {
        int y = 0;
        for (int i = 1; i < ((int) Double.parseDouble(line[0])); i++) {
            String esc = line[i];
            switch (esc) {
                case "Lat":
                case "Latitude":
                case "lat":
                case "latitude":
                case "LAT":
                case "LATITUDE":
                case "Y":
                    y = i;
                    break;
                default:
                    break;
            }
        }
        return y - 1;
    }
}
