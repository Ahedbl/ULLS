package Objects;

import java.time.LocalDate;
import java.time.LocalTime;

public class TempData {
    private String id;
    private double rawTemperature;
    private double temperature;
    private LocalDate date;
    private LocalTime time;
    private Side side;

    public TempData(String id, double rawTemperature, double temperature, LocalDate date, LocalTime time, Side side) {
        this.id = id;
        this.rawTemperature = rawTemperature;
        this.temperature = temperature;
        this.date = date;
        this.time = time;
        this.side = side;
    }

    public String getId() {
        return id;
    }

    public double getRawTemperature() {
        return rawTemperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Side getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "\n" + this.time + " temperature: " + this.temperature;
    }
}
