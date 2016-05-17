package madvirus.spring.chap05;

import madvirus.spring.chap05.board.Article;
import madvirus.spring.chap05.board.service.ArticleNotFoundException;
import madvirus.spring.chap05.board.service.ReadArticleService;
import madvirus.spring.chap05.board.service.ReadArticleServiceImpl;
import madvirus.spring.chap05.board.service.WriteArticleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLTW {

    public static void main(String[] args) throws ArticleNotFoundException {
        String[] configLocations = new String[]{"acLTW.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);

        ReadArticleService readArticleService = new ReadArticleServiceImpl();
        readArticleService.getArticleAndIncreaseReadCount(10);

        WriteArticleService writeArticleService = context.getBean(
                "writeArticleService", WriteArticleService.class);
        writeArticleService.write(new Article());

        Article article = new Article();
        article.increaseReadCount();
        System.out.println("-----");
        article = new Article();
        article.increaseReadCount();
    }
}
