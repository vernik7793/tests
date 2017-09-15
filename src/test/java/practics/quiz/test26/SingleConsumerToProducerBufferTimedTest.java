package practics.quiz.test26;

import org.junit.Test;

/**
 * Producer put every 100 millisecond, timeout - 100 millisecond
 * Consumer get every 100 millisecond, timeout - 110 millisecond
 *
 */
public class SingleConsumerToProducerBufferTimedTest {

    @Test (timeout = 10000)
    public void testSingleConsumerToProducerBufferTimed() {
		SingleElementBufferTimed buffer = new SingleElementBufferTimed();
		long start = System.nanoTime();
        Thread producer = new Thread(new ProducerTimed(1, 100, buffer, 100), "Producer");
        producer.start();
		/** между запуском потоков образуется,
		* хоть и небольшой, временной разрыв (~0.00186595 millisecond)
		* плюс метод get тоже расходует время
		* 
		* получается, что граничных 10 милисекунд, не хватает для стабильной работы
		* 
		*/
        Thread consumer = new Thread(new ConsumerTimed(buffer, 110), "Consumer");
        consumer.start();
		System.out.println("finish " + (System.nanoTime() - start));

        while(!(producer.getState() == Thread.State.TERMINATED
                && consumer.getState() == Thread.State.TERMINATED));
        // Зависания не должно быть.
        // Работа программы завершается по time out!
	}
}