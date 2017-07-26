package com.xl.mybatis.service;

import org.apache.ibatis.session.SqlSession;

import com.xl.mybatis.entity.User;
import com.xl.mybatis.mapper.UserMapper;
import com.xl.mybatis.service.impl.UserService;
import com.xl.mybatis.util.MybatisUtil;

public class UserServiceImpl implements UserService {

	public void insert(User user) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insert(user);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
