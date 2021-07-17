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

public class FiltroGeral {

    public String[][] filtrogeral(String[][] matriz, int x, int y,
            int nCol, int colAt, double var) {

        int n = (int) Double.parseDouble(matriz[0][0]);
        String[][] filtrados = new String[n + 1][nCol + 1];
        double[] valores = new double[n + 1];
        double limI;
        double limS;
        double mediana = 0;
        int cont = 0;
        int nmediana;
     
        var = var / 100;//transforma em decimal
        for (int i = 1; i < n; i++) {
            valores[i] = Double.parseDouble(matriz[i][colAt]);
        }
        Arrays.sort(valores, 1, n);

        nmediana = (int) Math.round(n * 0.50);
      
        for (int i = 2; i < n - 1; i++) {
            if (i == nmediana) {
                mediana = valores[i];
            }
        }
    
        limI = mediana - (mediana * var);
        limS = mediana + (mediana * var);
        
        int conta1 = 0;
        for (int i = 1; i < n; i++) {
            if ((Double.parseDouble(matriz[i][colAt]) <= limI)
                    || (Double.parseDouble(matriz[i][colAt]) >= limS)) {
            } else {
                conta1++;
                System.arraycopy(matriz[i], 0, filtrados[conta1], 0, nCol + 1);
            }
        }

        filtrados[0][0] = String.valueOf(conta1);
        return filtrados;
    }
}
