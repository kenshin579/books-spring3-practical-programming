package madvirus.spring.chap04;

import madvirus.spring.chap04.article.ArticleService;
import madvirus.spring.chap04.config.ArticleRepositoryConfig;
import madvirus.spring.chap04.config.ArticleServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainArticleConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ArticleServiceConfig.class, ArticleRepositoryConfig.class);
        ArticleService articleService = context.getBean("articleService",
                ArticleService.class);
        articleService.writeArticle("title", "content");
    }
}
