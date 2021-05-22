package Composite;

import Classes.Context;
import Interfaces.CalculationStrategy;
import Interfaces.Operand;

import java.util.List;

public class DoubleOperand implements Operand {
    public Operand Left;
    public Context calculation;
    public Operand Right;

    public DoubleOperand(Operand left, Context calculation, Operand right) {
        Left = left;
        this.calculation = calculation;
        Right = right;
    }

    @Override
    public int Get() {
       return calculation.executeStrategy(Left.Get(), Right.Get());
    }
}
