package madvirus.spring.chap04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ArticleServiceConfig.class, ArticleRepositoryConfig.class})
public class ArticleConfigWithImport {

}
