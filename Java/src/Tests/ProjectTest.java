package Tests;

import Classes.Context;
import Composite.DoubleOperand;
import Composite.SingleOperand;
import Factories.CalculatorFactory;
import Strategies.AddCalculation;
import Strategies.DivideCalculation;
import Strategies.MultiplyCalculation;
import Strategies.SubtractCalculation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    @DisplayName("Factory pattern")
    public void factoryTest() {
        //arrange
        var object1 = CalculatorFactory.Get("+");
        var object2 = CalculatorFactory.Get("-");
        var object3 = CalculatorFactory.Get("gibberish");

        //act
        var result1 = object1.calculate(2,2);
        var result2 = object2.calculate(2,2);

        //assert
        assertEquals(result1, 4);
        assertEquals(result2, 0);
        assertNull(object3);
    }

    @Test
    @DisplayName("Strategy pattern")
    public void strategyTest() {
        //arrange
        var calculation1 = new Context(new AddCalculation());
        var calculation2 = new Context(new SubtractCalculation());
        var calculation3 = new Context(new MultiplyCalculation());
        var calculation4 = new Context(new DivideCalculation());

        //act
        var result1 = calculation1.executeStrategy(2,2);
        var result2 = calculation2.executeStrategy(5,4);
        var result3 = calculation3.executeStrategy(3,3);
        var result4 = calculation4.executeStrategy(9,3);

        //assert
        assertEquals(result1, 4);
        assertEquals(result2, 1);
        assertEquals(result3, 9);
        assertEquals(result4, 3);
    }

    @Test
    @DisplayName("Composite pattern")
    public void compositeTest() {
        //arrange
        var addContext = new Context(new AddCalculation());
        var subtractContext = new Context(new SubtractCalculation());

        var compositeTree1 = new DoubleOperand(new SingleOperand(1), addContext, new SingleOperand(2));
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
        var result1 = compositeTree1.Get();
        var result2 = compositeTree2.Get();

        //assert
        assertEquals(result1, 3);
        assertEquals(result2, 7);
    }
}