import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Chart extends JPanel {


    public Chart(final String title, ArrayList<Integer> Output, int Movement) {



        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();


        final CategoryItemRenderer renderer = new BarRenderer();

        renderer.setItemLabelsVisible(true);

        final CategoryPlot plot = new CategoryPlot();
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);

        plot.setDomainAxis(new CategoryAxis("Time"));


        plot.setOrientation(PlotOrientation.HORIZONTAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);


        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();


        final CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, renderer2);


        final ValueAxis rangeAxis2 = new NumberAxis("Track Numbers:");
        plot.setRangeAxis(0, rangeAxis2);

        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        int Ycount = 0;
        for (int i: Output) {
            Ycount+=5;
            dataset3.addValue(i,"Head Position",Integer.toString(Ycount));

        }

        plot.setDataset(1, dataset3);
        final CategoryItemRenderer renderer3 = new LineAndShapeRenderer();
        plot.setRenderer(1, renderer3);
        plot.mapDatasetToRangeAxis(2, 1);

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        final JFreeChart chart = new JFreeChart(plot);
        chart.setTitle(title);

        this.setLayout(new BorderLayout());
        final ChartPanel chartPanel = new ChartPanel(chart);
        JLabel j1 = new JLabel("Total Head Movement: ");
        JLabel j2 = new JLabel("");
        j2.setText(Integer.toString(Movement));
        this.add(j2,BorderLayout.SOUTH);
        this.add(j1,BorderLayout.CENTER);
        this.add(chartPanel,BorderLayout.NORTH);
    }







}