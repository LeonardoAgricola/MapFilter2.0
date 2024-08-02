import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class ProcessoGeral {

    public static void main(String[] args) {
        TelaUsuario tela = new TelaUsuario();
        tela.setVisible(true);
    }

    private int nColumns, atribute;
    public ArrayList<ArrayList<Double>> dataOriginal = new ArrayList<>();
    public ArrayList<ArrayList<Double>> dataFiltered = new ArrayList<>();
    public ArrayList<ArrayList<Double>> dataClean = new ArrayList<>();
    public double[] estat = new double[10];
    public double[] mapLeg = new double[6];
    private String[] colNames = new String[100];

    private AbrirArquivos readFile = new AbrirArquivos();
    private DataStat statisc = new DataStat();
    private FiltroGeral general = new FiltroGeral();
    private FiltroLocal localFilter = new FiltroLocal();
    private SalvarArquivos salvardadoss = new SalvarArquivos();

    public void process1(File file) throws IOException {
        colNames = readFile.readHeader(file);
        nColumns = (int) colNames.length;
        showAttributeSelectionDialog();

        if (nColumns < 3) {
            JOptionPane.showMessageDialog(null, "Coordinates or attribute not found!", "Caution!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        dataOriginal = readFile.fileToArray(file, atribute);
        estat = statisc.calculateStatistics(dataOriginal);
        mapLeg = statisc.classifyData(dataOriginal);
    }

    public void filtrogeral(double var) {
        dataFiltered = general.filterMatrix(dataOriginal, var);
        updateStatistics(dataFiltered);
        // JOptionPane.showMessageDialog(null, "Filtering completed!", "Caution", JOptionPane.INFORMATION_MESSAGE);
    }

    public void filtrolocal(double var, double raio) {
        dataClean = localFilter.filtromedian(dataFiltered, var, raio);
        updateStatistics(dataClean);
        // JOptionPane.showMessageDialog(null, "Local filtering completed!", "Caution", JOptionPane.INFORMATION_MESSAGE);
    }

    public void salvardados(File arquivo, int ext) {
        salvardadoss.salvar(dataClean, arquivo, ext);
    }

    public void displayData(JComponent c, ArrayList<ArrayList<Double>> data) {
        DisplayPontos disp = new DisplayPontos();
        disp.calcXY(data);
        disp.separSteps(data, mapLeg);
        disp.display(c);
    }

    public void showAttributeSelectionDialog() {
        JComboBox<String> box1 = new JComboBox<>(colNames);
        box1.setEditable(false);
        Object[] message = { "Attribute to be filtered:", box1 };
        JOptionPane.showMessageDialog(null, message, "Setup", JOptionPane.QUESTION_MESSAGE);
        atribute = box1.getSelectedIndex();
    }

    private void updateStatistics(ArrayList<ArrayList<Double>> data) {
        estat = statisc.calculateStatistics(data);
        mapLeg = statisc.classifyData(data);
    }
}
