package App;

import Model.LinearEquation;
import Service.Solution;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers {
    public static void main(String []areg){
        Solution solution = new Solution();
        List<LinearEquation> problem = new ArrayList<>();
        gatherInput(problem);
        solution.solve(problem);
    }

    private static void gatherInput(List<LinearEquation> problem) {
        List<Double> coefficient1 =  new ArrayList<>();
        coefficient1.add(2d);
        coefficient1.add(3d);
        coefficient1.add(5d);
        problem.add(new LinearEquation(coefficient1,10.0));

        List<Double> coefficient2 =  new ArrayList<>();
        coefficient2.add(5d);
        coefficient2.add(6d);
        coefficient2.add(5d);
        problem.add(new LinearEquation(coefficient2,16.0));

        List<Double> coefficient3 =  new ArrayList<>();
        coefficient3.add(1d);
        coefficient3.add(2d);
        coefficient3.add(3d);
        problem.add(new LinearEquation(coefficient3,6.0));
    }
}


