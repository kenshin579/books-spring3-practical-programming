package madvirus.spring.chap05.board;

import madvirus.spring.chap05.board.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Article {

    private int id;
    private ArticleDao articleDao;

    public Article() {
    }

    public Article(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void increaseReadCount() {
        articleDao.updateReadCount(id, 1);
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

}
