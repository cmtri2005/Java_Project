import java.util.*;

public class LinearRegressionModel {
    private double a;
    private double b;

    public void train(List<PopulationRecord> data) {
        int n = data.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;
        for (PopulationRecord r : data) {
            double x = r.getYear();
            double y = r.getPopulation();
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXX += x * x;
        }
        a = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        b = (sumY - a * sumX) / n;
    }

    public long predict(int year) {
        return Math.round(a * year + b);
    }

    public void printModel() {
        System.out.printf("📉 Mô hình hồi quy: Population = %.2f × Year + %.2f%n", a, b);
    }
}