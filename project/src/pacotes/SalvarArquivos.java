import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalvarArquivos {

    public void salvar(ArrayList<ArrayList<Double>> matriz, File nome, int est) {
        String ext = null;
        if (est == 1) {
            ext = ".csv";
        }
        if (est == 2) {
            ext = ".txt";
        }
        try {
            int n = matriz.size();
            String[] header = new String[] { "lat", "long", "values" };

            FileWriter file = new FileWriter(nome + ext, false);
            try (BufferedWriter escrever = new BufferedWriter(file)) {
                int count = 0;
                for (String h : header) {
                    h = (count < 2) ? h + "," : h;
                    escrever.write(h);
                    count++;
                }
                for (int i = 0; i < n; i++) {
                    escrever.newLine();
                    count = 0;
                    for (int j = 0; j < 3; j++) {
                        String value = String.valueOf(matriz.get(i).get(j));
                        value = (count < 2) ? value + "," : value;
                        escrever.write(value);
                        count++;
                    }
                }
                escrever.flush();
                escrever.close();
            }
        } catch (IOException e) {
        }
    }
}
