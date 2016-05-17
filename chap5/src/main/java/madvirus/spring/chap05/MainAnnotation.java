package madvirus.spring.chap05;

import madvirus.spring.chap05.board.Article;
import madvirus.spring.chap05.board.service.ArticleNotFoundException;
import madvirus.spring.chap05.board.service.ReadArticleService;
import madvirus.spring.chap05.member.service.MemberService;
import madvirus.spring.chap05.member.service.UpdateInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {

    public static void main(String[] args) {
        String[] configLocations = new String[]{"acAnnotation.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);

        ReadArticleService readArticleService = context.getBean(
                "readArticleService", ReadArticleService.class);
        try {
            Article article1 = readArticleService
                    .getArticleAndIncreaseReadCount(1);
            Article article2 = readArticleService
                    .getArticleAndIncreaseReadCount(1);
            System.out.println("article1 == article2 : "
                    + (article1 == article2));
            readArticleService.getArticleAndIncreaseReadCount(0);
        } catch (ArticleNotFoundException e) {
        }

        MemberService memberService = context.getBean("memberService",
                MemberService.class);
        memberService.update("madvirus", new UpdateInfo());
    }
}
