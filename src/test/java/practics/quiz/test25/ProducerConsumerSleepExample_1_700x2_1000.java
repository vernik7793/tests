package practics.quiz.test25;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Producer пытается добавить в буфер элемент каждую 0.7 секуднды, 
 * а 2 Comsumer'а пытаются забирать эти элементы каждую секунду,
 */
public class ProducerConsumerSleepExample_1_700x2_1000 {
    @Test(timeout = 30000)
    public void testProducerConsumerExample_1_700x2_1000() {
		BlockedBoundedArrayBuffer buffer = new BlockedBoundedArrayBuffer();
        Producer producer = new Producer(1, 700, buffer);
        new Thread(producer, "Producer1").start();
		new Thread(new Consumer(1000, buffer), "Consumer1").start();
		new Thread(new Consumer(1000, buffer), "Consumer2").start();

        // ждем пока произведется более 20 элементов
        while (producer.getValue() < 20);

        // проверяем размер буфера
        assertTrue(buffer.getSize() == 10);
        // проверяем заполненость буфера
        assertTrue(buffer.getCurrent() < 3);
	}
}