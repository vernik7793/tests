package practics.quiz.test26;

import org.junit.Test;

/**
 * Одинокий Производитель не ждет вечно
 *
 */
public class SingleProducerBufferTimedTest {

    @Test (timeout = 3000)
    public void testSingleProducerBufferTimed() {
		SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        Thread producer = new Thread(new ProducerTimed(1, 1000, buffer, 100));
        producer.start();

        while(producer.getState() != Thread.State.TERMINATED);
        // Зависания не должно быть.
        // Работа программы завершается по time out!
	}
}