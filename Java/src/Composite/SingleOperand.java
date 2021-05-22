package Composite;

import Interfaces.Operand;

/*Eindpunt*/
public class SingleOperand implements Operand { /*Implementeerd get functie*/
    public int number;

    public SingleOperand(int number) {
        this.number = number;
    }

    @Override
    /*Door get te doen krijg je het resultaat*/
    public int Get() {
        return this.number;
    }
    /*Returnd gewoon een nummer omdat het niet verder kan gaan in een double*/
}
