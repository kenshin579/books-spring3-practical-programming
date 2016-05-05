package madvirus.spring.chap02;

public class MysqlArticleDao implements ArticleDao {

    public void insert(Article article) {
        System.out.println("MysqlArticleDao.insert() 실행");
    }

}
