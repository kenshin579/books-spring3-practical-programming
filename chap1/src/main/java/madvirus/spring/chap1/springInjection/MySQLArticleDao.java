package madvirus.spring.chap1.springInjection;

public class MySQLArticleDao implements ArticleDao {

    public void insert(Article article) {
        System.out.println("MySQLArticleDao.insert() 삽입 실행");
    }

}
