import Objects.AccData;
import Objects.Side;
import Objects.TempData;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void parse(BufferedReader reader) throws IOException {
        boolean isHeaderSkipped = false;
        String line;
        int counter = 0;
        while ((line = reader.readLine()) != null) {
            if (!isHeaderSkipped) {
                if (line.contains("Date") && line.contains("Time")) {
                    isHeaderSkipped = true; // Börja bearbeta data från och med denna rad
                }
                continue;
            }
            counter++;
            String[] row = line.split(",");
            if (row.length > 1) {
                System.out.println("Datum: " + row[0]);
                System.out.println("Tid: " + row[1]);
                System.out.println("Axis1: " + row[2]);
                System.out.println("Axis2: " + row[3]);
                System.out.println("Axis3: " + row[4]);
                System.out.println("Steps: " + row[5]);
                System.out.println("------------------------------");
            }
        }
        System.out.println(counter);
    }

    public static List<AccData> parseToUnits(BufferedReader reader) throws IOException {
        boolean isHeaderSkipped = false;
        String line;
        int counter = 0;
        List<AccData> accData = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            if (!isHeaderSkipped) {
                if (line.contains("Date") && line.contains("Time")) {
                    isHeaderSkipped = true; // Börja bearbeta data från och med denna rad
                }
                continue;
            }
            counter++;
            String[] row = line.split(",");
            if (row.length > 1) {
                String dateStr = row[0];
                String timeStr = row[1];
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateStr, dateFormatter);
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime time = LocalTime.parse(timeStr, timeFormatter);
                double axis1 = Double.parseDouble(row[2]);
                double axis2 = Double.parseDouble(row[3]);
                double axis3 = Double.parseDouble(row[4]);
                double light = Double.parseDouble(row[6]);
                accData.add(new AccData(date, time, axis1, axis2, axis3, light));
            }
        }
        System.out.println("size is " + accData.size());
        System.out.println("First input: " + accData.get(0).toString());
        System.out.println("Last input: " + accData.get(accData.size()-1).toString());
        return accData;
    }

    public static List<TempData> parseTemp(BufferedReader reader) throws IOException {
        boolean isHeaderSkipped = false;
        String line;
        List<TempData> tempData = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            if (!isHeaderSkipped) {
                isHeaderSkipped = true; // Skip the first line (header)
                continue;
            }
            String[] row = line.split(",");
            if (row.length > 5) { // Ensure enough columns exist
                try {
                    String patientName = row[0];
                    String dateStr = row[1];
                    String timeStr = row[2];
                    double rawTemp = Double.parseDouble(row[3]);
                    double processedTemp = Double.parseDouble(row[4]);

                    // Parse date and time
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(dateStr, dateFormatter);

                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
                    LocalTime time = LocalTime.parse(timeStr, timeFormatter);

                    // Add parsed data to the list
                    tempData.add(new TempData(patientName, rawTemp, processedTemp, date, time, Side.RIGHT));
                } catch (Exception e) {
                    System.err.println("Error parsing row: " + line + ". Skipping.");
                }
            }
        }

        // Debugging output
        System.out.println("Total rows parsed: " + tempData.size());
        if (!tempData.isEmpty()) {
            System.out.println("First entry: " + tempData.get(0));
            System.out.println("Last entry: " + tempData.get(tempData.size() - 1));
        }
        return tempData;
    }

}
