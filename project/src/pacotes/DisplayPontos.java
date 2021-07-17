package pacotes;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
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

    public void calcXY(String[][] dat, int n, int x, int y) {
        minX = Double.parseDouble(dat[2][x]);
        maxX = minX;
        minY = Double.parseDouble(dat[2][y]);
        maxY = minX;
       
        for (int i = 1; i < n; i++) {
            if (Double.parseDouble(dat[i][x])< minX) {
                minX = Double.parseDouble(dat[i][x]);
            }
            if (Double.parseDouble(dat[i][x]) > maxX) {
                maxX = Double.parseDouble(dat[i][x]);
            }
            if (Double.parseDouble(dat[i][y]) < minY) {
                minY = Double.parseDouble(dat[i][y]);
            }
            if (Double.parseDouble(dat[i][y]) > maxY) {
                maxY = Double.parseDouble(dat[i][y]);
            }
        }

        if (maxX - minX > maxY - minY) {
            maxL = (maxX - minX);
        } else {
            maxL = (maxY - minY);
        }

    }

    public void separSteps(String[][] dat, double[] classes, int n, int x,
            int y, int prod) {
   
        double x1 = classes[1];
        double x2 = classes[2];
        double x3 = classes[3];
        double x4 = classes[4];
      
        double pr, xx, yy;

        step1.clear();
        step2.clear();
        step3.clear();
        step4.clear();
        step5.clear();
        steps.removeAllSeries();

        for (int i = 1; i < n; i++) {
            pr = Double.parseDouble(dat[i][prod]);
            xx = Double.parseDouble(dat[i][x]);
            yy = Double.parseDouble(dat[i][y]);
            if (pr <= x1) {
                step1.add(xx, yy);
            }
            if (pr > x1 && pr <= x2) {
                step2.add(xx, yy);
            }
            if (pr > x2 && pr <= x3) {
                step3.add(xx, yy);
            }
            if (pr > x3 && pr <= x4) {
                step4.add(xx, yy);
            }
            if (pr > x4) {
                step5.add(xx, yy);
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
