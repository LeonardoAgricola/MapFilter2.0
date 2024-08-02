import java.util.stream.Collectors;
import java.util.ArrayList;

public class FiltroGeral {

    /**
     * Filters the input matrix based on the specified variance.
     * Only rows with the third column's value within the specified range
     * (median +/- variance percentage) are retained.
     *
     * @param matrix   The input matrix to be filtered.
     * @param variance The variance percentage used to determine the range.
     * @return The filtered matrix.
     */
    public ArrayList<ArrayList<Double>> filterMatrix(ArrayList<ArrayList<Double>> matrix, double variance) {
        int n = matrix.size();
        variance = variance / 100;

        // Get the values of the third column and sort them
        ArrayList<Double> values = matrix.stream()
                .map(row -> row.get(2))
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        // Calculate the median
        int medianIndex = (int) Math.round(n * 0.50);
        double median = values.get(medianIndex);

        // Define lower and upper limits
        double lowerLimit = median - (median * variance);
        double upperLimit = median + (median * variance);

        // Filter the matrix
        ArrayList<ArrayList<Double>> filteredMatrix = matrix.stream()
                .filter(row -> {
                    double value = row.get(2);
                    return value > lowerLimit && value < upperLimit;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        return filteredMatrix;
    }
}