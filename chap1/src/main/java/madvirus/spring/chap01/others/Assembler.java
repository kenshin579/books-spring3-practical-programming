package madvirus.spring.chap01.others;

/**
 * Created by ykoh on 2016. 3. 28..
 */
public class Assembler {
    public WriteArticleService getWriteArticleService() {
        ArticleDao articleDao = new MySQLArticleDao();
        WriteArticleService service = new WriteArticleServiceImpl(articleDao);
        return service;
    }
}
