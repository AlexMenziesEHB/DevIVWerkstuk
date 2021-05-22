package Classes;

import Interfaces.CalculationStrategy;

/*context heeft een functie execute strategy*/
public class Context {
    /*Strategy kan verschillende verwerkings mogelijkheden zijn, in dit geval
     * kan dit addcalculation, devide,... zijn*/
    private CalculationStrategy strategy; /*voor result 1 weten we dat dit een addcalculation is*/
    /*classe heeft een property van het type CalculationStrategy */


    public Context(CalculationStrategy strategy)
        /*Calculation startegy wordt addcalulation omdat dit wordt doorgegeven van de test in de constructor*/
    {
        this.strategy = strategy; /*Constructore houd het bij als een property*/
    }



    public int executeStrategy(int num1, int num2){
        /* met execute stagey geven we de waarde mee die wij meenemen uit de test (Result 1)*/
        return strategy.calculate(num1, num2);
        /*neem de 2 properties mee en roep hier de calulate functie op met de strategy die ik heb meegegeven */
        /* Nadien gaat hij naar addcalulation (Result1) omdat dit de startegy is die hij meegeeft*/
    }
    /* Door startegy te doen kan stategy in context bestaan uit addcalulation, divide,...*/

}
