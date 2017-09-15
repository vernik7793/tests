package practics.quiz.test25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Producer заполняет буфер и ждет..
 */
public class ProducerConsumerExample_1_1000x0 {

    @Test(timeout = 30000)
    public void testProducerConsumerExample_1_1000x0() throws InterruptedException {
		BlockedBoundedArrayBuffer buffer = new BlockedBoundedArrayBuffer();
        Producer producer = new Producer(1, 1000, buffer);
        new Thread(producer,"Producer1").start();

        Thread.currentThread().sleep(15000); // даем возможность producer'у заполнить буфер

        // проверим емкость буфера
        assertEquals(buffer.getSize(), 10);

        // проверим что буфер полностью заполнен. 10 элементов, нумерация от нуля
        assertEquals(buffer.getCurrent(), 9);

        // программа заполняет буфер в 10 элементов, и producer ждет бесконечно...
	}
}