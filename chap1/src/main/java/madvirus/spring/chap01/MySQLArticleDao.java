package madvirus.spring.chap01;

public class MySQLArticleDao implements ArticleDao {

    public void insert(Article article) {
        System.out.println("MySQLArticleDao.insert() ����");
    }

}
