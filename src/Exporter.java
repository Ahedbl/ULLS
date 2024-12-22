import Objects.Compound;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Exporter {

    public static void printCSV(List<Compound> compoundList) throws FileNotFoundException {
        File csvFile = new File("ULLS1_complete.csv");
        PrintWriter out = new PrintWriter(csvFile);
        out.print("Time, Temperature, Variance, Standard_deviation, Average,");
        for(Compound compound: compoundList){
            out.println(compound.getTemp().getTime() + "," + compound.getTemp().getRawTemperature() + ", " + Calc.calculateVariance(compound.getAccData()));
        }
        out.close();
    }
}
