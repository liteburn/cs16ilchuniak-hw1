package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private static double[] data;
    private static int size;
    public TemperatureSeriesAnalysis() {
        data = new double[8];
        size = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        int k = 0;
        data = new double[temperatureSeries.length];
        for (double i: temperatureSeries){
            data[k] = i;
            if (i < -273){
                throw new InputMismatchException();
            }
            k++;
        }
        size = data.length;
    }

    public double average() {
        if (size == 0){
            throw new IllegalArgumentException();
        }
        double total = 0;
        for (int i = 0; i < size; i++){
            total += data[i];
        }
        return total/size;
    }

    public double deviation() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double total = 0;
        for (int i = 0; i < size; i++){
            total += data[i];
        }
        double avg = total/size;
        double totaldif = 0;
        for (int i = 0; i < size; i++){
            totaldif += Math.abs(avg - data[i]);
        }

        return totaldif/size;
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double min = data[0];
        for (int i = 0; i < size; i++){
            if (min > data[i]){
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
        for (int i = 0; i < size; i++){
            if (max < data[i]){
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
        for (int i = 0; i < size; i++){
            if (data[i] < 0 && Math.abs(data[i]) < Math.abs(closestl)) {
                closestl = data[i];
                closestindl = i;
            }
            else if (data[i] >= 0 && data[i] < closestr){
                closestr = data[i];
                closestindr = i;
            }
        }
        if (Math.abs(data[closestindl]) < Math.abs(data[closestindr])){
            return data[closestindl];
        }
        else{
            return data[closestindr];
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double closestr = Math.abs(data[0]);
        double closestl = data[0];
        int closestindr = 0;
        int closestindl = 0;
        for (int i = 0; i < size; i++){
            if (data[i] < tempValue && Math.abs(data[i] - tempValue) < Math.abs(closestl - tempValue)) {
                System.out.println(data[i]);
                closestl = data[i];
                closestindl = i;
            }
            else if (data[i] >= tempValue && Math.abs(data[i] - tempValue) <= Math.abs(closestr - tempValue)){

                closestr = data[i];
                closestindr = i;
            }
        }
        if (Math.abs(closestl - tempValue) < Math.abs(closestr - tempValue)){
            return data[closestindl];
        }
        else{
            return data[closestindr];
        }
    }

    public double[] findTempsLessThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int length = 0;
        for (double i: data){
            if (i < tempValue){
                length += 1;
            }
        }
        double[] temperatures = new double[length];
        int k = 0;
        for (int i = 0; i < size; i++){
            if (data[i] < tempValue){
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
        for (int i = 0; i < size; i++){
            if (data[i] >= tempValue){
                length += 1;
            }
        }
        double[] temperatures = new double[length];
        int k = 0;
        for (int i = 0; i < size; i++){
            if (data[i] >= tempValue){
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
        while (len < temps.length){
            len *=2;
        }
        double[] data1 = new double[len];
        int k = 0;
        for (int i = 0; i < size; i++){
            data1[k] = data[i];
            k++;
        }
        for (int i = 0; i < size; i++){
            data1[k] = data[i];
            k++;
        }
        data = data1;
        size += temps.length;
        return size;
    }
}
