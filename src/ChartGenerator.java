import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import javax.swing.*;
import java.util.*;

public class ChartGenerator {
    public static void displayChart(List<PopulationRecord> actualData, Map<Integer, Long> predictedData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (PopulationRecord r : actualData) {
            dataset.addValue(r.getPopulation(), "Thực tế", Integer.toString(r.getYear()));
        }
        for (Map.Entry<Integer, Long> entry : predictedData.entrySet()) {
            dataset.addValue(entry.getValue(), "Dự đoán", Integer.toString(entry.getKey()));
        }
        JFreeChart chart = ChartFactory.createLineChart(
                "Dân số Việt Nam - Thực tế vs Dự đoán",
                "Năm", "Dân số",
                dataset, PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel panel = new ChartPanel(chart);
        JFrame frame = new JFrame("Biểu đồ dân số");
        frame.setContentPane(panel);
        frame.setSize(900, 600);
        frame.setVisible(true);
    }
}