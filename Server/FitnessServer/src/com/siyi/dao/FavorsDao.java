package com.siyi.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.siyi.entity.NewsListItem;
import com.siyi.utils.JdbcUtils;


public class FavorsDao {

	/** sql语句 */
	private String sql = "";
	
	/** QueryRunner */
	private QueryRunner queryRunner = JdbcUtils.getQueryRunnner();
	
	public List<NewsListItem> getCommentsList(String userId) {
		try {
			sql= "SELECT b.newsId, title, username FROM `user` a, news b, favors c WHERE c.userId = ? AND c.newsId = b.newsId AND b.userId = a.userId;";
			return queryRunner.query(sql, new BeanListHandler<NewsListItem>(NewsListItem.class), userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean isfavored(String userId, String newsId) {
		try {
			sql= "SELECT favorId FROM favors WHERE userId = ? AND newsId = ?;";
			return queryRunner.query(sql, new ScalarHandler<Integer>(), userId, newsId) != null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean addNewFavor(String userId, String newsId) {
		try {
			sql= "INSERT INTO favors (newsId, userId) VALUES (?, ?);";
			return queryRunner.update(sql, newsId, userId) > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
