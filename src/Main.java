import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<PopulationRecord> data = PopulationReader.read("data/population.csv");
            StatsCalculator.printStats(data);
            LinearRegressionModel model = new LinearRegressionModel();
            model.train(data);
            model.printModel();
            int[] futureYears = {2025, 2030, 2035};
            Map<Integer, Long> predictedData = new HashMap<>();
            for (int year : futureYears) {
                long predicted = model.predict(year);
                predictedData.put(year, predicted);
                System.out.printf("📅 Dự đoán dân số năm %d: %,d người%n", year, predicted);
            }
            ChartGenerator.displayChart(data, predictedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}