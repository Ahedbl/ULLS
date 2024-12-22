package Objects;

import java.util.Arrays;

public class CompactInput {
    private String amount;
    private String startTime;
    private String endTime;
    private double[] Axis1; // Vertical Axis Activity Acceleration Data (Axis 1)
    private double[] Axis2; // Horizontal Axis Activity Acceleration Data (Axis 2)
    private double[] Axis3; // Perpendicular Axis Activity Acceleration Data (Axis 3)


    public CompactInput(String amount, String startTime, String endTime, double[] axis1, double[] axis2, double[] axis3) {
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
        Axis1 = axis1;
        Axis2 = axis2;
        Axis3 = axis3;
    }



    private double calculateAverage(double[] input){

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        double sum = 0;
        for (double value : input) {
            sum += value;
        }
        return sum / input.length;
    }

    private double calculateVariance(double[] input){
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        double varianceSum = 0;
        for (double value : input) {
            varianceSum += Math.pow(value - calculateAverage(input), 2);
        }
        return varianceSum / input.length;
    }
    private double calculateStandardDeviation(double[] input){

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        return Math.sqrt(calculateAverage(input));
    }

    private double calculateMedian(double[] input){
        Arrays.sort(input);
        if (input.length % 2 == 0) {

            return (input[input.length / 2 - 1] + input[input.length / 2]) / 2.0;
        } else {
            return input[input.length / 2];
        }
    }

}
