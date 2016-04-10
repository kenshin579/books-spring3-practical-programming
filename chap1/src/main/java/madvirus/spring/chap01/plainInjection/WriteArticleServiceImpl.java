package madvirus.spring.chap01.plainInjection;

public class WriteArticleServiceImpl implements WriteArticleService {

    /*
    1.코드에 직접 의존 객체 명시
    - 단점: articleDao 멤버에 mock 객체를 할당할 수 없어서 WriteArticleServiceImpl 클래스를
     테스트하기 어려움
     private ArticleDao articleDao = new MySQLArticleDao();

     2.Factory 패턴이나 JNDI등을 사용
     private ArticleDao articleDao = ArticleDaoFactory.create();
     - 단점: WriteArticleSerivceImpl 클래스를 테스트하려면 Factory가 잘 동작을 해야 한다고 가정해야 함

     3. 의존 관계에 있는 객체가 아닌 외부의 조립기(객체 간의 의존 관계를 관리)를 사용
     */

    private ArticleDao articleDao;

    //DI 패턴을 적용할 경우 의존하는 객체를 전달받기 위한 설정메서드 (setter)나 생성자를 제공하면 됨
    public WriteArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void write(Article article) {
        System.out.println("WriteArticleServiceImpl.write() �޼��� ����");
        articleDao.insert(article);
    }

}
