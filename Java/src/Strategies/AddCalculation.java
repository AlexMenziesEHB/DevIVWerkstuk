package Strategies;

import Interfaces.CalculationStrategy;

public class AddCalculation implements CalculationStrategy {
    /*Werd afgedwongen door calulate*/
    @Override /*Verplicht omdat we met de interfaces werken*/
    public int calculate(int part1, int part2) {
        return part1 + part2;
    }
    /*Heeft een calculate functie en werd afgedwongen door onze interface*/
    /*Telt nummer 1 plus nummer 2 op en returnd het terug naar de test*/
}