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

public class DataStat {
    
    public double[] estatist(String[][] dat,int colAt) {
        double[] valores = new double[6];
        int nPts = (int) Double.parseDouble(dat[0][0]);
        //System.out.println(Double.parseDouble(dat[2][colAt]));
        double min = Double.parseDouble(dat[2][colAt]);
        double max = min;
        double med;
        double des;
        double cv;
        double soma1 = 0;
        double soma2 = 0;
        for (int i = 1; i < nPts; i++) {
            soma1 = soma1 + Double.parseDouble(dat[i][colAt]);
            if (Double.parseDouble(dat[i][colAt]) < min) {
                min = Double.parseDouble(dat[i][colAt]);
            }
            if (Double.parseDouble(dat[i][colAt]) > max) {
                max = Double.parseDouble(dat[i][colAt]);
            }
        }
        med = soma1 / nPts;//calcula a media
        for (int i = 1; i < nPts; i++) {
            soma2 = soma2 + Math.pow((Double.parseDouble(dat[i][colAt]) - med), 2);
        }
        des = Math.sqrt(soma2 / nPts);//calcula o desvio
        cv = (des / med) * 100;//calcula o CV
        valores[0] = nPts;//numero de pontos
        valores[1] = min;//valor minimo
        valores[2] = max;//valor maximo
        valores[3] = med;//valor media
        valores[4] = des;//desvio padrao
        valores[5] = cv;//coeficiente de variacao
        return valores;
    }

    public double[] classificar(String[][] dat,int colAt) {
        double[] classes = new double[6];
        int nPts = (int) Double.parseDouble(dat[0][0]);
        double[] data = new double[nPts + 1];
        for (int i = 2; i < nPts; i++) {
            data[i] = Double.parseDouble(dat[i][colAt]);
        }
        Arrays.sort(data, 2, nPts);
        int q1 = 2;
        int q2 = (int) Math.round(nPts * 0.2);
        int q3 = (int) Math.round(nPts * 0.4);
        int q4 = (int) Math.round(nPts * 0.6);
        int q5 = (int) Math.round(nPts * 0.8);
        int q6 = nPts-1;
        for (int i = 1; i < nPts; i++) {
            if (i == q1) {
                classes[0] = data[i];
            }
            if (i == q2) {
                classes[1] = data[i];
            }
            if (i == q3) {
                classes[2] = data[i];
            }
            if (i == q4) {
                classes[3] = data[i];
            }
            if (i == q5) {
                classes[4] = data[i];
            }
            if (i == q6) {
                classes[5] = data[i];
            }
        }
        return classes;
    }
}
