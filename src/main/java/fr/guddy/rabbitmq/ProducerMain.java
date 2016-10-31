package fr.guddy.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerMain extends AbstractMain {
    //region Main
    public static void main(final String[] pasArgv) throws IOException, TimeoutException, InterruptedException {
        final FanoutProducer loProducer = new FanoutProducer(HOST, EXCHANGE_NAME);
        for (int liIndex = 0; liIndex < 500; liIndex++) {
            loProducer.publishMessage("My message #" + liIndex);
            System.out.println("Thread #" + Thread.currentThread().getId() + " - message #" + liIndex + " sent to fanout");
            Thread.sleep(1000L);
        }
        loProducer.close();
    }
    //endregion
}
