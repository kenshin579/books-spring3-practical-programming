package madvirus.spring.chap01.plainInjection;

public class MySQLArticleDao implements ArticleDao {

    public void insert(Article article) {
        System.out.println("MySQLArticleDao.insert() 실행");
    }

}
