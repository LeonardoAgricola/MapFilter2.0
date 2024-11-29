import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DisplayPontos {
    XYSeries step1 = new XYSeries("1");
    XYSeries step2 = new XYSeries("2");
    XYSeries step3 = new XYSeries("3");
    XYSeries step4 = new XYSeries("4");
    XYSeries step5 = new XYSeries("5");

    XYSeriesCollection steps = new XYSeriesCollection();

    double maxX, minX, minY, maxY, maxL;

    public void calcXY(ArrayList<ArrayList<Double>> data) {
        minX = Double.POSITIVE_INFINITY;
        maxX = Double.NEGATIVE_INFINITY;
        minY = Double.POSITIVE_INFINITY;
        maxY = Double.NEGATIVE_INFINITY;
        
        int n = data.size();

        for (int i = 1; i < n; i++) {
            double xcoord = data.get(i).get(3);
            double ycoord = data.get(i).get(4);
            if (xcoord < minX) {
                minX = xcoord;
            }
            if (xcoord > maxX) {
                maxX = xcoord;
            }
            if (ycoord < minY) {
                minY = ycoord;
            }
            if (ycoord > maxY) {
                maxY = ycoord;
            }
        }

        if (maxX - minX > maxY - minY) {
            maxL = (maxX - minX);
        } else {
            maxL = (maxY - minY);
        }

    }

    public void separSteps(ArrayList<ArrayList<Double>> data, double[] classes) {

        double x1 = classes[1];
        double x2 = classes[2];
        double x3 = classes[3];
        double x4 = classes[4];

        step1.clear();
        step2.clear();
        step3.clear();
        step4.clear();
        step5.clear();
        steps.removeAllSeries();

        for (ArrayList<Double> row : data) {
            double value = row.get(2);
            double xcoord = row.get(3);
            double ycoord = row.get(4);
            if (value <= x1) {
                step1.add(xcoord, ycoord);
            }
            if (value > x1 && value <= x2) {
                step2.add(xcoord, ycoord);
            }
            if (value > x2 && value <= x3) {
                step3.add(xcoord, ycoord);
            }
            if (value > x3 && value <= x4) {
                step4.add(xcoord, ycoord);
            }
            if (value > x4) {
                step5.add(xcoord, ycoord);
            }
        }

        steps.addSeries(step1);
        steps.addSeries(step2);
        steps.addSeries(step3);
        steps.addSeries(step4);
        steps.addSeries(step5);
    }

    public void display(JComponent c) {
        JFreeChart graf = ChartFactory.createScatterPlot(null,
                null,
                null,
                steps,
                PlotOrientation.VERTICAL,
                false,
                false,
                false);
        graf.setBorderVisible(false);
        graf.setBackgroundPaint(Color.WHITE);
        XYPlot plot = graf.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.isRangeZoomable();
        NumberAxis x = (NumberAxis) plot.getDomainAxis();
        x.setVisible(false);
        x.setAutoRange(true);
        x.setRange(minX - minX * 0.000001, maxL + minX);
        NumberAxis y = (NumberAxis) plot.getRangeAxis();
        y.setAutoRange(true);
        y.setRange(minY - minY * 0.000001, maxL + minY);
        y.setVisible(false);
        XYItemRenderer renderer = plot.getRenderer();
        Ellipse2D shape = new Ellipse2D.Double(0, 0, 2.0, 2.0);
        renderer.setSeriesShape(0, shape);
        renderer.setSeriesShape(1, shape);
        renderer.setSeriesShape(2, shape);
        renderer.setSeriesShape(3, shape);
        renderer.setSeriesShape(4, shape);
        renderer.setSeriesPaint(0, new Color(215, 25, 28, 255));
        renderer.setSeriesPaint(1, new Color(253, 174, 97, 255));
        renderer.setSeriesPaint(2, new Color(255, 255, 192, 255));
        renderer.setSeriesPaint(3, new Color(166, 217, 106, 255));
        renderer.setSeriesPaint(4, new Color(26, 150, 65, 255));
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setMouseZoomable(false);
        myChartPanel.setBackground(Color.WHITE);
        myChartPanel.setSize(c.getWidth(), c.getHeight());
        myChartPanel.setVisible(true);
        c.removeAll();
        c.add(myChartPanel);
        c.revalidate();
        c.repaint();
        c.setEnabled(false);
    }
}
