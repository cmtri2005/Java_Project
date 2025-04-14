import java.util.List;

/**
 * Implements a multiple linear regression model for BMI prediction.
 * The model predicts BMI based on height and weight using the equation:
 * BMI = a * height + b * weight + c
 */
public class LinearRegressionModel {
    private double a, b, c;
    private double rSquared;
    private double mse;

    /**
     * Trains the linear regression model using the provided data.
     * @param data List of BMIRecord objects for training
     * @throws IllegalArgumentException if data is null, empty, or contains invalid values
     */
    public void train(List<BMIRecord> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be empty");
        }
        if (data.size() < 3) {
            throw new IllegalArgumentException("Need at least 3 data points for regression");
        }

        int n = data.size();
        double sumX1 = 0, sumX2 = 0, sumY = 0;
        double sumX1Y = 0, sumX2Y = 0, sumX1X2 = 0;
        double sumX1Sq = 0, sumX2Sq = 0, sumYSq = 0;

        for (BMIRecord r : data) {
            double x1 = r.getHeight();
            double x2 = r.getWeight();
            double y = r.getBmi();
            
            sumX1 += x1;
            sumX2 += x2;
            sumY += y;
            sumX1Y += x1 * y;
            sumX2Y += x2 * y;
            sumX1X2 += x1 * x2;
            sumX1Sq += x1 * x1;
            sumX2Sq += x2 * x2;
            sumYSq += y * y;
        }

        // Calculate coefficients using normal equations
        double denominator = n * sumX1Sq * sumX2Sq + 2 * sumX1 * sumX2 * sumX1X2 
                          - sumX1Sq * sumX2 * sumX2 - sumX2Sq * sumX1 * sumX1 
                          - n * sumX1X2 * sumX1X2;

        if (Math.abs(denominator) < 1e-10) {
            throw new IllegalArgumentException("Data is collinear, cannot perform regression");
        }

        a = (n * sumX1Y * sumX2Sq + sumX2 * sumX1X2 * sumY + sumX1 * sumX2Y * sumX2
           - sumX1 * sumX2Sq * sumY - sumX2 * sumX2 * sumX1Y - n * sumX2Y * sumX1X2) / denominator;

        b = (n * sumX2Y * sumX1Sq + sumX1 * sumX1X2 * sumY + sumX2 * sumX1Y * sumX1
           - sumX2 * sumX1Sq * sumY - sumX1 * sumX1 * sumX2Y - n * sumX1Y * sumX1X2) / denominator;

        c = (sumY - a * sumX1 - b * sumX2) / n;

        // Calculate model evaluation metrics
        double ssTotal = sumYSq - (sumY * sumY) / n;
        double ssResidual = 0;
        
        for (BMIRecord r : data) {
            double predicted = predict(r.getHeight(), r.getWeight());
            double residual = r.getBmi() - predicted;
            ssResidual += residual * residual;
        }
        
        mse = ssResidual / n;
        rSquared = 1 - (ssResidual / ssTotal);
    }

    /**
     * Predicts BMI based on height and weight.
     * @param height Height in inches
     * @param weight Weight in kilograms
     * @return Predicted BMI value
     * @throws IllegalArgumentException if height or weight is non-positive
     */
    public double predict(double height, double weight) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        return a * height + b * weight + c;
    }

    /**
     * Prints the model equation and evaluation metrics.
     */
    public void printModel() {
        System.out.println("\n🔍 Linear Regression Model:");
        System.out.println("---------------------------");
        System.out.printf("BMI = %.4f * Height + %.4f * Weight + %.4f%n", a, b, c);
        System.out.printf("R-squared: %.4f%n", rSquared);
        System.out.printf("Mean Squared Error: %.4f%n", mse);
        System.out.printf("Root Mean Squared Error: %.4f%n", Math.sqrt(mse));
    }
}