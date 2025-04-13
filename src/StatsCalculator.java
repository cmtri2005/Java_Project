import java.util.*;

public class StatsCalculator {
    public static void printStats(List<PopulationRecord> data) {
        long total = 0, max = Long.MIN_VALUE, min = Long.MAX_VALUE;
        for (PopulationRecord r : data) {
            long p = r.getPopulation();
            total += p;
            if (p > max) max = p;
            if (p < min) min = p;
        }
        double avg = total * 1.0 / data.size();
        System.out.println("📈 Thống kê dân số:");
        System.out.printf("- Trung bình: %,f%n", avg);
        System.out.printf("- Cao nhất: %,d%n", max);
        System.out.printf("- Thấp nhất: %,d%n", min);
    }
}