import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BMIReader {
    private static final int EXPECTED_COLUMNS = 5;
    private static final int HEIGHT_INDEX = 1;
    private static final int WEIGHT_INDEX = 2;
    private static final int BMI_INDEX = 3;
    private static final int GENDER_INDEX = 4;

    public static List<BMIRecord> read(String filePath) throws IOException {
        List<BMIRecord> data = new ArrayList<>();
        File file = new File(filePath);
        
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String header = br.readLine();
            if (header == null) {
                throw new IllegalArgumentException("File is empty");
            }
            
            String[] headerColumns = header.split(",");
            if (headerColumns.length != EXPECTED_COLUMNS) {
                throw new IllegalArgumentException("Invalid file format: expected " + EXPECTED_COLUMNS + 
                    " columns but found " + headerColumns.length);
            }
            
            String line;
            int lineNumber = 1; // Start from 1 since we already read the header
            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    String[] parts = line.split(",");
                    if (parts.length != EXPECTED_COLUMNS) {
                        System.err.printf("Warning: Line %d has incorrect number of columns. Skipping.%n", lineNumber);
                        continue;
                    }
                    
                    double height = Double.parseDouble(parts[HEIGHT_INDEX]);
                    double weight = Double.parseDouble(parts[WEIGHT_INDEX]);
                    double bmi = Double.parseDouble(parts[BMI_INDEX]);
                    int gender = Integer.parseInt(parts[GENDER_INDEX]);
                    
                    data.add(new BMIRecord(height, weight, bmi, gender));
                } catch (NumberFormatException e) {
                    System.err.printf("Warning: Invalid number format on line %d. Skipping.%n", lineNumber);
                } catch (IllegalArgumentException e) {
                    System.err.printf("Warning: Invalid data on line %d: %s. Skipping.%n", lineNumber, e.getMessage());
                }
            }
        }
        
        if (data.isEmpty()) {
            throw new IllegalArgumentException("No valid records found in the file");
        }
        
        return data;
    }
}