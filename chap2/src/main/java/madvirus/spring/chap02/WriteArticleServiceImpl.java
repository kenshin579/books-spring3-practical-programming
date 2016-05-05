package madvirus.spring.chap02;

public class WriteArticleServiceImpl implements WriteArticleService {

    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void write(Article article) {
        System.out.println("WriteArticleServiceImpl.write() 실행");
        articleDao.insert(article);
    }

}
