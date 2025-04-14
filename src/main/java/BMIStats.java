import java.util.List;

public class BMIStats {
    public static void describe(List<BMIRecord> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be empty");
        }

        double sumMale = 0, sumFemale = 0;
        int countMale = 0, countFemale = 0;
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        double sumSquaresMale = 0, sumSquaresFemale = 0;

        for (BMIRecord r : data) {
            double bmi = r.getBmi();
            if (r.getGender() == 1) {
                sumMale += bmi;
                sumSquaresMale += bmi * bmi;
                countMale++;
            } else {
                sumFemale += bmi;
                sumSquaresFemale += bmi * bmi;
                countFemale++;
            }
            if (bmi < min) min = bmi;
            if (bmi > max) max = bmi;
        }

        double meanMale = sumMale / countMale;
        double meanFemale = sumFemale / countFemale;
        double stdDevMale = Math.sqrt((sumSquaresMale / countMale) - (meanMale * meanMale));
        double stdDevFemale = Math.sqrt((sumSquaresFemale / countFemale) - (meanFemale * meanFemale));

        System.out.println("BMI Statistics:");
        System.out.println("-------------------");
        System.out.printf("Male Statistics:%n");
        System.out.printf("  Mean BMI: %.2f%n", meanMale);
        System.out.printf("  Standard Deviation: %.2f%n", stdDevMale);
        System.out.printf("  Sample Size: %d%n", countMale);
        System.out.println();
        System.out.printf("Female Statistics:%n");
        System.out.printf("  Mean BMI: %.2f%n", meanFemale);
        System.out.printf("  Standard Deviation: %.2f%n", stdDevFemale);
        System.out.printf("  Sample Size: %d%n", countFemale);
        System.out.println();
        System.out.printf("Overall Statistics:%n");
        System.out.printf("  Minimum BMI: %.2f%n", min);
        System.out.printf("  Maximum BMI: %.2f%n", max);
        System.out.printf("  Total Sample Size: %d%n", data.size());
    }
}