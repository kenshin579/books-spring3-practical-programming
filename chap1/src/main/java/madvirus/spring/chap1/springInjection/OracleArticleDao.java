package madvirus.spring.chap1.springInjection;

/**
 * Created by ykoh on 2016. 3. 28..
 */
public class OracleArticleDao implements ArticleDao {
    public void insert(Article article) {
        System.out.println("OracleArticleDao.insert() 실행");
    }
}
