package practics.quiz.test25;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Producer пытается добавить каждую секунду элемент в буфер,
 * а Consumer пытается забрать каждую секунду элемент из буфера
 */
public class ProducerConsumerExample_1_1000x1_1000 {
	//public static void main(String[] args) {

    @Test(timeout = 30000)
    public void testProducerConsumerExample_1_1000x1_1000() {
		BlockedBoundedArrayBuffer buffer = new BlockedBoundedArrayBuffer();
        Producer producer = new Producer(1, 1000, buffer);
        new Thread(producer, "Producer1").start();
		new Thread(new Consumer(1000, buffer), "Consumer1").start();

        // ждем пока произведется более 20 элементов
        while (producer.getValue() < 20);

        // проверяем размер буфера
        assertTrue(buffer.getSize() == 10);
        // проверяем заполненость буфера
        assertTrue(buffer.getCurrent() < 3);
	}
}