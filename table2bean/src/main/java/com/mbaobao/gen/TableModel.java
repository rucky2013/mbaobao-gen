/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mbaobao.gen.entity.Table;
import com.mbaobao.gen.entity.TableColumn;
import com.mbaobao.gen.entity.TableColumnEnum;

/**
 *                       
 * @Filename TableModel.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author fred
 *
 * @Email kuci@mbaobao.com
 *       
 * @History
 *<li>Author: fred</li>
 *<li>Date: 2012-7-21</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class TableModel {
	
	private static final Logger	logger	= Logger.getLogger(TableModel.class);
	
	public static Table getTableInfo(String tableName) throws SQLException {
		logger.info("读取表信息:" + tableName);
		
		String sql = String.format("SELECT * FROM %s LIMIT 1", tableName);
		
		Statement st = DBConnection.getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		
		Table table = new Table(tableName);
		for (int i = 1, size = md.getColumnCount(); i <= size; i++) {
			String name = md.getColumnName(i);
			String columnType = md.getColumnTypeName(i);
			TableColumnEnum type = TableColumnEnum.VARCHAR;
			try {
				type = TableColumnEnum.getByCode(columnType);
			} catch (Exception e) {
				throw new RuntimeException("无法识字段类型：" + columnType);
			}
			TableColumn column = new TableColumn(name, type, 0);
			table.getColumns().add(column);
		}
		return table;
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(TableModel.getTableInfo("ac_user"));
	}
}