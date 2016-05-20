package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.ArticleService;
import madvirus.spring.chap06.service.NewArticleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public String form() {
        return "article/newArticleForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("command") NewArticleCommand command) {
        articleService.writeArticle(command);
        return "article/newArticleSubmitted";
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

}