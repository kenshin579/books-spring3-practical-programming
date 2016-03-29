package madvirus.spring.chap01.depinjection;

public class WriteArticleServiceImpl implements WriteArticleService {

    private ArticleDao articleDao;

    //note: 생성자에서 의존하는 객체를 전달받음
    public WriteArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void write(Article article) {
        System.out.println("WriteArticleServiceImpl.write() �޼��� ����");
        articleDao.insert(article);
    }

}
