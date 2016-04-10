package madvirus.spring.chap1.plainInjection;

public class MySQLArticleDao implements ArticleDao {

    public void insert(Article article) {
        System.out.println("MySQLArticleDao.insert() 실행");
    }

}
