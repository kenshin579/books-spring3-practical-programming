package madvirus.spring.chap05.board.service;

import madvirus.spring.chap05.board.Article;
import madvirus.spring.chap05.board.dao.ArticleDao;

public class WriteArticleServiceImpl implements WriteArticleService {

    private ArticleDao articleDao;

    public WriteArticleServiceImpl() {
    }

    public WriteArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void write(Article article) {
        System.out.println("WriteArticleServiceImpl.write() �޼��� ����");
        articleDao.insert(article);
    }

}
