package LinearEquationsTest;

import Model.LinearEquation;
import Service.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void shouldBeAbleToGiveNegationOfEquation(){
        LinearEquation linearEquation = new LinearEquation();
        linearEquation.coefficient.add(3d);
        linearEquation.coefficient.add(2d);
        linearEquation.coefficient.add(1d);
        linearEquation.coefficient.add(0d);
        linearEquation.coefficient.add(-2d);
        linearEquation.value = 5d;

        Solution solution = new Solution();
        LinearEquation result = solution.negateEquationValues(linearEquation);

        Assertions.assertEquals(-3d, (double) result.coefficient.get(0));
        Assertions.assertEquals(-2d, (double) result.coefficient.get(1));
        Assertions.assertEquals(-1d, (double) result.coefficient.get(2));
        Assertions.assertEquals(-0d, (double) result.coefficient.get(3)); //LOL Negative zero
        Assertions.assertEquals(2d, (double) result.coefficient.get(4));

        Assertions.assertEquals(-5d, result.value);
    }

    @Test
    void shouldBeAbleToDivideByFirstCoefficient(){
        double firstCoefficient = 2;
        LinearEquation linearEquation = new LinearEquation();
        linearEquation.coefficient.add(2d);
        linearEquation.coefficient.add(4d);
        linearEquation.coefficient.add(-2d);
        linearEquation.coefficient.add(-4d);
        linearEquation.coefficient.add(0d);
        linearEquation.value = 4;
        LinearEquation result = new Solution().divideByFirstCoefficient(linearEquation, firstCoefficient);

        Assertions.assertEquals(1d, (double) result.coefficient.get(0));
        Assertions.assertEquals(2d, (double) result.coefficient.get(1));
        Assertions.assertEquals(-1d, (double) result.coefficient.get(2));
        Assertions.assertEquals(-2d, (double) result.coefficient.get(3));
        Assertions.assertEquals(0d, (double) result.coefficient.get(4));
        Assertions.assertEquals(2d, result.value);
    }
}