package Objects;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class AccData {
    private final LocalDate date;
    private final LocalTime time;
    private final double Axis1; // Vertical Axis Activity Acceleration Data (Axis 1)
    private final double Axis2; // Horizontal Axis Activity Acceleration Data (Axis 2)
    private final double Axis3; // Perpendicular Axis Activity Acceleration Data (Axis 3)
    private final double light;

    public AccData(LocalDate date, LocalTime time, double axis1, double axis2, double axis3, double light) {
        this.date = date;
        this.time = time;
        Axis1 = axis1;
        Axis2 = axis2;
        Axis3 = axis3;
        this.light = light;
    }

    @Override
    public String toString() {
        return "\n" + "time= " + time + " vector: " + axisVector() ;
    }
    public double axisVector(){
        return Math.sqrt((this.Axis1 * this.Axis1) + (this.Axis2 * this.Axis2) + (this.Axis3 * this.Axis3));
    }
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getAxis1() {
        return Axis1;
    }

    public double getAxis2() {
        return Axis2;
    }

    public double getAxis3() {
        return Axis3;
    }

    public double getLight() {
        return light;
    }
}
