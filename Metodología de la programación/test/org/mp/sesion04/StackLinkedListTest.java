package org.mp.sesion04;


public class StackLinkedListTest extends AbstractStackTestCase {

    protected Stack<Integer> makeStack() {

        return new StackLinkedList<Integer>();
    }
}
