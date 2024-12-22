package Objects;

import Objects.AccData;
import Objects.TempData;

import java.util.ArrayList;
import java.util.List;

public class Compound {
    final private TempData temp;
    private List<AccData> accData;

    public Compound(TempData temp) {
        this.temp = temp;
        accData = new ArrayList<>();
    }
    public void add(AccData acc){
        accData.add(acc);
    }
    public int size(){
        return accData.size();
    }

    public TempData getTemp() {
        return temp;
    }

    public List<AccData> getAccData() {
        return accData;
    }

    @Override
    public String toString() {
        return temp + " amount: " + this.size() + " accData=" + accData;
    }
}
