/**
 * Represents a BMI record with height, weight, BMI value and gender information.
 */
public class BMIRecord {
    private final double height;
    private final double weight;
    private final double bmi;
    private final int gender;

    /**
     * Creates a new BMI record.
     * @param height Height in inches
     * @param weight Weight in kilograms
     * @param bmi BMI value
     * @param gender Gender (1 for male, 0 for female)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public BMIRecord(double height, double weight, double bmi, int gender) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        if (bmi <= 0) {
            throw new IllegalArgumentException("BMI must be positive");
        }
        if (gender != 0 && gender != 1) {
            throw new IllegalArgumentException("Gender must be 0 (female) or 1 (male)");
        }
        
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.gender = gender;
    }

    public double getHeight() { return height; } //Return height inches

    public double getWeight() { return weight; } //Return weight in kilograms

    public double getBmi() { return bmi; }  //BMI value

    public int getGender() { return gender; } //Return 1 if male - 0 if female
}