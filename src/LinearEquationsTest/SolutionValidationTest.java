package LinearEquationsTest;

import Model.LinearEquation;
import Service.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Testing Solution
 */
class SolutionValidationTest {
    /**
     * Test should return false when number of equations is more than number of unknowns
     * This need not be a problem, You should be bale to find the answer still. Just to keep things sample..
     */
    @Test
    void shouldFailValidationIfNumberOfEquationsIsMoreThanNumberOfVariables(){
        Solution solution = new Solution();
        List<LinearEquation> problem = new ArrayList<>();
        List<Double> coefficient1 =  new ArrayList<>();
        coefficient1.add(2d);
        coefficient1.add(3d);
        problem.add(new LinearEquation(coefficient1,10.0));

        List<Double> coefficient2 =  new ArrayList<>();
        coefficient2.add(5d);
        coefficient2.add(6d);
        problem.add(new LinearEquation(coefficient2,16.0));

        List<Double> coefficient3 =  new ArrayList<>();
        coefficient3.add(1d);
        coefficient3.add(2d);
        problem.add(new LinearEquation(coefficient3,6.0));

        Assertions.assertEquals(false, solution.validateRequest(problem));
    }

    @Test
    void ShouldFailValidationIfNumberOfVariablesAreMoreThanGivenEquations(){
        Solution solution = new Solution();
        List<LinearEquation> problem = new ArrayList<>();
        List<Double> coefficient1 =  new ArrayList<>();
        coefficient1.add(2d);
        coefficient1.add(3d);
        coefficient1.add(5d);
        coefficient1.add(5d);
        problem.add(new LinearEquation(coefficient1,10.0));

        List<Double> coefficient2 =  new ArrayList<>();
        coefficient2.add(5d);
        coefficient2.add(6d);
        coefficient2.add(7d);
        coefficient2.add(1d);
        problem.add(new LinearEquation(coefficient2,16.0));

        List<Double> coefficient3 =  new ArrayList<>();
        coefficient3.add(1d);
        coefficient3.add(2d);
        coefficient3.add(4d);
        coefficient3.add(5d);
        problem.add(new LinearEquation(coefficient3,6.0));

        Assertions.assertEquals(false, solution.validateRequest(problem));
    }

    @Test
    void ShouldPasValidationIfNumberOfVariablesSameAsNumberOfGivenEquations(){
        Solution solution = new Solution();
        List<LinearEquation> problem = new ArrayList<>();
        List<Double> coefficient1 =  new ArrayList<>();
        coefficient1.add(2d);
        coefficient1.add(3d);
        coefficient1.add(5d);
        problem.add(new LinearEquation(coefficient1,10.0));

        List<Double> coefficient2 =  new ArrayList<>();
        coefficient2.add(5d);
        coefficient2.add(6d);
        coefficient2.add(7d);
        problem.add(new LinearEquation(coefficient2,16.0));

        List<Double> coefficient3 =  new ArrayList<>();
        coefficient3.add(1d);
        coefficient3.add(2d);
        coefficient3.add(4d);
        problem.add(new LinearEquation(coefficient3,6.0));

        Assertions.assertEquals(true, solution.validateRequest(problem));
    }
}