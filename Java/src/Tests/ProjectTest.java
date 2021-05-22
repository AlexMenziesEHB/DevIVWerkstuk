package Tests;

import Classes.Context;
import Composite.DoubleOperand;
import Composite.SingleOperand;
import Factories.CalculatorFactory;
import Strategies.AddCalculation;
import Strategies.DivideCalculation;
import Strategies.MultiplyCalculation;
import Strategies.SubtractCalculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    @DisplayName("Factory pattern") /*Om te weten welke test je uitvoert komt in console*/
    public void factoryTest() {
        //arrange
        var object1 = CalculatorFactory.Get("+");
        /*Ge spreekt eerst u factory aan, ge spreekt dan de get fucntie aan en geeft daarbij een plus,
        dit wordt aan het einde een addcalculation*/
        var object2 = CalculatorFactory.Get("-");
        var object3 = CalculatorFactory.Get("gibberish");/*Geen bedrag wordt 0*/

        //act
        var result1 = object1.calculate(2,2);
        /*Hier gaan we de calculate op aan spreken, als we naar object1 gaan weten we dat het een addcalculation is,
        kijken naar addcalculation
        object 1 gaat van het type calculate strategy zijn en die heeft een calculate functie*/
        var result2 = object2.calculate(2,2);

        //assert
        assertEquals(result1, 4); /*Resultaten*/
        assertEquals(result2, 0);
        assertNull(object3);
    }

    @Test
    @DisplayName("Strategy pattern")
    /*Plug and play code kunt invullen*/
    public void strategyTest() {
        //arrange
        var calculation1 = new Context(new AddCalculation());
        /* Variabele aanmaken met daarin new context, dus we maken een object context aan en
        daarbij geven we een nieuwe classe aan (new addcalculation) aan de classe context
        NEXT NAAR CONTEXT*/
        var calculation2 = new Context(new SubtractCalculation());
        var calculation3 = new Context(new MultiplyCalculation());
        var calculation4 = new Context(new DivideCalculation());
        /* We maken hier 4 van die contexten aan met elk een andere stategy */

        //act
        var result1 = calculation1.executeStrategy(2,2);
        /*context eerst weer bekijken van calculation 1 en geeft een executestategy mee met 2 waarden*/
        var result2 = calculation2.executeStrategy(5,4);
        var result3 = calculation3.executeStrategy(3,3);
        var result4 = calculation4.executeStrategy(9,3);
        /* :Int = soort van return van waarde */

        //assert
        assertEquals(result1, 4);
        assertEquals(result2, 1);
        assertEquals(result3, 9);
        assertEquals(result4, 3);
    }

    @Test
    @DisplayName("Composite pattern")
    /*Begint met een classe en is van een type en ge moet een Get functie gebruiken
    * GA DAN NAAR OPERAND INTERFACE*/
    /*Composite kan een eindpunt zijn of iets dat aftakt in verrschillende wegen*/
    public void compositeTest() {
        //arrange
        /*Hetzelfde als boven*/
        var addContext = new Context(new AddCalculation());
        /*Variabele aanmaken met daarin new context, dus we maken een object context aan en
        daarbij geven we een nieuwe classe aan (new addcalculation) aan de classe context*/
        var subtractContext = new Context(new SubtractCalculation());

        /*Begint altijd met een doubleOperand ands is het geen composite*/
        /*Tree1: maar eerst een doubleoperand aan, met een singleO met 1, een singleO met 2 en ik tel het op met addcontext,
        kijk naar double operand voor meer info*/
        var compositeTree1 = new DoubleOperand(new SingleOperand(1), addContext, new SingleOperand(2));
        /*Tree2 hetzelfde als hier boven maar door double te gebruiken kan het blijven loopen door code*/
        var compositeTree2 =
                new DoubleOperand(
                    new DoubleOperand(
                        new SingleOperand(5),
                        addContext,
                        new SingleOperand(10)
                    ),
                    subtractContext,
                    new DoubleOperand(
                        new SingleOperand(24),
                        subtractContext,
                        new DoubleOperand(
                            new SingleOperand(8),
                            addContext,
                            new SingleOperand(8)
                        )
                    )
                );

        //act
        /*Zijn beide operand om een get op te kunnen roepen*/
        var result1 = compositeTree1.Get();
        var result2 = compositeTree2.Get();

        //assert
        assertEquals(result1, 3);
        assertEquals(result2, 7);
    }
}