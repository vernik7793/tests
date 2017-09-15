package practics.quiz.test24;

import org.junit.Test;

/**
 * Система с одним производителем и одним потребителем
 * вроде работает нормально...
 *
 */
public class ProducerConsumerExample_1x1 {

    // Условно считаем, что если за 30 секунд работы
    // удалось произвести 10000 элементов, то зацикливания нет
    @Test(timeout = 30000)
    public void testProducerConsumer_1x1() {
		SingleElementBuffer buffer = new SingleElementBuffer();
		Consumer consumer = new Consumer(buffer);
        Producer producer = new Producer(1, 1, buffer);
        new Thread(producer).start();
		new Thread(consumer).start();

        // ждем пока произведется более 10000 элементов
        while (producer.getValue() < 10000);
	}
}