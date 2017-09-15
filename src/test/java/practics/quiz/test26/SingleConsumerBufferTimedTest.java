package practics.quiz.test26;

import org.junit.Test;

/**
 * Одинокий Потребитель не ждет вечно
 *
 */
public class SingleConsumerBufferTimedTest {

    @Test(timeout = 5000)
    public void testSingleConsumerBufferTimed() throws InterruptedException {
    	SingleElementBufferTimed buffer = new SingleElementBufferTimed();
        Thread consumer = new Thread(new ConsumerTimed(buffer, 3000), "Consumer");
        consumer.start();

        while(consumer.getState() != Thread.State.TERMINATED);
        // Зависания не должно быть.
        // Работа программы завершается по time out!
	}

}