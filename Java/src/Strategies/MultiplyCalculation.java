package Strategies;

import Interfaces.CalculationStrategy;

public class MultiplyCalculation implements CalculationStrategy {
    @Override
    public int calculate(int part1, int part2) {
        return part1 * part2;
    }
}
