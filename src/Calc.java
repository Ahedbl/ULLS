import Objects.AccData;
import Objects.Compound;
import Objects.TempData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {

    public static void combine(){

    }

    public static List<Compound> section(List<TempData> temp, List<AccData> acc){

        List<Compound> compoundedData = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (TempData tempData : temp) {
            Compound comp = new Compound(tempData);
            //System.out.println("comparing acc: " + acc.get(j).getTime() + " and temp: " + temp.get(i).getTime());
            //while (temp.get(i).getTime().isBefore(acc.get(j).getTime()))
            while (acc.get(j).getTime().isBefore(temp.get(i).getTime())) {
                //System.out.println("yes to " + acc.get(j).getTime() + " being before " + temp.get(i).getTime());
                comp.add(acc.get(j));
                j++;
            }
            compoundedData.add(comp);
            i++;
        }
        return compoundedData;
    }
    public static double calculateAverage(List<AccData> input){
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input list is null or empty");
        }

        double sum = 0;
        for (AccData data : input) {
            sum += data.axisVector();
        }
        return sum / input.size();
    }
    public static double calculateVariance(List<AccData> input){
        if (input == null || input.isEmpty()) {
            return 0;
        }
        double varianceSum = 0;
        for (AccData data : input) {
            varianceSum += Math.pow(data.axisVector() - calculateAverage(input), 2);
        }
        return varianceSum / input.size();
    }
    private double calculateStandardDeviation(List<AccData> input){
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input list is null or empty");
        }
        return Math.sqrt(calculateAverage(input));
    }

}
