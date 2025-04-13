public class PopulationRecord {
    private int year;
    private long population;

    public PopulationRecord(int year, long population) {
        this.year = year;
        this.population = population;
    }

    public int getYear() {
        return year;
    }

    public long getPopulation() {
        return population;
    }
}