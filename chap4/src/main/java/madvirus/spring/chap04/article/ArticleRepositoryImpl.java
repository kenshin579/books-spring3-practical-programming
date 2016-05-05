package madvirus.spring.chap04.article;

public class ArticleRepositoryImpl implements ArticleRepository {

    @Override
    public void save(Article article) {
        System.out.println("ArticleRepositoryImpl.save()");
    }

}
