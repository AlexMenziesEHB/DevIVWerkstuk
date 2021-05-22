package Factories;

import Interfaces.CalculationStrategy;
/*delete???*/
import Strategies.AddCalculation;
import Strategies.DivideCalculation;
import Strategies.MultiplyCalculation;
import Strategies.SubtractCalculation;

public class CalculatorFactory {
    public static CalculationStrategy Get(String type){

        if (type.equalsIgnoreCase("+")){
            return new AddCalculation();
        }
        else if (type.equalsIgnoreCase("-")) {
            return new SubtractCalculation();
        }
        else if (type.equalsIgnoreCase("/")) {
            return new DivideCalculation();
        }
        else if (type.equalsIgnoreCase("*")) {
            return new MultiplyCalculation();
        }

        return null;
    }
}
