package pacotes;

import pacotes.AbrirArquivos;
import java.io.File;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

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

public class ProcessoGeral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TelaUsuario tela = new TelaUsuario();
        tela.setVisible(true);
    }

    int colIN = 0;
    int colIDM;
    int x, y, nCol, nPts, nPtsG, colAt;
    String[][] matrizOR = new String[500000][100];
    String[][] matrizGR = matrizOR;
    String[][] matrizFL = matrizOR;
    double[] estat = new double[10]
    double[] mapLeg = new double[6];
    String[] infor = new String[100];

    AbrirArquivos abrir = new AbrirArquivos();
    SalvarArquivos salvar = new SalvarArquivos();
    DataStat statisc = new DataStat();
    FiltroGeral filtro1 = new FiltroGeral();
    FiltroLOcal filtro2 = new FiltroLOcal();
    GeoUtm convert = new GeoUtm();
    SalvarArquivos salvardadoss = new SalvarArquivos();
    JRadioButton bot1 = new JRadioButton();
    JRadioButton bot2 = new JRadioButton();

    public void process1(File f) throws IOException {
        infor = abrir.cabecalho(f);
        x = abrir.findX(infor);
        y = abrir.findY(infor);
        nCol = (int) Double.parseDouble(infor[0]);
        alerta1();
        
        if (x == y) {
            JOptionPane.showMessageDialog(null, "Lat and Long not found!",
                    "Caution!", 2);
        } else {
            matrizOR = abrir.arquivo(f);
            nPts = (int) Double.parseDouble(matrizOR[0][0]);
            for (int i = 1; i < nPts; i++) {
                String[] ncoord = convert.Deg2UTM(Double.parseDouble(
                        matrizOR[i][y]), Double.parseDouble(matrizOR[i][x]));
                matrizOR[i][nCol + 1] = ncoord[0];
                matrizOR[i][nCol + 2] = ncoord[1];
            }
            x = nCol + 1;
            y = nCol + 2;
            colIN = nCol;
            nCol = nCol + 4;
        }
        estat = statisc.estatist(matrizOR, colAt);
        mapLeg = statisc.classificar(matrizOR, colAt);
    }


    public void filtrogeral(double var) {
        matrizGR = filtro1.filtrogeral(matrizOR, x, y, nCol, colAt, var);
        estat = statisc.estatist(matrizGR, colAt);
        mapLeg = statisc.classificar(matrizGR, colAt);
        JOptionPane.showMessageDialog(null, "Filtering completed!!!!", "Caution", 2);
    }


    public void filtrolocal(double var, double raio) {
        matrizFL = filtro2.filtroMediana(matrizGR, x, y, colAt, nCol, var, raio);
        // normal.identificarID(matrizFL, colIDM - 1);
        estat = statisc.estatist(matrizFL, colAt);//estatistica das filtrados
        mapLeg = statisc.classificar(matrizFL, colAt);//legenda dados filtrados
        JOptionPane.showMessageDialog(null, "Filtering completed!!!!", "Caution", 2);
    }

    public void salvardados(int escolha,File arquivo,int ext){
        if (escolha == 1){
        int n =(int) Double.parseDouble(matrizGR[0][0]);
        salvardadoss.salvar(matrizFL, n, colIN, arquivo, infor, ext);
        }
        if (escolha == 2){
        int n =(int) Double.parseDouble(matrizFL[0][0]);
        salvardadoss.salvar(matrizFL, n, colIN, arquivo, infor, ext);
        }
    }
    
    public void telaoriginal(JComponent c) {
        DisplayPontos disp = new DisplayPontos();
        disp.calcXY(matrizOR, nPts, x, y);
        disp.separSteps(matrizOR, mapLeg, nPts, x, y, colAt);
        disp.display(c);
    }

    public void telageral(JComponent c) {
        DisplayPontos disp = new DisplayPontos();
        disp.calcXY(matrizGR, (int) Double.parseDouble(matrizGR[0][0]), x, y);
        disp.separSteps(matrizGR, mapLeg, (int) Double.parseDouble(matrizGR[0][0]), x, y, colAt);
        disp.display(c);
    }

    public void telalocal(JComponent c) {
        DisplayPontos disp = new DisplayPontos();
        disp.calcXY(matrizFL, (int) Double.parseDouble(matrizFL[0][0]), x, y);
        disp.separSteps(matrizFL, mapLeg, (int) Double.parseDouble(matrizFL[0][0]), x, y, colAt);
        disp.display(c);
    }

    public void alerta1() {
//        bot1.setText("UTM");
//        bot2.setText("geographical (decimal degrees)");
//        ButtonGroup grup1 = new ButtonGroup();
//        grup1.add(bot1);
//        grup1.add(bot2);
//        Object[] grup = {"Coordinates System:", bot1, bot2};
//        JOptionPane.showMessageDialog(null, grup, "Setup 1", 3);
        String[] col = new String[nCol];
        for (int i = 0; i < nCol; i++) {
            col[i] = infor[i + 1];
        }
        JComboBox box1 = new JComboBox(col);
        box1.setEditable(false);
        Object[] grup11 = {"Attribut to be filtered:", box1};
        JOptionPane.showMessageDialog(null, grup11, "Setup 2", 3);
        colAt = box1.getSelectedIndex();
    }
}
