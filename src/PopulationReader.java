import java.io.*;
import java.util.*;

public class PopulationReader {
    public static List<PopulationRecord> read(String filePath) throws IOException {
        List<PopulationRecord> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty() || line.startsWith("Year")) continue;
            String[] parts = line.split(",");
            int year = Integer.parseInt(parts[0]);
            long population = Long.parseLong(parts[1]);
            data.add(new PopulationRecord(year, population));
        }
        br.close();
        return data;
    }
}