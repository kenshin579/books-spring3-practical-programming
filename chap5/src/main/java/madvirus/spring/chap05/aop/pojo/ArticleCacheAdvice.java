package madvirus.spring.chap05.aop.pojo;

import madvirus.spring.chap05.board.Article;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;

public class ArticleCacheAdvice {

    private Map<Integer, Article> cache = new HashMap<Integer, Article>();

    public Article cache(ProceedingJoinPoint joinPoint) throws Throwable {
        Integer id = (Integer) joinPoint.getArgs()[0];
        Article article = cache.get(id);
        if (article != null) {
            System.out.println("[ACA] ĳ�ÿ��� Article[" + id + "] ����");
            return article;
        }
        Article ret = (Article) joinPoint.proceed();
        if (ret != null) {
            cache.put(id, ret);
            System.out.println("[ACA] ĳ�ÿ� Article[" + id + "] �߰���");
        }
        return ret;
    }
}
