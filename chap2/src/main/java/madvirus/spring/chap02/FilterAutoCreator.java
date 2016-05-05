package madvirus.spring.chap02;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by ykoh on 2016. 4. 23..
 */
public class FilterAutoCreator implements ApplicationContextAware {
    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public void init() {
        Map filterBeansMap = context.getBeansOfType(Filter.class);
        Iterator filteriter = filterBeansMap.values().iterator();
    }
}
