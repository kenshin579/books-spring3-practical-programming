package madvirus.spring.chap01.depinjection;

public class MySQLArticleDao implements ArticleDao {

    public void insert(Article article) {
        System.out.println("MySQLArticleDao.insert() ����");
    }

}
