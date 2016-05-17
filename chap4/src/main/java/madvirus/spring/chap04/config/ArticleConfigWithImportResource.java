package madvirus.spring.chap04.config;

import madvirus.spring.chap04.article.ArticleRepository;
import madvirus.spring.chap04.article.ArticleService;
import madvirus.spring.chap04.article.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*
일반적으로 XML 설정파일에서 @Configuration 클래스를 사용하는 방법이였다면 여기서는
@Configuration 클래스에서 XML 설정 파일을 사용할 수 있는 방법을 알려준다
- @ImportResource를 통해 @Configuration 설정 클래스에서 XML 사용하기
 */
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
