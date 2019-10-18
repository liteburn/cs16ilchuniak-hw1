package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    double[] arr1 = {-3.0, 4.0, 5.0, 7.0};
    double[] arr2 = {-3.0, 3.0, -5.0, -7.0};
    double[] arr3 = {-1.0};
    double[] arr4 = {-3.0, -3.0, -3.0, -3.0};
    private TemperatureSeriesAnalysis array1 = new TemperatureSeriesAnalysis(arr1);
    private TemperatureSeriesAnalysis array2 = new TemperatureSeriesAnalysis(arr2);
    private TemperatureSeriesAnalysis array3 = new TemperatureSeriesAnalysis(arr3);
    private TemperatureSeriesAnalysis array4 = new TemperatureSeriesAnalysis(arr4);

    @Test(expected = InputMismatchException.class)
    public void testMassiveIsNotValid() {
        double[] temperatureSeries = {4.27, -284.0, -293.23, -12.4, -4.03, 5.12};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElement() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage1() {
        double expected = 3.25;
        double actual = array1.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverage2() {
        double expected = -3.0;
        double actual = array2.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverage3() {
        double expected = -1.0;
        double actual = array3.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverage4() {
        double expected = -3.0;
        double actual = array4.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation1() {
        double expected = 3.125;
        double actual = array1.deviation();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testDeviation2() {
        double expected = 3.0;
        double actual = array2.deviation();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testDeviation3() {
        double expected = 0.0;
        double actual = array3.deviation();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testDeviation4() {
        double expected = 0.0;
        double actual = array4.deviation();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMin1() {
        double expected = -3.0;
        double actual = array1.min();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMin2() {
        double expected = -7.0;
        double actual = array2.min();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMin3() {
        double expected = -1.0;
        double actual = array3.min();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMin4() {
        double expected = -3.0;
        double actual = array4.min();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testMax1() {
        double expected = 7.0;
        double actual = array1.max();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMax2() {
        double expected = 3.0;
        double actual = array2.max();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMax3() {
        double expected = -1.0;
        double actual = array3.max();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMax4() {
        double expected = -3.0;
        double actual = array4.max();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero1() {
        double expected = -3.0;
        double actual = array1.findTempClosestToZero();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero2() {
        double expected = 3.0;
        double actual = array2.findTempClosestToZero();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero3() {
        double expected = -1.0;
        double actual = array3.findTempClosestToZero();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero4() {
        double expected = -3.0;
        double actual = array4.findTempClosestToZero();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(2);
        ;
    }

    @Test
    public void testFindTempClosestToValue1() {
        double expected = 4.0;
        double actual = array1.findTempClosestToValue(0.5);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue2() {
        double expected = -5.0;
        double actual = array2.findTempClosestToValue(-6.0);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue3() {
        double expected = -1.0;
        double actual = array3.findTempClosestToValue(5.0);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue4() {
        double expected = -3.0;
        double actual = array4.findTempClosestToValue(-4.0);
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsLessThen(4);
        ;
    }

    @Test
    public void testFindTempsLessThen1() {
        double[] expected = {-3.0};
        double[] actual = array1.findTempsLessThen(0.5);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsLessThen2() {
        double[] expected = {-3.0, -5.0, -7.0};
        double[] actual = array2.findTempsLessThen(3.0);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsLessThen3() {
        double[] expected = {-1.0};
        double[] actual = array3.findTempsLessThen(-0.9);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsLessThen4() {
        double[] expected = {};
        double[] actual = array4.findTempsLessThen(-3.0);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsGreaterThen(4);
        ;
    }

    @Test
    public void testFindTempsGreaterThen1() {
        double[] expected = {4.0, 5.0, 7.0};
        double[] actual = array1.findTempsGreaterThen(4);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen2() {
        double[] expected = {-3.0, 3.0};
        double[] actual = array2.findTempsGreaterThen(-3.0);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen3() {
        double[] expected = {-1};
        double[] actual = array3.findTempsGreaterThen(-1.0);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen4() {
        double[] expected = {};
        double[] actual = array4.findTempsGreaterThen(0.0);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        TempSummaryStatistics elem = array1.summaryStatistics();
        assertEquals(3.25, elem.getAvgTemp(), 0.00001);
        assertEquals(-3.0, elem.getMinTemp(), 0.00001);
        assertEquals(7.0, elem.getMaxTemp(), 0.00001);
        assertEquals(3.125, elem.getDevTemp(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithNoElements() {
        double[] arr = {};
        TemperatureSeriesAnalysis item = new TemperatureSeriesAnalysis();
        TempSummaryStatistics elem = item.summaryStatistics();
    }

    @Test
    public void testAddTempsWithNoElements() {
        double[] newarray = {4.0, 6.0};
        TemperatureSeriesAnalysis item = new TemperatureSeriesAnalysis();
        int len = item.addTemps(newarray);
        TempSummaryStatistics newone = item.summaryStatistics();
        assertEquals(len, 2, 0.0001);
        assertEquals(newone.getDevTemp(), 1.0, 0.00001);
        assertEquals(newone.getMinTemp(), 4.0, 0.00001);
        assertEquals(newone.getMaxTemp(), 6.0, 0.00001);
        assertEquals(newone.getAvgTemp(), 5.0, 0.00001);
    }


    @Test
    public void testAddTemps() {
        double[] arr = {2.0, 4.0};
        double[] newarray = {4.0, 6.0};
        TemperatureSeriesAnalysis item = new TemperatureSeriesAnalysis(arr);
        int len = item.addTemps(newarray);
        TempSummaryStatistics newone = item.summaryStatistics();
        assertEquals(len, 4, 0.0001);
        assertEquals(newone.getDevTemp(), 1.0, 0.00001);
        assertEquals(newone.getMinTemp(), 2.0, 0.00001);
        assertEquals(newone.getMaxTemp(), 6.0, 0.00001);
        assertEquals(newone.getAvgTemp(), 4.0, 0.00001);
    }
}
