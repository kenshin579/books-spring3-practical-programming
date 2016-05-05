package madvirus.spring.chap04.config;

import madvirus.spring.chap04.article.ArticleService;
import madvirus.spring.chap04.article.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleServiceConfig {

    @Autowired
    private ArticleRepositoryConfig repositoryConfig;

    @Bean
    public ArticleService articleService() {
        return new ArticleServiceImpl(repositoryConfig.articleRepository());
    }

}
