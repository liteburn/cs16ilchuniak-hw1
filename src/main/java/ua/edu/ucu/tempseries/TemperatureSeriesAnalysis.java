package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] data;
    private int size;
    private int standartLen = 8;
    private int minTemperature;
    
    public TemperatureSeriesAnalysis() {
        data = new double[standartLen];
        size = 0;
        minTemperature = -273
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        int k = 0;
        minTemperature = -273
        data = new double[temperatureSeries.length];
        for (double i : temperatureSeries) {
            data[k] = i;
            if (i < minTemperature) {
                throw new InputMismatchException();
            }
            k++;
        }
        size = temperatureSeries.length;
    }

    public double average() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += data[i];
        }
        return total / size;
    }

    public double deviation() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += data[i];
        }
        double avg = total / size;
        double totaldif = 0;
        for (int i = 0; i < size; i++) {
            totaldif += Math.abs(avg - data[i]);
        }

        return totaldif / size;
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double min = data[0];
        for (int i = 0; i < size; i++) {
            if (min > data[i]) {
                min = data[i];
            }
        }
        return min;
    }

    public double max() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double max = data[0];
        for (int i = 0; i < size; i++) {
            if (max < data[i]) {
                max = data[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double closestr = Math.abs(data[0]);
        double closestl = data[0];
        int closestindr = 0;
        int closestindl = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] < 0 && Math.abs(data[i]) < Math.abs(closestl)) {
                closestl = data[i];
                closestindl = i;
            } else if (data[i] >= 0 && data[i] <= closestr) {
                closestr = data[i];
                closestindr = i;
            }
        }
        if (Math.abs(data[closestindl]) < Math.abs(data[closestindr])) {
            return data[closestindl];
        } else {
            return data[closestindr];
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double closest = data[0];
        for (int i = 0; i < size; i++) {
            double valFirst = Math.abs(data[i] - tempValue);
            double valSecond = Math.abs(closest - tempValue);
            if (valFirst <= valSecond) {
                if (valFirst < valSecond) {
                    closest = data[i];
                    System.out.println(closest);
                }
                if (data[i] > closest) {
                    closest = data[i];
                }
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int length = 0;
        for (double i : data) {
            if (i < tempValue) {
                length += 1;
            }
        }
        double[] temperatures = new double[length];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] < tempValue) {
                temperatures[k] = data[i];
                k++;
            }
        }
        return temperatures;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] >= tempValue) {
                length += 1;
            }
        }
        double[] temperatures = new double[length];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] >= tempValue) {
                temperatures[k] = data[i];
                k++;
            }
        }
        return temperatures;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        int len = data.length;
        if (len == 0) {
            len = standartLen;
        }
        while (len < temps.length + size) {
            len *= 2;
        }
        double[] newData = new double[len];
        int k = 0;
        for (int i = 0; i < size; i++) {
            newData[k] = data[i];
            k++;
        }
        for (int i = 0; i < temps.length; i++) {
            newData[k] = temps[i];
            k++;
        }
        this.data = newData;
        this.size += temps.length;
        return this.size;
    }
}
