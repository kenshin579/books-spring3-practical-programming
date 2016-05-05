package madvirus.spring.chap02;

import java.util.Map;

/**
 * Created by ykoh on 2016. 4. 15..
 */
public class ProtocolHandlerFactory {
    private Map<String, ProtocolHandler> handlers;

    public void setHandlers(Map<String, ProtocolHandler> handlers) {
        this.handlers = handlers;
    }
}
