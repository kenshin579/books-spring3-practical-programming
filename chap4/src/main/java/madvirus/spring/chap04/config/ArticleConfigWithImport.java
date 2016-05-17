package madvirus.spring.chap04.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
@Import를 이용해서 하나의 @Configuration 클래스에서 다수의 @Configuration 클래스를
묶을 수 있다.
 */
@Configuration
@Import({ArticleServiceConfig.class, ArticleRepositoryConfig.class})
public class ArticleConfigWithImport {

}
