package org.mp.sesion04;

public class StackArrayTest extends AbstractStackTestCase {


    protected Stack<Integer> makeStack() {

        return new StackArray<Integer>();
    }
}
