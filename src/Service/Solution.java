package Service;

import Model.LinearEquation;

import java.util.ArrayList;
import java.util.List;

public class Solution{

    public void solverLinearEquation(List<LinearEquation> problem) {
        if(problem.size()==1 ){
            if(problem.get(0).coefficient.size() == 1){
                System.out.println((problem.get(0).value / problem.get(0).coefficient.get(0)));
            }else {
                System.out.println("Invalid");
            }
        }
        else{
            LinearEquation firstEquation = problem.remove(0);
            double coefficient = firstEquation.coefficient.remove(0);
            LinearEquation NegatedFirstEquation = negateEquationValues(divideByFirstCoefficient(firstEquation, coefficient));
            List<LinearEquation> solution = new ArrayList<>();

            for (int i = 0; i < problem.size();i++) {
                LinearEquation equation = problem.get(i);
                LinearEquation result = new LinearEquation();
                double firstCoefficient = equation.coefficient.remove(0);

                for (int j = 0; j < equation.coefficient.size(); j++) {
                    result.coefficient
                            .add(j, (firstCoefficient * NegatedFirstEquation.coefficient.get(j))+ equation.coefficient.get(j));
                }
                result.value = (firstCoefficient * NegatedFirstEquation.value) +  equation.value;
                solution.add(i,result);
            }

            solverLinearEquation(solution);
        }
    }

    public LinearEquation divideByFirstCoefficient(LinearEquation input, double firstCoefficient) {
        LinearEquation result = new LinearEquation();
        result.value = input.value == 0? 0 : input.value / firstCoefficient;
        for (int i = 0; i< input.coefficient.size(); i++){
            result.coefficient.add(i,( input.coefficient.get(i) == 0 ? 0 : (input.coefficient.get(i)/ firstCoefficient)));
        }
        return (result);
    }

    public LinearEquation negateEquationValues(LinearEquation first) {
        LinearEquation result = new LinearEquation();
        for (int i = 0; i<first.coefficient.size(); i++){
            result.coefficient.add(i,(first.coefficient.get(i)*-1));
        }
        result.value = first.value * -1;
        return result;
    }

    public Boolean validateRequest(List<LinearEquation> problem) {
        if(problem.size() == 0 )
            return true;
        return problem.size() == problem.get(0).coefficient.size();
    }

    public void solve(List<LinearEquation> problem) {
        if(!validateRequest(problem)){
            System.out.println("Validation failed");
            return;
        }
        System.out.println("Validated");
        solverLinearEquation(problem);
    }
}
