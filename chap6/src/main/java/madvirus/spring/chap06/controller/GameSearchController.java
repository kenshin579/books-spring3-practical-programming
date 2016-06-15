package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.SearchCommand;
import madvirus.spring.chap06.service.SearchResult;
import madvirus.spring.chap06.service.SearchService;
import madvirus.spring.chap06.service.SearchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    /*
    todo: ModelAttribute은 뭐하는 거더라?
    - @ModelAtrribute 어노테이션이 적용된 메서드가 리턴한 모델 객체는 "searchTypeList"라는 이름으로 뷰에 전달됨
    참고
    - http://egloos.zum.com/springmvc/v/535572
     */
    @ModelAttribute("searchTypeList")
    public List<SearchType> referenceSearchTypeList() {
        System.out.println("referenceSearchTypeList");
        List<SearchType> options = new ArrayList<SearchType>();
        options.add(new SearchType(1, "Total"));
        options.add(new SearchType(2, "Item"));
        options.add(new SearchType(3, "Character"));
        return options;
    }

    @ModelAttribute("popularQueryList")
    public String[] getPopularQueryList() {
        System.out.println("getPopularQueryList");
        return new String[]{"Test1", "Hello", "Frank"};
    }

    @RequestMapping("/search/main.do")
    public String main() {
        return "search/main";
    }

    @RequestMapping("/search/mainModel.do")
    public String mainModel() {
        return "search/mainModel";
    }

    @RequestMapping("/search/mainModelMap.do")
    public String mainModelMap() {
        return "search/mainModelMap";
    }

    /*
    1. ModelAndView
     */
    @RequestMapping("/search/game.do")
    public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
        System.out.println("search");
        ModelAndView mav = new ModelAndView("search/game");
        System.out.println("Query = " + command.getQuery().toUpperCase());
        SearchResult result = searchService.search(command);
        mav.addObject("searchResult", result); //view에서 접근하는 객체
        return mav;
    }

    /*
    Map, Model 사용하는 경우
     */
    @RequestMapping("/search/gameModel.do")
    public Model searchModel(@ModelAttribute("command") SearchCommand command) {
        System.out.println("Query = " + command.getQuery().toUpperCase());
        Model model = new ExtendedModelMap();

        SearchResult result = searchService.search(command);
        model.addAttribute("searchResult", result); //view에서 접근하는 객체
        return model;
    }

    /*
    3.ModelMap 사용하는 경우
    - ModelMap를 생성해서 return하는 대신 컨트롤러 메서드의 파라미터를 통해서 전달받는다
     */
    @RequestMapping("/search/gameModelMap.do")
    public String searchModelMap(@ModelAttribute("command") SearchCommand command, ModelMap model) {
        System.out.println("Query = " + command.getQuery().toUpperCase());

        SearchResult result = searchService.search(command);
        model.addAttribute("searchResult", result);
        return null;
    }

    /*
    @RequestMapping 어노테이션이 적용된 메서드에서 @ExceptionHandler 어노테이션에서 지정한 타임의 예외가
    발생하면 @ExceptionHandler 어노테이션이 적용된 메서드를 이용해서 예외를 보여줄 뷰를 지정하게 된다
     */
    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException ex) {
        return "error/nullException";
    }

    public void setSearchService(SearchService searchService) {
        System.out.println("setSearchService");

        this.searchService = searchService;
    }

}
