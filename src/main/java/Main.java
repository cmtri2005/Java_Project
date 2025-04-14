import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Main class for BMI analysis application.
 * This program reads BMI data from a CSV file, performs statistical analysis,
 * generates visualizations, and creates a predictive model.
 */
public class Main {
    private static final String DATA_FILE = "data/bmi_data.csv";

    /**
     * Main entry point of the application.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            System.out.println("BMI Analysis and Predict");
            System.out.println("---------------------------");
            
            // Read and validate data
            System.out.println("Import data from " + DATA_FILE + "...");
            List<BMIRecord> data = BMIReader.read(DATA_FILE);
            System.out.printf("Successfully loaded %d records%n", data.size());
            
            // Perform statistical analysis
            System.out.println("Calculating statistics...");
            BMIStats.describe(data);
            
            // Calculate average BMI by gender
            System.out.println("average BMI by gender...");
            double maleSum = 0, femaleSum = 0;
            int maleCount = 0, femaleCount = 0;
            for (BMIRecord r : data) {
                if (r.getGender() == 1) {
                    maleSum += r.getBmi();
                    maleCount++;
                } else {
                    femaleSum += r.getBmi();
                    femaleCount++;
                }
            }
            
            // Generate visualization
            System.out.println("Dataset visualization...");
            ChartGenerator.showBarChart(maleSum / maleCount, femaleSum / femaleCount);
            
            // Train and evaluate predictive model
            System.out.println("\nTrain bmi linear regression model...");
            LinearRegressionModel model = new LinearRegressionModel();
            model.train(data);
            model.printModel();
            
            // Make sample prediction
            System.out.println("Predict BMI");
            double[][] testCases = {
                {70.0, 11.0},  
                {65.0, 60.0},  
                {72.0, 80.0},  
                {68.0, 70.0}   
            };

            for (double[] testCase : testCases) {
                double height = testCase[0];
                double weight = testCase[1];
                double predictedBMI = model.predict(height, weight);
                System.out.printf("For height %.1f inches and weight %.1f kg:\n", height, weight);
                System.out.printf("Predicted BMI: %.2f\n", predictedBMI);
                System.out.println("-------------------");
            }

            
        } catch (FileNotFoundException e) {
            System.err.println("Error: Data file not found: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}