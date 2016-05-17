package madvirus.spring.chap05.board.dao;

import madvirus.spring.chap05.board.Article;

public class MySQLArticleDao implements ArticleDao {

    @Override
    public void insert(Article article) {
        System.out.println("MySQLArticleDao.insert() ����");
    }

    @Override
    public void updateReadCount(int articleId, int inc) {
        System.out.println("MySQLArticleDao.updateReadCount() ����");
    }

}
