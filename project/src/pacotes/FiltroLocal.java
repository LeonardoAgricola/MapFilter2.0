import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;

public class FiltroLocal {

    /**
     * Filters the elements of the matrix based on local median values and distance
     * criteria.
     *
     * @param data      The input matrix where each element contains coordinate
     *                  values and a data value.
     * @param variation The variation percentage to determine the threshold around
     *                  the median.
     * @param radius    The radius within which to consider neighboring elements for
     *                  filtering.
     * @return The filtered matrix with elements removed based on median and
     *         distance criteria.
     */
    public ArrayList<ArrayList<Double>> filtromedian(ArrayList<ArrayList<Double>> data, double variation,
            double radius) {
        int n = data.size();
        final double variationFinal = variation / 100;

        List<Integer> indicesToRemove = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            final int index = k; // Make the variable effectively final

            // Collect values within the specified radius
            List<Double> inValues = IntStream.rangeClosed(1, 100)
                    .mapToObj(j -> {
                        List<Double> values = new ArrayList<>();
                        if (index - j >= 0) {
                            values.add(data.get(index - j).get(2));
                        }
                        if (index + j < n) {
                            values.add(data.get(index + j).get(2));
                        }
                        return values;
                    })
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            // Add the current value to the list
            inValues.add(data.get(k).get(2));

            // Calculate the median and limits
            Collections.sort(inValues);
            int count = inValues.size();
            int idm = (count - 1) / 2; // Median index
            double median = inValues.get(idm);

            double limI = median - median * variationFinal;
            double limS = median + median * variationFinal;

            // Check if the current value is outside the limits
            double pointValue = data.get(k).get(2);
            if (pointValue <= limI || pointValue >= limS) {
                indicesToRemove.add(k);
            }
        }

        // Remove elements from the matrix in a safe manner, in descending order
        for (int p = indicesToRemove.size() - 1; p >= 0; p--) {
            data.remove((int) indicesToRemove.get(p));
        }

        // Recalculate the distance matrix after removing elements
        ArrayList<Double> values = data.stream()
                .map(row -> row.get(2))
                .collect(Collectors.toCollection(ArrayList::new));

        double radiusSquared = Math.pow(radius, 2);
        ConcurrentLinkedQueue<Integer> indicesToRemoveAfterDistanceMatrix = new ConcurrentLinkedQueue<>();

        ForkJoinPool customThreadPool = new ForkJoinPool(100); // Ajuste o número de threads conforme necessário

        customThreadPool.submit(() -> data.parallelStream().forEach(row -> {
            double xi = row.get(3);
            double yi = row.get(4);

            List<Double> radiusValues = new ArrayList<>();
            int i = 0;

            for (int index = 0; index < data.size(); index++) {
                ArrayList<Double> other = data.get(index);
                double xj = other.get(3);
                double yj = other.get(4);
                double distanceSquared = Math.pow(xj - xi, 2) + Math.pow(yj - yi, 2);

                i = (distanceSquared == 0.0) ? index : i;

                if (distanceSquared < radiusSquared) {
                    radiusValues.add(values.get(index));
                }
            }

            if (!radiusValues.isEmpty()) {
                radiusValues.sort(Double::compareTo);
                int count = radiusValues.size();
                double median = radiusValues.get((count - 1) / 2);

                double limI = median - median * variationFinal;
                double limS = median + median * variationFinal;

                double pointValue = row.get(2);
                if (pointValue <= limI || pointValue >= limS) {
                    indicesToRemoveAfterDistanceMatrix.add(i);
                }
            }
        })).join();

        List<Integer> indicesToRemoveMatrix = indicesToRemoveAfterDistanceMatrix.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (int index : indicesToRemoveMatrix) {
            data.remove(index);
        }

        return data;
    }
}
