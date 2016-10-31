package fr.guddy.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerMain extends AbstractMain {
    //region Main
    public static void main(final String[] pasArgv) throws IOException, TimeoutException, InterruptedException {
        final FanoutConsumer loConsumer = new FanoutConsumer(HOST, EXCHANGE_NAME);
        final Thread loConsumerThread = new Thread(loConsumer);
        loConsumerThread.start();
    }
    //endregion
}
