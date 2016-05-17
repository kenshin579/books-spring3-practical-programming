package madvirus.spring.chap04.article;

public class ArticleRepositoryImpl implements ArticleRepository {

    public void save(Article article) {
        System.out.println("ArticleRepositoryImpl.save()");
    }

}
