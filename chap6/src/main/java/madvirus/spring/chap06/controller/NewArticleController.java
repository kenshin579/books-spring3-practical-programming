package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.ArticleService;
import madvirus.spring.chap06.service.NewArticleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
todo: Spring 내부적으로 이게 어떻게 동작하는지 잘 모르겠다. Tomcat을 이해하면 이해가 될까?
 */
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public String form() {
        System.out.println("NewArticleController:form() -> GET");
        return "article/newArticleForm"; //todo: 왜 이름이 이런가? 의미가 있는 건가?
    }

    /*
    @ModelAttribute는 무엇을 하는 건가?
    - ModelAttribute 어노테이션을 이용해서 커맨드 객체의 모델 이름을 지정할 수 있다
      ㅁ. ${newArticleCommand.title} 대신 ${command.title}를 사용하겠다는 거임

    HTML 폼에 입력한 데이터를 자바빈 객체(ex.NewArticleCommand)를 전달받고 싶으면 파라미터로 추가하면 됨
    - 입력 항목의 이름은 같아야 함 (ex. parentId)
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("command") NewArticleCommand command) {
        System.out.println("NewArticleController:submit() -> POST");
        articleService.writeArticle(command);
        return "article/newArticleSubmitted";
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

}