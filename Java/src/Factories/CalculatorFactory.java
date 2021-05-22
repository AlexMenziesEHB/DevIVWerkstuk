package Factories;

import Interfaces.CalculationStrategy;
/*delete???*/
import Strategies.AddCalculation;
import Strategies.DivideCalculation;
import Strategies.MultiplyCalculation;
import Strategies.SubtractCalculation;

public class CalculatorFactory {
    public static CalculationStrategy Get(String type){

        /*String staat voor +, -, ; of ? dit komt binnen samen door de get van 1 van de testen*/


        if (type.equalsIgnoreCase("+")){
            return new AddCalculation();
        }
        /*is het een + dan return addCalculation*/
        else if (type.equalsIgnoreCase("-")) {
            return new SubtractCalculation();
        }
        /*is het een - dan return addCalculation*/
        else if (type.equalsIgnoreCase("/")) {
            return new DivideCalculation();
        }
        else if (type.equalsIgnoreCase("*")) {
            return new MultiplyCalculation();
        }

        return null;
    }
}
