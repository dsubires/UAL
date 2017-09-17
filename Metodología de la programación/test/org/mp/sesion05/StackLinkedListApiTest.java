package org.mp.sesion05;


public class StackLinkedListApiTest extends AbstractStackTestCase {

    protected Stack<Integer> makeStack() {

        return new StackLinkedListApi<Integer>();
    }
}
