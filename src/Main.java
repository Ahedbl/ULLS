import Objects.AccData;
import Objects.Compound;
import Objects.TempData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<TempData> rightLeg = new ArrayList<TempData>();
        List<AccData> hip = new ArrayList<AccData>();
        List<Compound> compound = new ArrayList<Compound>();

        String file = "src\\ULLS#1 HIP (2023-04-24)1secDataTable.csv";
        String tempFile = "src\\temperature\\RIGHT_1.csv";
        BufferedReader movementReader = null;
        BufferedReader tempReader = null;
        try {
            movementReader = new BufferedReader(new FileReader(file));
            hip = Parser.parseToUnits(movementReader);
            tempReader = new BufferedReader(new FileReader(tempFile));
            rightLeg = Parser.parseTemp(tempReader);
            //System.out.println(rightLeg);

            compound = Calc.section(rightLeg, hip);
            //System.out.println(compound.toString());
            Exporter.printCSV(compound);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (movementReader != null) {
                    movementReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (tempReader != null) {
                    tempReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
