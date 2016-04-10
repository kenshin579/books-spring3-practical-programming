package madvirus.spring.chap02;

public class WriteArticleServiceImpl implements WriteArticleService {

    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void write(Article article) {
        System.out.println("WriteArticleServiceImpl.write() �޼��� ����");
        articleDao.insert(article);
    }

}
