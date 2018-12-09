package com.weeklyreport.programmer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.weeklyreport.programmer.util.DbUtil;

/**
 * 
 * @author Chiho
 *基础dao，封装基本操作
 */
public class BaseDao {
	private com.weeklyreport.programmer.util.DbUtil dbUtil = new DbUtil();
	
	/**
	 *关闭数据库连接，释放资源
	 */
	public void closeCon() {
		dbUtil.closeCon();
	}
	
	/**
	 * 基础查询，多条查询
	 */
	public ResultSet query(String sql){
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			return prepareStatement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 改变数据库内容操作
	 */
	public boolean update(String sql) {
		try {
			return dbUtil.getConnection().prepareStatement(sql).executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Connection getConnection(){
		return dbUtil.getConnection();
	}
}



























