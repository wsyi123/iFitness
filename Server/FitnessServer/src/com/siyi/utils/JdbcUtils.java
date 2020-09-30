package com.siyi.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Common JDBC operations. Tools.
 * 
 */
public class JdbcUtils {

	/** Initialize the connection pool */
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	/** Create DbUtils commonly used tool objects */
	
	/**
	 * get queryRunner。
	 * 
	 * @return
	 */
	public static QueryRunner getQueryRunnner() {
		return new QueryRunner(dataSource);
	}
	
	/**
	 * get dataSource。
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
}
