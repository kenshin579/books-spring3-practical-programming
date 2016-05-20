package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.SearchCommand;
import madvirus.spring.chap06.service.SearchResult;
import madvirus.spring.chap06.service.SearchService;
import madvirus.spring.chap06.service.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameSearchController {
    @Autowired
    private SearchService searchService;

    @ModelAttribute("searchTypeList")
    public List<SearchType> referenceSearchTypeList() {
        List<SearchType> options = new ArrayList<SearchType>();
        options.add(new SearchType(1, "��ü"));
        options.add(new SearchType(2, "������"));
        options.add(new SearchType(3, "ĳ����"));
        return options;
    }

    @ModelAttribute("popularQueryList")
    public String[] getPopularQueryList() {
        return new String[]{"����", "âõ2", "�����̵�"};
    }

    @RequestMapping("/search/main.do")
    public String main() {
        return "search/main";
    }

    @RequestMapping("/search/game.do")
    public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
        ModelAndView mav = new ModelAndView("search/game");
        System.out.println("�˻��� = " + command.getQuery().toUpperCase());
        SearchResult result = searchService.search(command);
        mav.addObject("searchResult", result);
        return mav;
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException ex) {
        return "error/nullException";
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

}
