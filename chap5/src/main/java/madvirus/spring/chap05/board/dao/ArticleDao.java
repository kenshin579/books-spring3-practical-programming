package madvirus.spring.chap05.board.dao;

import madvirus.spring.chap05.board.Article;

public interface ArticleDao {

    void insert(Article article);

    void updateReadCount(int id, int i);
}
