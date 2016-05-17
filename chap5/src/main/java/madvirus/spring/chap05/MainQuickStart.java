package madvirus.spring.chap05;

import madvirus.spring.chap05.board.Article;
import madvirus.spring.chap05.board.service.WriteArticleService;
import madvirus.spring.chap05.member.Member;
import madvirus.spring.chap05.member.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainQuickStart {

    public static void main(String[] args) {
        String[] configLocations = new String[]{"acQuickStart.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);

        WriteArticleService articleService = (WriteArticleService) context
                .getBean("writeArticleService");
        articleService.write(new Article());

        MemberService memberService = context.getBean("memberService",
                MemberService.class);
        memberService.regist(new Member());
    }
}
