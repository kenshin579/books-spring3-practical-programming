package madvirus.spring.chap05.board.service;

import madvirus.spring.chap05.board.Article;

public class ReadArticleServiceImpl implements ReadArticleService {

    @Override
    public Article getArticleAndIncreaseReadCount(int id)
            throws ArticleNotFoundException {
        if (id == 0) {
            throw new ArticleNotFoundException();
        }
        return new Article(id);
    }

}
