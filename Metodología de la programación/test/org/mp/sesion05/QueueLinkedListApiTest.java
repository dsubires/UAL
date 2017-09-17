package org.mp.sesion05;


public class QueueLinkedListApiTest extends AbstractQueueTestCase {

    protected Queue<Integer> makeQueue() {
        return new QueueLinkedListApi<Integer>();
    }

}
