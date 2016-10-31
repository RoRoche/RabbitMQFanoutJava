package fr.guddy.rabbitmq;

import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutConsumer extends AbstractFanoutOwner implements Runnable {

    //region Constructor
    public FanoutConsumer(final String psHost, final String psExchangeName) throws IOException, TimeoutException {
        super(psHost, psExchangeName);
    }
    //endregion

    //region Runnable
    public void run() {
        try {
            final String lsQueue = fanout.getChannel().queueDeclare().getQueue();
            fanout.getChannel().queueBind(lsQueue, fanout.exchangeName, "");

            final QueueingConsumer loQueueingConsumer = new QueueingConsumer(fanout.getChannel());
            fanout.getChannel().basicConsume(lsQueue, true, loQueueingConsumer);

            while (true) {
                final QueueingConsumer.Delivery loDelivery = loQueueingConsumer.nextDelivery();
                final String lsMessage = new String(loDelivery.getBody());
                System.out.println("Thread #" + Thread.currentThread().getId() + " received message: '" + lsMessage + "' from fanout");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //endregion
}
