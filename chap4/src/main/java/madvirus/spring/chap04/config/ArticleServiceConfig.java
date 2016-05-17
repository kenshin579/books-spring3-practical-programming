package madvirus.spring.chap04.config;

import madvirus.spring.chap04.article.ArticleService;
import madvirus.spring.chap04.article.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleServiceConfig {

    //다른 설정에서 정의한 빈에 의존함
    @Autowired
    private ArticleRepositoryConfig repositoryConfig;

    @Bean
    public ArticleService articleService() {
        return new ArticleServiceImpl(repositoryConfig.articleRepository());
    }

}
