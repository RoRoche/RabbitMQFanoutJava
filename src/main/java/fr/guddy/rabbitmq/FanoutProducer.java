package fr.guddy.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutProducer extends AbstractFanoutOwner {

    //region Constructor
    public FanoutProducer(final String psHost, final String psExchangeName) throws IOException, TimeoutException {
        super(psHost, psExchangeName);

    }
    //endregion

    //region Visible API
    public void publishMessage(final String psMessage) throws IOException {
        fanout.getChannel().basicPublish(fanout.exchangeName, "", null, psMessage.getBytes());
    }

    public void close() throws IOException {
        fanout.close();
    }
    //endregion
}
