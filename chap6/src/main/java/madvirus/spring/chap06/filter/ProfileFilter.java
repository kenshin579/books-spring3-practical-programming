package madvirus.spring.chap06.filter;

import madvirus.spring.chap06.common.CommonLogger;

import javax.servlet.*;
import java.io.IOException;

public class ProfileFilter implements Filter {

    private CommonLogger commonLogger;

    @Override
    public void destroy() {
        commonLogger.log("ProfileFilter.destroy() ȣ���");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } finally {
            long finish = System.currentTimeMillis();
            commonLogger.log("���� �ð� : " + (finish - start));
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        commonLogger.log("ProfileFilter.init() ȣ���");
    }

    public void setCommonLogger(CommonLogger commonLogger) {
        this.commonLogger = commonLogger;
    }

}
