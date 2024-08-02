import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class DistanceMatrix {

    public static double[][] calculateDistanceMatrix(ArrayList<ArrayList<Double>> matriz) {
        int n = matriz.size();
        double[][] distanceMatrix = new double[n][n];
        
        IntStream.range(0, n).forEach(i -> {
            IntStream.range(0, n).forEach(j -> {
                if (i != j) {
                    double x1 = matriz.get(i).get(3);
                    double y1 = matriz.get(i).get(4);
                    double x2 = matriz.get(j).get(3);
                    double y2 = matriz.get(j).get(4);
                    distanceMatrix[i][j] = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                } else {
                    distanceMatrix[i][j] = 0;
                }
            });
        });

        return distanceMatrix;
    }

    static class DistanceTask extends RecursiveTask<Void> {
        private static final int THRESHOLD = 1000;
        private double[][] distanceMatrix;
        private ArrayList<ArrayList<Double>> matriz;
        private int start;
        private int end;

        public DistanceTask(double[][] distanceMatrix, ArrayList<ArrayList<Double>> matriz, int start, int end) {
            this.distanceMatrix = distanceMatrix;
            this.matriz = matriz;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void compute() {
            computeDirectly();
            return null;
            // if (end - start <= THRESHOLD) {
            //     computeDirectly();
            //     return null;
            // } else {
            //     int mid = (start + end) / 2;
            //     DistanceTask task1 = new DistanceTask(distanceMatrix, matriz, start, mid);
            //     DistanceTask task2 = new DistanceTask(distanceMatrix, matriz, mid, end);
            //     invokeAll(task1, task2);
            //     return null;
            // }
        }

        private void computeDirectly() {
            IntStream.range(start, end).forEach(i -> {
                IntStream.range(0, matriz.size()).forEach(j -> {
                    if (i != j) {
                        double x1 = matriz.get(i).get(3);
                        double y1 = matriz.get(i).get(4);
                        double x2 = matriz.get(j).get(3);
                        double y2 = matriz.get(j).get(4);
                        distanceMatrix[i][j] = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                    } else {
                        distanceMatrix[i][j] = 0;
                    }
                });
            });
        }
    }
}
