package Classes;

import Interfaces.CalculationStrategy;

public class Context {

    private CalculationStrategy strategy;

    public Context(CalculationStrategy strategy)
    {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.calculate(num1, num2);
    }

}
