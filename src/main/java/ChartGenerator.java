import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

/**
 * Utility class for generating BMI-related charts and visualizations.
 */
public class ChartGenerator {
    /**
     * Creates and displays a bar chart comparing average BMI between genders.
     * @param maleAvg Average BMI for males
     * @param femaleAvg Average BMI for females
     * @throws IllegalArgumentException if any input is non-positive
     */
    public static void showBarChart(double maleAvg, double femaleAvg) {
        if (maleAvg <= 0 || femaleAvg <= 0) {
            throw new IllegalArgumentException("Average BMI values must be positive");
        }

        try {
            // Create dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(maleAvg, "BMI", "Male");
            dataset.addValue(femaleAvg, "BMI", "Female");

            // Create chart
            JFreeChart chart = ChartFactory.createBarChart(
                "Average BMI Comparison by Gender",  // Title
                "Gender",                            // X-axis label
                "BMI",                               // Y-axis label
                dataset,                             // Dataset
                PlotOrientation.VERTICAL,            // Orientation
                false,                               // Show legend
                true,                                // Show tooltips
                false                                // Show URLs
            );

            // Customize chart appearance
            chart.setBackgroundPaint(Color.white);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(Color.lightGray);
            plot.setRangeGridlinePaint(Color.white);

            // Create and display frame
            JFrame frame = new JFrame("BMI Analysis");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(new ChartPanel(chart));
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the window
            frame.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error creating chart: " + e.getMessage());
            throw new RuntimeException("Failed to create BMI comparison chart", e);
        }
    }
}