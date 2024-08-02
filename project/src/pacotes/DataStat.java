import java.util.ArrayList;
import java.util.Arrays;

/**
 * Utility class for calculating statistics and classifying data.
 * 
 */
public class DataStat {

    /**
     * Calculates various statistics from the given data column.
     * 
     * @param data  The input data as a nested list of doubles.
     * @return An array containing the number of points, minimum value, maximum value, mean, standard deviation, and coefficient of variation.
     */
    public double[] calculateStatistics(ArrayList<ArrayList<Double>> data) {
        double[] statistics = new double[6];
        int nPoints = data.size();
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0.0;

        for (ArrayList<Double> point : data) {
            double value = point.get(2);
            sum += value;
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        double mean = sum / nPoints;
        double sumSquares = 0.0;

        for (ArrayList<Double> point : data) {
            double value = point.get(2);
            sumSquares += Math.pow(value - mean, 2);
        }

        double stdDev = Math.sqrt(sumSquares / nPoints);
        double cv = (stdDev / mean) * 100;

        statistics[0] = nPoints; // Number of points
        statistics[1] = min;     // Minimum value
        statistics[2] = max;     // Maximum value
        statistics[3] = mean;    // Mean value
        statistics[4] = stdDev;  // Standard deviation
        statistics[5] = cv;      // Coefficient of variation

        return statistics;
    }

    /**
     * Classifies data into six quantiles based on the given column.
     * 
     * @param data  The input data as a nested list of doubles.
     * @return An array containing the values at the 2nd, 20th, 40th, 60th, 80th, and last percentiles.
     */
    public double[] classifyData(ArrayList<ArrayList<Double>> data) {
        int nPoints = data.size();
        double[] values = new double[nPoints];

        for (int i = 0; i < nPoints; i++) {
            values[i] = data.get(i).get(2);
        }

        Arrays.sort(values);

        double[] classes = new double[6];
        classes[0] = values[1];
        classes[1] = values[(int) Math.round(nPoints * 0.2)];
        classes[2] = values[(int) Math.round(nPoints * 0.4)];
        classes[3] = values[(int) Math.round(nPoints * 0.6)];
        classes[4] = values[(int) Math.round(nPoints * 0.8)];
        classes[5] = values[nPoints - 1];

        return classes;
    }
}
