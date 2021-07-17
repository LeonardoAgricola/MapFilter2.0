package pacotes;

import java.util.Arrays;

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

public class FiltroLOcal {

    public String[][] filtroMediana(String[][] matriz, int x, int y, int colAt, int nCol, double var, double raio) {

        int n = (int) Double.parseDouble(matriz[0][0]);//numero de pts  
        String[][] filtrolinha = new String[n + 1][nCol + 1];//nova matriz
        String[][] filtroraio = filtrolinha;//matriz com os dados finais
        double[] valoreslinha = new double[n + 1];
        double[] valoresraio = valoreslinha;
        double xi, xe, yi, ye;
        int conta1;
        int conta2;
        int conta3 = 0;
        int conta4 = 0;
        int nMed;
        double mediana = 0;
        //int nq1, nq3;
        double limI, limS;
        boolean lim;

        var = var / 100;

        for (int i = 1; i < n; i++) {
            conta1 = 1;
            conta2 = 1;
            lim = true;
            while (lim && (i - conta1) > 1) {
                valoreslinha[conta2] = Double.parseDouble(matriz[i - conta1][colAt]);
                conta2++;
                conta1++;
                if (conta1 == 100) {
                    lim = false;
                }
            }
            conta1 = 1;
            lim = true;
            while (lim && (i + conta1) <= n) {
                valoreslinha[conta2] = Double.parseDouble(matriz[i + conta1][colAt]);
                conta2++;
                conta1++;
                if (conta1 == 100) {
                    lim = false;
                }
            }
            Arrays.sort(valoreslinha, 0, conta2 - 1);
            nMed = (int) Math.round(conta2 * 0.50);
            for (int j = 0; j < conta2; j++) {
                if (j == nMed) {
                    mediana = valoreslinha[j];
                }
            }
            limI = mediana - mediana * var;
            limS = mediana + mediana * var;
            if ((Double.parseDouble(matriz[i][colAt]) <= limI) || (Double.parseDouble(matriz[i][colAt]) >= limS)) {
            } else {
                conta3++;
                System.arraycopy(matriz[i], 0, filtrolinha[conta3], 0, nCol + 1);
            }
        }

        String disNULL;
 
        for (int i = 1; i < conta3; i++) {
            xi = Double.parseDouble(filtrolinha[i][x]);
            yi = Double.parseDouble(filtrolinha[i][y]);
            conta1 = 1;
            conta2 = 1;
            disNULL = "nao";
            lim = true;
            while (lim && (i - conta1) > 1) {
                xe = Double.parseDouble(filtrolinha[i - conta1][x]);
                ye = Double.parseDouble(filtrolinha[i - conta1][y]);
                if (distancia(xi, xe, yi, ye) <= raio) {
                    valoresraio[conta2] = Double.parseDouble(filtrolinha[i - conta1][colAt]);
                    conta2++;
                    if (distancia(xi, xe, yi, ye)<=0.20){
                        disNULL = "sim";
                    }
                }
                if (conta2 == 600||conta1==8000) {
                    lim = false;
                }
                conta1++;
            }
            conta1 = 1;
            lim = true;
            while (lim && (i + conta1) < conta3) {
                xe = Double.parseDouble(filtrolinha[i + conta1][x]);
                ye = Double.parseDouble(filtrolinha[i + conta1][y]);
                if (distancia(xi, xe, yi, ye) <= raio) {
                    valoresraio[conta2] = Double.parseDouble(filtrolinha[i + conta1][colAt]);
                    conta2++;
                    if (distancia(xi, xe, yi, ye)<=0.20){
                        disNULL = "sim";
                    }
                }
                conta1++;
                if (conta2 == 600||conta1==8000) {
                    lim = false;
                }
            }
            Arrays.sort(valoresraio, 0, conta2);
            nMed = (int) Math.round(conta2 * 0.50);

            for (int j = 0; j < conta2; j++) {
                if (j == nMed) {
                    mediana = valoresraio[j];
                } 
            }
            double limD = mediana - mediana*var;//limite inferior
            double limU = mediana + mediana*var;//limite superior
            if ((Double.parseDouble(filtrolinha[i][colAt]) <= limD) || 
                    (Double.parseDouble(filtrolinha[i][colAt]) >= limU)||
                    "sim".equals(disNULL)) {
            } else {
                conta4++;//conta o numero de dados filtrados
                System.arraycopy(filtrolinha[i], 0, filtroraio[conta4], 0, nCol + 1);
            }
        }
        filtroraio[0][0] = String.valueOf(conta4);
        return filtroraio;
    }

    public double distancia(double xi, double xe, double yi, double ye) {
        double dis = Math.sqrt(Math.pow((xe - xi), 2) + Math.pow((ye - yi), 2));
        return dis;
    }

}
