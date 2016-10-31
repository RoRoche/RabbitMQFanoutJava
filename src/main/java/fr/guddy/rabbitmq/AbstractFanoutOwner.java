package fr.guddy.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractFanoutOwner {
    //region Fields
    protected final Fanout fanout;
    //endregion

    //region Constructor
    protected AbstractFanoutOwner(final String psHost, final String psExchangeName) throws IOException, TimeoutException {
        this.fanout = new Fanout(psHost, psExchangeName);
    }
    //endregion
}
