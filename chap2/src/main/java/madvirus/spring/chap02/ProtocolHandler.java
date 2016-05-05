package madvirus.spring.chap02;

import java.util.List;

/**
 * Created by ykoh on 2016. 4. 15..
 */
public class ProtocolHandler {
    private List<Filter> filters;

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }
}
