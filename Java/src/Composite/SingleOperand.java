package Composite;

import Interfaces.Operand;

public class SingleOperand implements Operand {
    public int number;

    public SingleOperand(int number) {
        this.number = number;
    }

    @Override
    public int Get() {
        return this.number;
    }
}
