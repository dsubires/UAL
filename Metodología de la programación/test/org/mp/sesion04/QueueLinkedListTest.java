package org.mp.sesion04;


public class QueueLinkedListTest extends AbstractQueueTestCase {

    protected Queue<Integer> makeQueue() {
        return new QueueLinkedList<Integer>();
    }

}
