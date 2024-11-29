import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for reading files and extracting data.
 * 
 * Authors: Leonardo Felipe Maldaner, Mark Spekken, Jose Paulo Molin
 */
public class AbrirArquivos {

    private final GeoUtm transformer = new GeoUtm();

    /**
     * Reads the header from the given file.
     *
     * @param file the file to read the header from
     * @return an array of header names with the first element being the count of
     *         columns
     * @throws IOException if an I/O error occurs
     */
    public String[] readHeader(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("File is empty.");
            }

            String[] values = line.split("[,;]");
            String[] result = new String[values.length + 1];
            result[0] = String.valueOf(values.length);
            for (int i = 0; i < values.length; i++) {
                result[i + 1] = values[i].trim();
            }
            return values;
        } catch (IOException ex) {
            Logger.getLogger(AbrirArquivos.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    /**
     * Reads data from the given file and converts it into a nested list of doubles.
     *
     * @param file     the file to read data from
     * @param toFilter the index of the column to filter
     * @return a nested list of doubles containing the parsed data
     * @throws IOException if an I/O error occurs
     */
    public ArrayList<ArrayList<Double>> fileToArray(File file, int toFilter) throws IOException {
        ArrayList<ArrayList<Double>> valuesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] headers = readHeader(file);
            int idx = findIndex(headers, new String[] { "LONG", "X" });
            int idy = findIndex(headers, new String[] { "LAT", "Y" });
            int idz = toFilter;

            if (idx == -1 || idy == -1) {
                throw new IOException("Required columns not found in the header.");
            }

            reader.readLine(); // skip header line

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("[,;]");
                double lat = Double.parseDouble(values[idy]);
                double lon = Double.parseDouble(values[idx]);
                double value = Double.parseDouble(values[idz]);

                ArrayList<Double> coordinates = new ArrayList<>();
                coordinates.add(lat);
                coordinates.add(lon);
                coordinates.add(value);
                Double[] xy = transformer.Deg2UTM(lat, lon);
                coordinates.add(xy[0]);
                coordinates.add(xy[1]);

                valuesList.add(coordinates);
            }
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(AbrirArquivos.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Error processing file", ex);
        }
        return valuesList;
    }

    /**
     * Finds the index of a column in the header line that matches any of the given
     * substrings.
     *
     * @param header     the header line as an array of strings
     * @param substrings the substrings to search for
     * @return the index of the matching column or -1 if not found
     * @throws IOException if the first element of the header is not a valid number
     */
    private int findIndex(String[] header, String[] substrings) throws IOException {
        int count = 0;
        for (String element: header) {
            element = element.toUpperCase();
            for (String substring : substrings) {
                if (element.contains(substring.toUpperCase())) {
                    return count;
                }
            }
            count++;
        }
        return -1;
    }
}
