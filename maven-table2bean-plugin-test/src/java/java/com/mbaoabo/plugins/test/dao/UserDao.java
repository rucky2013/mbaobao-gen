/**
 * mbaobao.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.mbaoabo.plugins.test.dao;

import java.util.List;
import java.lang.Integer;
import org.apache.ibatis.annotations.Param;
import com.mbaoabo.plugins.test.bean.User;

/**
 *
 * This tools just a simple useful tools, gen table to javabean
 *
 * "I hope this tools can save your time"--kuci
 *
 * Generated by <tt>Tabl2Bean</tt> on 2012-08-14 21:33:00.603.
 *
 * @author kuci@mbaobao.com
 * @version v1.0 2012-08-14 21:33:00.603 $
 */

public interface UserDao {

	public Integer insert(User user);
	
	public Integer update(User user);
	
	public Integer getUserCount(User param);
	
	public List<User> findUsersByPage(@Param("param")User param,@Param("offset")Integer offset,@Param("rows")Integer rows);
	
	public Integer deleteByPrimary(Integer id);
	
}