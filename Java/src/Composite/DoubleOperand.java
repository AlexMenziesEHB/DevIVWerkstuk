package Composite;

import Classes.Context;
import Interfaces.CalculationStrategy;
import Interfaces.Operand;

import java.util.List;

/*Splitst af in verschillende wegen*/
public class DoubleOperand implements Operand { /*Implementeerd get functie*/
    public Operand Left;
    public Context calculation;
    public Operand Right;

    /*Tree1: Operand left wordt 1, operand right wordt 2 en calulation wordt add caluclation*/
    public DoubleOperand(Operand left, Context calculation, Operand right) {
        Left = left;
        this.calculation = calculation;
        Right = right;
    }

    @Override
    /*Door get te doen krijg je het resultaat*/
    public int Get() {
       return calculation.executeStrategy(Left.Get(), Right.Get());
    }
    /*Roept 2 keer de get aan*/
    /*calculation is de context die wij hebben meegegeven, de property van de doubleoperand
    * en dan zeggen we executestrategy op de left.get en right.get,
    * kan een doubleoperand zijn maar bij de eerste test is het een single dus een getal
    * Bij executestartegy geeft hij dan 1 + 2 mee en weet het dat het een addcalulation is dus wordt het 3*/

    /*Door get te gebruiken spreekt het zijneigen constant aan waardoor ge in loops kunt blijven gaan met doubleoperand
    * in een andere double operand in een andere double opperand*/
}
