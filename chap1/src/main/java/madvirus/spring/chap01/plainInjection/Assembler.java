package madvirus.spring.chap01.plainInjection;

/**
 * 역할
 * - MySQLArticleDao 객체를 생성함
 * - WriteArticleServiceImpl 객체에 전달(setter로)해주는 역할을 한다
 *
 */
public class Assembler {
    public WriteArticleService getWriteArticleService() {
        ArticleDao articleDao = new MySQLArticleDao();
        WriteArticleService service = new WriteArticleServiceImpl(articleDao);
        return service;
    }
}
