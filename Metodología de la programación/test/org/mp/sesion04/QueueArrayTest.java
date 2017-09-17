package org.mp.sesion04;


public class QueueArrayTest extends AbstractQueueTestCase {

    protected Queue<Integer> makeQueue() {
        return new QueueArray<Integer>();
    }
}
