package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;
    public TempSummaryStatistics(){
        throw new IllegalArgumentException();
    }  
    public TempSummaryStatistics(double a, double d, double min, double max){
        this.avgTemp = a;
        this.devTemp = d;
        this.maxTemp = max;
        this.minTemp = min;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
