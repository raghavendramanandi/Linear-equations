package Model;

import java.util.ArrayList;
import java.util.List;

public class LinearEquation{
    public List<Double> coefficient;
    public double value;

    public LinearEquation(List<Double> coefficient1, double v) {
        coefficient = coefficient1;
        value = v;
    }

    public LinearEquation() {
        coefficient = new ArrayList<>();
        value = -1;
    }
}
