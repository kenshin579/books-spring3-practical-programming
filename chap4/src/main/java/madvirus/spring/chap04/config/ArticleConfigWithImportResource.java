package madvirus.spring.chap04.config;

import madvirus.spring.chap04.article.ArticleRepository;
import madvirus.spring.chap04.article.ArticleService;
import madvirus.spring.chap04.article.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:/article-repository.xml"})
public class ArticleConfigWithImportResource {

    @Autowired
    private ArticleRepository articleRepository;

    @Bean
    public ArticleService articleService() {
        return new ArticleServiceImpl(articleRepository);
    }
}
