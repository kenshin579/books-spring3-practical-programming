package madvirus.spring.chap04;

import madvirus.spring.chap04.article.ArticleService;
import madvirus.spring.chap04.config.ArticleConfigWithImport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigImport {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ArticleConfigWithImport.class);
        ArticleService articleService = context.getBean(ArticleService.class);
        articleService.writeArticle("title", "content");
    }
}
